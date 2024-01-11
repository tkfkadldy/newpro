package com.teamsparta.b03newsfeed.domain.comment.service

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest

interface CommentService {
    fun getAllCommentList(postId: Long): List<CommentResponse>

    fun getCommentById(postId: Long, commentId: Long): CommentResponse

    fun createComment( userId:Long, postId: Long, request: CreateCommentRequest): CommentResponse

    fun updateComment(postId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment(postId: Long, commentId: Long)

}