package com.teamsparta.b03newsfeed.domain.likecomment.repository


import com.teamsparta.b03newsfeed.domain.likecomment.model.LikePost
import com.teamsparta.b03newsfeed.domain.post.model.Post
import com.teamsparta.b03newsfeed.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


// LikePost 엔티티에 대한 데이터 접근을 제공하는 인터페이스
interface LikePostRepository : JpaRepository<LikePost, Long>{
    // 특정 사용자와 게시물에 대한 좋아요를 조회하는 메서드
    fun findByUserAndPost(user: User, post: Post): Optional<LikePost>

}