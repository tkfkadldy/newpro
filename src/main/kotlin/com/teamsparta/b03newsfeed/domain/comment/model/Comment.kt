package com.teamsparta.b03newsfeed.domain.comment.model

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.user.model.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "comment")
class Comment(
    @Column(name = "arthur", nullable = false)
    val arthur: String,

    @Column(name = "comment", nullable = false)
    val description: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    val updateAt: LocalDateTime = LocalDateTime.now(),


    //   @ManyToOne
    //   @JoinColum (name = "post_id")
    //   val post:Post

    //   @ManyToOne
    //   @JoinColum (name = "user_id")
    //   val user: User

    //   post 생명주기 OntToMany (옆에 cascade= [CascadeType.ALL], orphanRemoval = true)

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}


fun Comment.toResponse(): CommentResponse {
    return CommentResponse(
        
        arthur = arthur,
        description = description,
        updateAt = updateAt,
        createAt = createdAt,


        )
}