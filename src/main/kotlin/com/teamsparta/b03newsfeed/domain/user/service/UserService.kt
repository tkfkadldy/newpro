package com.teamsparta.b03newsfeed.domain.user.service

import com.teamsparta.b03newsfeed.domain.user.dto.SignRequest
import com.teamsparta.b03newsfeed.domain.user.dto.UpdateUserProfileRequest
import com.teamsparta.b03newsfeed.domain.user.dto.UserResponse

interface UserService {

    fun signUp(request: SignRequest): UserResponse

    fun signIn(request: SignRequest): UserResponse

    fun updateUserProfile(userId: Long, request: UpdateUserProfileRequest): UserResponse

    fun signOut(userId: Long, request: SignRequest): UserResponse

}