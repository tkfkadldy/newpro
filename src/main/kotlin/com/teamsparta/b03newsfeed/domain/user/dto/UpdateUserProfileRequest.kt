package com.teamsparta.b03newsfeed.domain.user.dto

data class UpdateUserProfileRequest(
    val password: String,
    val nickname: String,
    val introduce: String,
//    val image: String, // Controller에서 MultipartFile 기능?
)
