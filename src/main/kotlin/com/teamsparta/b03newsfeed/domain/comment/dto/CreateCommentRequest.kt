package com.teamsparta.b03newsfeed.domain.comment.dto

//새로운 댓글을 생성하기 위한 요청 데이터 클래스
//userId: 댓글을 생성한 사용자의 ID입니다.
//description: 댓글의 내용입니다.
data class CreateCommentRequest(
    val userId: Long,
    val description:String,
)
