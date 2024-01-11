package com.teamsparta.b03newsfeed.domain.post.dto

data class PostResponse(
    val postId: Long,
    val title: String,
    val content: String,
    val tag: String,
    val imageUrl: String,
)

//post