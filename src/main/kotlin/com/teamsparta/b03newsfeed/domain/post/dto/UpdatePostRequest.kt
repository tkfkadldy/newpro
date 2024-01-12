package com.teamsparta.b03newsfeed.domain.post.dto

data class UpdatePostRequest(
    val title: String,
    val content: String,
    val tag: String,
    val imageUrl: String
)