package com.teamsparta.b03newsfeed.domain.post.dto

data class CreatePostRequest(
    val title: String,
    val content: String,
    val tag: String,
    val imageUrl: String
)