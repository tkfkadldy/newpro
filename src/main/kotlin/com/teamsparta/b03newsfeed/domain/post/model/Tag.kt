package com.teamsparta.b03newsfeed.domain.post.model

import com.teamsparta.b03newsfeed.domain.post.dto.PostResponse
import com.teamsparta.b03newsfeed.domain.post.dto.TagResponse
import jakarta.persistence.*

@Entity
@Table(name = "tag")
class Tag(
    @Column(name="tagname")
    var name: String,
    @Id
    @Column(name="tagId")
    var id: Long,
)

fun Tag.toResponse(): TagResponse {
    return TagResponse(
        id = id,
        name=name
    )
}