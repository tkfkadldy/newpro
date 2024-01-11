package com.teamsparta.b03newsfeed.domain.comment.dto

import java.time.LocalDateTime

data class CommentResponse(

    val id: Long,
    val description: String,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime

)
