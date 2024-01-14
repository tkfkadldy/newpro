package com.teamsparta.b03newsfeed.domain.comment.repository

import com.teamsparta.b03newsfeed.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository


//댓글을 저장하고 조회하는 기능을 제공하는 JPA 리포지토리 인터페이스
//JpaRepository<Comment, Long>`를 상속하여 기본적인 CRUD(Create, Read, Update, Delete) 작업을 수행할 수 있는 메서드를 제공받는다.
//findByPostIdAndId(postId: Long, commentId: Long): Comment? 메서드는 지정된 게시물 ID와 댓글 ID에 해당하는 댓글을 조회하는 메서드.
interface CommentRepository : JpaRepository<Comment,Long> {
   fun findByPostIdAndId(postId: Long , commentId: Long): Comment?

}

