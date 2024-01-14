package com.teamsparta.b03newsfeed.domain.comment.dto

import java.time.LocalDateTime

//댓글 정보를 저장하고 전달하기 위한 데이터 클래스
//id: 댓글의 고유 식별자입니다.
//description: 댓글의 내용입니다.
//createAt: 댓글이 생성된 날짜와 시간입니다.
//updateAt: 댓글이 마지막으로 수정된 날짜와 시간입니다.
data class CommentResponse(

    val id: Long,
    val description: String,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime

)
