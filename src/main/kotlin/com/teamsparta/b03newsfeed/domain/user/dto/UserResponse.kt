package com.teamsparta.b03newsfeed.domain.user.dto

data class UserResponse(
    val id: Long,
    val email: String,
    val nickname: String,
    val role: String,
//    val introduce: String,
)
