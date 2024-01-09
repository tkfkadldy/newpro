package com.teamsparta.b03newsfeed.domain.comment.service

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.exception.CommentNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl : CommentService {
    override fun getAllCommentList(): List<CommentResponse> {
        TODO("Not yet implemented")
    }

    override fun getCommentById(commentId: Long): CommentResponse {
        throw CommentNotFoundException(commentName = "Comment", commentId = 1L )
    }

    @Transactional
    override fun createComment(request: CreateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun deleteComment(commentId: Long) {
        TODO("Not yet implemented")
    }
}