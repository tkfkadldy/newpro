package com.teamsparta.b03newsfeed.domain.post.model

import com.teamsparta.b03newsfeed.domain.comment.model.Comment
import com.teamsparta.b03newsfeed.domain.post.dto.PostResponse
import com.teamsparta.b03newsfeed.domain.user.model.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "post")
class Post(

    @Column(name="title")
    var title: String,

    @Column(name="content")
    var content: String,

    @Column (name="created_at")
    var createdAt:LocalDateTime = LocalDateTime.now(),

    @Column(name="update_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name= "tag")
    var tag: String,

    @Column (name="imageUrl")
    var imageUrl: String? = null,

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
    var comments: MutableList<Comment> = mutableListOf(),

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
    var users: MutableList<User> = mutableListOf(),

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}

fun Post.toResponse(): PostResponse {
    return PostResponse(
        id = id!!,
        title = title,
        content = content,
        imageUrl = imageUrl ?:"",
        tag = tag,
    )
}