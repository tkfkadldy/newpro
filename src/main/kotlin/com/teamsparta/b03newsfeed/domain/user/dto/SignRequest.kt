package com.teamsparta.b03newsfeed.domain.user.dto

data class SignRequest(
    val email: String,
    val nickname: String,
    val password: String,
)
