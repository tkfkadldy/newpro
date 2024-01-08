package com.teamsparta.b03newsfeed.domain.comment.service

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest

interface CommentService {
    fun getAllCommentList():List<CommentResponse>

    fun getCommentById(commentId:Long):CommentResponse

    fun createComment(request: CreateCommentRequest):CommentResponse

    fun updateComment(commentId: Long ,request: UpdateCommentRequest):CommentResponse

    fun deleteComment(commentId: Long)

}