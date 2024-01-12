package com.teamsparta.b03newsfeed.domain.comment.exception

data class CommentNotFoundException(val commentName: String, val commentId: Long) :
    RuntimeException(" $commentName not found with given id: $commentId")

