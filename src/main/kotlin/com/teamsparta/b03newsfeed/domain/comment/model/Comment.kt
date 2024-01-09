package com.teamsparta.b03newsfeed.domain.comment.model

import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Comment (
    @Column (name = "arthur", nullable = false)
    val arthur : String,

    @Column (name = "description", nullable = false)
    val description:String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
