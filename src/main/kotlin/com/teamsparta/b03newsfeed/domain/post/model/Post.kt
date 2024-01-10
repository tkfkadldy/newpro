package com.teamsparta.b03newsfeed.domain.post.model

import com.teamsparta.b03newsfeed.domain.comment.model.Comment
import com.teamsparta.b03newsfeed.domain.post.dto.PostResponse
import com.teamsparta.b03newsfeed.domain.user.model.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "post")
class Post(

    @Column
    var title: String,

    @Column
    var content: String,

    @Column
    var createdAt: LocalDateTime = java.time.LocalDateTime.now(),

    @Column
    var updatedAt: LocalDateTime = java.time.LocalDateTime.now(),

    @Column
    var tag: String,

    @Column
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
        image = imageUrl ?:"",
        tag = tag,
    )
}