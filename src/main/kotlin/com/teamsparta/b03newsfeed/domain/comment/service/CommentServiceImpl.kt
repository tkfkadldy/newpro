package com.teamsparta.b03newsfeed.domain.comment.service

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.exception.CommentNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl : CommentService {

    override fun getAllCommentList(postId: Long): List<CommentResponse> {
        TODO("Not yet implemented")
    }

    override fun getCommentById(postId: Long, commentId: Long): CommentResponse {
        TODO("Not yet implemented")
    }
@Transactional
    override fun createComment(postId: Long, request: CreateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }
@Transactional
    override fun updateComment(postId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }
@Transactional
    override fun deleteComment(postId: Long, commentId: Long) {
        TODO("Not yet implemented")
    }
}