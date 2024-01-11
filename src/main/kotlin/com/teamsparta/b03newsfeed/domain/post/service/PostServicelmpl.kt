package com.teamsparta.b03newsfeed.domain.post.service

//import com.teamsparta.b03newsfeed.domain.comment.repository.CommentRepository
import com.teamsparta.b03newsfeed.domain.post.dto.CreatePostRequest
import com.teamsparta.b03newsfeed.domain.post.dto.PostResponse
import com.teamsparta.b03newsfeed.domain.post.dto.TagResponse
import com.teamsparta.b03newsfeed.domain.post.dto.UpdatePostRequest
import com.teamsparta.b03newsfeed.domain.post.exception.PostNotFoundException
import com.teamsparta.b03newsfeed.domain.post.model.Post
import com.teamsparta.b03newsfeed.domain.post.model.toResponse
import com.teamsparta.b03newsfeed.domain.post.repository.PostRepository
import com.teamsparta.b03newsfeed.domain.post.repository.TagRepository
// com.teamsparta.b03newsfeed.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostServiceImpl(
    private val postRepository: PostRepository,
    private val tagRepository: TagRepository,
    //private val commentRepository: CommentRepository,
    //private val userRepository: UserRepository,
) :PostService {

    override fun getPostList(): List<PostResponse> {
        return postRepository.findAll().map { it.toResponse() }
    }
    override fun getPost(postId: Long): PostResponse {
        val post = postRepository.findByIdOrNull(postId) ?: throw PostNotFoundException("Post", postId)
        return post.toResponse()

    }
    @Transactional
    override fun createPost(request: CreatePostRequest): PostResponse {
        return postRepository.save(
            Post(
                title = request.title,
                content = request.content,
                imageUrl = request.imageUrl,
                tag = request.tag
            )
        ).toResponse()
    }
    @Transactional
    override fun updatePost(postId: Long, request: UpdatePostRequest): PostResponse {
        val post = postRepository.findByIdOrNull(postId) ?: throw PostNotFoundException("Post", postId)
        val (title, content,image,posttag) = request

        post.title = title
        post.content = content
        post.imageUrl = image
        post.tag = posttag

        return postRepository.save(post).toResponse()
    }

    @Transactional
    override fun deletePost(postId: Long) {
        val post = postRepository.findByIdOrNull(postId) ?: throw PostNotFoundException("Post", postId)
        postRepository.delete(post)
    }

    override fun getTag(id: Long): TagResponse {
        TODO()
        //return tagRepository.save(id).toResponse()
    }

}