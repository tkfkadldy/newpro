package com.teamsparta.b03newsfeed.domain.comment.service

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.exception.CommentNotFoundException
import com.teamsparta.b03newsfeed.domain.comment.repository.CommentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository
) : CommentService {

    override fun getAllCommentList(postId: Long): List<CommentResponse> {
        TODO()

        // val post = commentRepository.findByIdOrNull(postId)?: throw CommentNotFoundException("post",postId)
        // return post.comment.map{it.toResponse()}
    }

    override fun getCommentById(postId: Long, commentId: Long): CommentResponse {
        TODO()
        // val comment = commentRepository.findByPostIdAndId(postId,commentId)
        //     ?: throw CommentNotFoundException("Comment",commentId)
        //  return comment.toRespose()

    }

    @Transactional
    override fun createComment(postId: Long, request: CreateCommentRequest): CommentResponse {
        val post = commentRepository.findByIdOrNull(postId)?:throw CommentNotFoundException("post",postId)

        TODO()
/*
        val comment = Comment(
            arthur = request.arthur,
            description = request.description,
            post = post
        )
        post.createComment(comment)
        commentRepository.save(post)
        return comment.toResponse()
*/

    }

    @Transactional
    override fun updateComment(postId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {

        TODO()

/*        val comment = commentRepository.findPostIdAndId(postId,commentId)
            ?: throw CommentNotFoundException("Comment",commentId)
        val (arthur,description) = request
        comment.arthur = arthur
        comment.description = description
        return commentRepository.save<Comment?>(comment).toResponse()*/
    }

    @Transactional
    override fun deleteComment(postId: Long, commentId: Long) {

        TODO()
/*        val post = CommentRepository.findByIdOrNull(postId) ?: throw CommentNotFoundException("Post",postId)
        val comment = CommentRepository.findByIdOrNull(commentId)
            ?: throw CommentNotFoundException("Comment",commentId)

        post.removeComment(comment)
        CommentRepository.save(post)*/
    }
}