package com.teamsparta.b03newsfeed.domain.likecomment.model

import com.teamsparta.b03newsfeed.domain.likecomment.dto.LikePostResponse
import com.teamsparta.b03newsfeed.domain.post.model.Post
import com.teamsparta.b03newsfeed.domain.user.model.User
import jakarta.persistence.*

//LikePost 엔티티를 정의하고 관리하는 클래스

@Entity
@Table(name = "like_post")
class LikePost(

    // 좋아요가 해당되는 게시물

    @ManyToOne
    @JoinColumn(name = "post_id")
    val post: Post,


    // 좋아요를 누른 사용자

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User

) {

    // 좋아요의 고유 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    val id: Long? = null

    // LikePost 인스턴스를 쉽게 생성하기 위한 빌더
    companion object {
        fun builder() = LikePostBuilder()
    }

}


// toResponse() 메서드는 LikePost 객체를 LikePostResponse DTO로 변환합니다.
// id 속성은 LikePostResponse DTO의 id 속성에 할당됩니다.

fun LikePost.toResponse(): LikePostResponse {
    return LikePostResponse(
        id = id!!,


    )
}

//LikePostBuilder 클래스는 LikePost 객체를 쉽게 생성하기 위한 빌더 클래스입니다.
//post 속성과 user 속성은 각각 Post 엔티티와 User 엔티티의 인스턴스를 저장합니다.
//build() 메서드는 LikePost 객체를 생성하고 반환합니다
class LikePostBuilder {

    private lateinit var post: Post
    private lateinit var user: User

    fun post(post: Post) = apply {
        this.post = post
    }

    fun user(user: User) = apply {
        this.user = user
    }

    fun build() = LikePost(
        post = post,
        user = user,
    )
}

