package com.teamsparta.b03newsfeed.domain.comment.service

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest


//댓글과 관련된 서비스를 제공하는 인터페이스
//이 인터페이스는 댓글 조회, 생성, 수정, 삭제와 같은 주요 기능을 정의.

interface CommentService {
    fun getAllCommentList(postId: Long): List<CommentResponse>

    fun getCommentById(postId: Long, commentId: Long): CommentResponse

    fun createComment( postId: Long, request: CreateCommentRequest): CommentResponse

    fun updateComment(postId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment(postId: Long, commentId: Long)

}