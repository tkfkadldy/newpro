package com.teamsparta.b03newsfeed.domain.comment.service

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.exception.CommentNotFoundException
import com.teamsparta.b03newsfeed.domain.comment.model.toResponse
import com.teamsparta.b03newsfeed.domain.comment.repository.CommentRepository
import com.teamsparta.b03newsfeed.domain.post.repository.PostRepository
import com.teamsparta.b03newsfeed.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


//댓글 서비스를 구현하는 클래스
//@Service 애노테이션을 사용하여 Spring Bean으로 등록
//CommentRepository, PostRepository, UserRepository를 주입받아 댓글, 게시물, 사용자 정보에 접근
//CommentService 인터페이스를 구현하여 댓글 관련 서비스를 제공
//지정된 게시물의 모든 댓글 목록을 조회
//지정된 게시물의 특정 댓글을 조회
//새로운 댓글을 생성
//기존 댓글을 수정
//특정 댓글을 삭제

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,
    private val userRepository: UserRepository

) : CommentService {

    override fun getAllCommentList(postId: Long): List<CommentResponse> {

        val post = postRepository.findByIdOrNull(postId) ?: throw CommentNotFoundException("post", postId)
        return post.comments.map { it.toResponse() }
    }

    override fun getCommentById(postId: Long, commentId: Long): CommentResponse {

        val comment = commentRepository.findByPostIdAndId(postId, commentId)
            ?: throw CommentNotFoundException("Comment", commentId)
        return comment.toResponse()

    }

    @Transactional
    override fun createComment( postId: Long, request: CreateCommentRequest): CommentResponse {
        val post = postRepository.findByIdOrNull(postId) ?: throw CommentNotFoundException("post", postId)
        val user = userRepository.findByIdOrNull(request.userId) ?: throw CommentNotFoundException("user", request.userId)
        val comment = com.teamsparta.b03newsfeed.domain.comment.model.Comment(
            description = request.description,
            post = post,
            user = user
          //  JWT
        )
        post.createComment(comment)
        postRepository.save(post)
        return comment.toResponse()
    }

    @Transactional
    override fun updateComment(postId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {

        val comment = commentRepository.findByPostIdAndId(postId, commentId)
            ?: throw CommentNotFoundException("Comment", commentId)

        val (description) = request
        comment.description = description
        return commentRepository.save(comment).toResponse()
    }

    @Transactional
    override fun deleteComment(postId: Long, commentId: Long) {

        val post = postRepository.findByIdOrNull(postId) ?: throw CommentNotFoundException("Post", postId)
        val comment = commentRepository.findByIdOrNull(commentId)
            ?: throw CommentNotFoundException("Comment", commentId)

        post.deleteComment(comment)
        postRepository.save(post)
    }
}