package com.teamsparta.b03newsfeed.domain.comment.service

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl :CommentService{
    override fun getAllCommentList(): List<CommentResponse> {
        TODO("Not yet implemented")
    }

    override fun getCommentById(commentId: Long): CommentResponse {
        TODO("Not yet implemented")
    }

    override fun createComment(request: CreateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }

    override fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }

    override fun deleteComment(commentId: Long) {
        TODO("Not yet implemented")
    }
}