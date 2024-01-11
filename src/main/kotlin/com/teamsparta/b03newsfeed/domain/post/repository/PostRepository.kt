package com.teamsparta.b03newsfeed.domain.post.repository

import com.teamsparta.b03newsfeed.domain.comment.model.Comment
import com.teamsparta.b03newsfeed.domain.post.model.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}