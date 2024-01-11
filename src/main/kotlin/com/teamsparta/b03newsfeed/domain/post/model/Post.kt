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

    @Column(name="updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name= "tag")
    var tag: String,

    @Column (name="imageurl")
    var imageUrl: String? = null,



    @OneToMany( cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
    var comments: MutableList<Comment> = mutableListOf(),

//    @OneToMany( cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
//    var users: MutableList<User> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    var id: Long? = null


    fun createComment(comment: Comment) {
        comments.add(comment)
    }

    fun deleteComment(comment: Comment) {
        comments.remove(comment)
    }


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