package com.teamsparta.b03newsfeed.domain.comment.dto



data class CreateCommentRequest(

    val userId:Long,
    val description:String,
)
