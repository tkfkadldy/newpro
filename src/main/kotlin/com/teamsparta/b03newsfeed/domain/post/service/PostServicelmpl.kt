package com.teamsparta.b03newsfeed.domain.post.service

import com.teamsparta.b03newsfeed.domain.comment.repository.CommentRepository
import com.teamsparta.b03newsfeed.domain.post.dto.CreatePostRequest
import com.teamsparta.b03newsfeed.domain.post.dto.PostResponse
import com.teamsparta.b03newsfeed.domain.post.dto.UpdatePostRequest
import com.teamsparta.b03newsfeed.domain.post.exception.PostNotFoundException
import com.teamsparta.b03newsfeed.domain.post.model.Post
import com.teamsparta.b03newsfeed.domain.post.repository.PostRepository
import com.teamsparta.b03newsfeed.domain.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostServicelmpl(
    private val postRepository: PostRepository,
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository,
) {
    override fun getAllPostList(): List<PostResponse> {
        return postRepository.findAll().map { it.toResponse() }
    }
    override fun getPostById(postId: Long): PostResponse {
        val post = postRepository.findByIdOrNull(postId) ?: throw PostNotFoundException("Post", postId)
        return post.toResponse()

    }

    @Transactional
    override fun createPost(request: CreatePostRequest): PostResponse {
        return postRepository.save(
            Post(
                title = request.title,
                content = request.content,
            )
        ).toResponse()
    }
    @Transactional
    override fun updatePost(postId: Long, request: UpdatePostRequest): PostResponse {
        val post = postRepository.findByIdOrNull(postId) ?: throw PostNotFoundException("Post", postId)
        val (title, content) = request

        post.title = title
        post.content = content
        post.image = image
        post.tag = tag

        return postRepository.save(post).toResponse()
    }

    @Transactional
    override fun deletePost(postId: Long) {
        val course = postRepository.findByIdOrNull(postId) ?: throw PostNotFoundException("Post", postId)
        postRepository.delete(course)
    }


}