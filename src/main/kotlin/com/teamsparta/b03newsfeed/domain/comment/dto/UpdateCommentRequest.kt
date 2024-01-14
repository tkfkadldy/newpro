package com.teamsparta.b03newsfeed.domain.comment.dto


//기존 댓글을 수정하기 위한 요청 데이터 클래스
//description: 수정된 댓글의 내용입니다.
data class UpdateCommentRequest(

    val description: String,
)
