package com.teamsparta.b03newsfeed.domain.comment.exception


//댓글을 찾을 수 없을 때 발생하는 예외 클래스
data class CommentNotFoundException(val commentName:String ,val commentId:Long)
    : RuntimeException(" $commentName not found with given id: $commentId")

