package com.teamsparta.b03newsfeed.domain.post.repository

import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}