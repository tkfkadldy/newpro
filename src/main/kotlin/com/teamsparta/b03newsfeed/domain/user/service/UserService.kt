package com.teamsparta.b03newsfeed.domain.user.service

import com.teamsparta.b03newsfeed.domain.user.dto.*

interface UserService {

    fun getUserProfileById(UserId: Long): UserResponse

    fun signUp(request: SignUpRequest): UserResponse

    fun updateUserProfile(userId: Long, updateUserProfileRequest: UpdateUserProfileRequest): UserResponse

    fun login(request: LoginRequest): LoginResponse
}