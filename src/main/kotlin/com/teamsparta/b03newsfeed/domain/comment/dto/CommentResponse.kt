package com.teamsparta.b03newsfeed.domain.comment.dto

import java.time.LocalDateTime

data class CommentResponse(


    val description:String,
    val createAt: LocalDateTime,
    val updateAt:LocalDateTime

)
