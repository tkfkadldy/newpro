package com.teamsparta.b03newsfeed.domain.likecomment.service

import com.teamsparta.b03newsfeed.domain.likecomment.dto.LikePostRequest
import com.teamsparta.b03newsfeed.domain.likecomment.exception.LikeNotFoundException
import com.teamsparta.b03newsfeed.domain.likecomment.model.LikePost
import com.teamsparta.b03newsfeed.domain.likecomment.repository.LikePostRepository
import com.teamsparta.b03newsfeed.domain.post.repository.PostRepository
import com.teamsparta.b03newsfeed.domain.user.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

// LikePostService 인터페이스의 구현하는 클래스
// @Service 애노테이션은 이 클래스를 Spring Boot의 서비스로 등록
// 생성자를 통해 LikePostRepository, UserRepository, PostRepository를 주입
@Service
class LikePostServiceImpl(
    private val likePostRepository: LikePostRepository,
    private val userRepository: UserRepository,
    private val postRepository: PostRepository
) : LikePostService {

    // 좋아요를 추가하는 메서드

    @Transactional
    override fun insert(likePostRequest: LikePostRequest) {

        // 요청에서 사용자 ID와 게시물 ID를 가져온다
        // 사용자와 게시물을 조회
        // 사용자가 없으면 LikeNotFoundException 발생
        // 게시물이 없으면 LikeNotFoundException 발생시킵니다.

        val userId = likePostRequest.userId
        val user = userRepository.findById(userId)
            .orElseThrow {
                LikeNotFoundException("Could not find user id: $userId")
            }
        val postId = likePostRequest.postId
        val post = postRepository.findById(postId)
            .orElseThrow { LikeNotFoundException("Could not find post id: $postId") }

        // 이미 좋아요되어있으면 에러 반환
        if (likePostRepository.findByUserAndPost(user, post).isPresent) {
            throw ResponseStatusException(
                HttpStatus.CONFLICT,
                "Already exist data by user id: ${user.user_id}, post id: ${post.id}"
            )
        }
        // LikePost 객체를 생성하고 저장
        val likePost = LikePost.builder()
            .post(post)
            .user(user)
            .build()
        likePostRepository.save(likePost)
        // 게시물의 좋아요 수를 업데이트하고 저장
        if (post.likeCount == null) {
            post.likeCount = 1
        } else {
            post.likeCount = post.likeCount!! + 1
        }
        postRepository.save(post)
    }

    @Transactional
    override fun delete(likePostRequest: LikePostRequest) {
        // 요청에서 사용자 ID와 게시물 ID를 가져온다
        // 사용자와 게시물, LikePost 객체를 조회

        val user = userRepository.findById(likePostRequest.userId)
            .orElseThrow { LikeNotFoundException("Could not find user id: ${likePostRequest.userId}") }
        val post = postRepository.findById(likePostRequest.postId)
            .orElseThrow { LikeNotFoundException("Could not find post id: ${likePostRequest.postId}") }
        val likePost = likePostRepository.findByUserAndPost(user, post)
            .orElseThrow { LikeNotFoundException("Could not find likepost id") }

        // LikePost 객체를 삭제

        likePostRepository.delete(likePost)

        // 게시물의 좋아요 수를 업데이트하고 저장

        if (post.likeCount == null) {
            post.likeCount = 0
        } else {
            post.likeCount = post.likeCount!! - 1
        }
        postRepository.save(post)
    }
}



