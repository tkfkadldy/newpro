package com.teamsparta.b03newsfeed.domain.comment.repository

import com.teamsparta.b03newsfeed.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository


interface CommentRepository : JpaRepository<Comment,Long> {
   fun findByPostIdAndId(postId: Long , commentId: Long): Comment?

}