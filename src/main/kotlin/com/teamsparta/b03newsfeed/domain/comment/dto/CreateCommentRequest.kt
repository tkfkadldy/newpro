package com.teamsparta.b03newsfeed.domain.comment.dto



data class CreateCommentRequest(
    val userId: Long,
    val postId: Long,
    val description:String,
)
