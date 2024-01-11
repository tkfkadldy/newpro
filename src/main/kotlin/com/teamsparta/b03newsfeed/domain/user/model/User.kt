package com.teamsparta.b03newsfeed.domain.user.model

import com.teamsparta.b03newsfeed.B03newsfeedApplication
import com.teamsparta.b03newsfeed.domain.comment.model.Comment
import com.teamsparta.b03newsfeed.domain.post.model.Post
import com.teamsparta.b03newsfeed.domain.user.dto.UserResponse
import jakarta.persistence.*

@Entity
@Table(name = "app_user")
class User(

    @Column(name= "email", nullable = false)
    val email: String,

    @Column(name= "password", nullable = false)
    val password: String,

    @Embedded
    var profile: Profile,

    @Enumerated(EnumType.STRING)
    @Column(name= "role", nullable = false)
    val role: UserRole,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var posts: MutableList<Post> = mutableListOf(),

    @OneToMany( cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
    var comments: MutableList<Comment> = mutableListOf(),

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var user_id: Long? = null

}

fun User.toResponse(): UserResponse {
    return UserResponse(
        user_id = user_id!!,
        nickname = profile.nickname,
        email = email,
        role = role.name,
        introduce = profile.introduce
    )
}
// 에러``````````````````````````````````````````````````````````````````````````````````````````````````````````