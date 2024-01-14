package com.teamsparta.b03newsfeed.domain.comment.model

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.post.model.Post
import com.teamsparta.b03newsfeed.domain.user.model.User
import jakarta.persistence.*
import java.time.LocalDateTime

//댓글 정보를 저장하고 관리하는 엔티티 클래스
//@Entity` 애노테이션은 이 클래스가 JPA 엔티티임을 나타냅니다.
//@Table(name = "comment") 애노테이션은 이 클래스가 매핑되는 데이터베이스 테이블의 이름을 지정
@Entity
@Table(name = "comment")
class Comment(


    //댓글의 내용을 저장
    @Column(name = "oomment", nullable = false)
    var description: String,

    //댓글이 생성된 날짜와 시간을 저장
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    //댓글이 마지막으로 수정된 날짜와 시간을 저장
    @Column(name = "updated_at")
    val updateAt: LocalDateTime = LocalDateTime.now(),

    //댓글이 속한 게시물을 나타내며, `Post` 엔티티와 다대일 관계

    @ManyToOne
    @JoinColumn(name = "post_id")
    val post: Post,

    //댓글을 작성한 사용자를 나타내며, `User` 엔티티와 다대일 관계

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null


}


fun Comment.toResponse(): CommentResponse {
    return CommentResponse(
        id = id!!,
        description = description,
        updateAt = updateAt,
        createAt = createdAt,
    )
}
