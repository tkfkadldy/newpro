package com.teamsparta.b03newsfeed.domain.user.service

import com.teamsparta.b03newsfeed.domain.user.dto.*
import com.teamsparta.b03newsfeed.domain.user.exception.InvalidCredentialException
import com.teamsparta.b03newsfeed.domain.user.exception.ModelNotFoundException
import com.teamsparta.b03newsfeed.domain.user.model.Profile
import com.teamsparta.b03newsfeed.domain.user.model.User
import com.teamsparta.b03newsfeed.domain.user.model.UserRole
import com.teamsparta.b03newsfeed.domain.user.model.toResponse
import com.teamsparta.b03newsfeed.domain.user.repository.UserRepository
import com.teamsparta.b03newsfeed.infra.security.jwt.JwtPlugin
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) : UserService {

    override fun getUserProfileById(userId: Long): UserResponse {
        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)
        return user.toResponse()
    }

    override fun login(request: LoginRequest): LoginResponse {
        val user = userRepository.findByEmail(request.email) ?: throw ModelNotFoundException("User", null)

        if (user.role.name != request.role || !passwordEncoder.matches(request.password, user.password)) {
            throw InvalidCredentialException()
        }

        return LoginResponse(
            accesToken = jwtPlugin.generateAccesToken(
                subject = user.user_id.toString(),
                email = user.email,
                role = user.role.name
            )
        )
    }

    override fun signUp(request: SignUpRequest): UserResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalStateException("이미 사용되고 있는 이메일입니다")
        }

        return userRepository.save(
            User(
                email = request.email,
                password = passwordEncoder.encode(request.password),
                profile = Profile(
                    nickname = request.nickname,
                    introduce = request.introduce
                ),
                role = when (request.role) {
                    "User" -> UserRole.User
                    "Admin" -> UserRole.Admin
                    else -> throw IllegalArgumentException("Invalid role")
                },
                certification = "-1"
            )
        ).toResponse()
    }

    override fun updateUserProfile(userId: Long, updateUserProfileRequest: UpdateUserProfileRequest): UserResponse {
        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)
        user.profile = Profile(
            nickname = updateUserProfileRequest.nickname,
            introduce = updateUserProfileRequest.introduce
        )

        return userRepository.save(user).toResponse()
    }
}