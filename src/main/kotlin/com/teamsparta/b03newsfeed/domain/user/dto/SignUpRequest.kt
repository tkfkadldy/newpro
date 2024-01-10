package com.teamsparta.b03newsfeed.domain.user.dto

data class SignUpRequest(
    val email: String,
    val password: String,
    val nickname: String,
//    val role: String
)
