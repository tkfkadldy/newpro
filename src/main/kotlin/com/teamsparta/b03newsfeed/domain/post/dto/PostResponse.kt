package com.teamsparta.b03newsfeed.domain.post.dto

data class PostResponse(
    val id: Long,
    val title: String?,
    val content: String?,
    val tag: String,
    val image: String
)

//post