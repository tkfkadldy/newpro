package com.teamsparta.b03newsfeed.domain.user.service

import com.teamsparta.b03newsfeed.domain.user.dto.SignRequest
import com.teamsparta.b03newsfeed.domain.user.dto.UpdateUserProfileRequest
import com.teamsparta.b03newsfeed.domain.user.dto.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(

) : UserService {

    @Transactional
    override fun signUp(request: SignRequest): UserResponse {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun signIn(request: SignRequest): UserResponse {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateUserProfile(userId: Long, request: UpdateUserProfileRequest): UserResponse {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun signOut(userId: Long, request: SignRequest): UserResponse {
        TODO("Not yet implemented")
    }
}