package com.teamsparta.b03newsfeed.domain.user.exception

data class ModelNotFoundException(val User: String, val userId: Long?): RuntimeException(
    "Model $User not found with give id: $userId"
)
