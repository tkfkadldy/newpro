package com.teamsparta.b03newsfeed.domain.post.repository

import com.teamsparta.b03newsfeed.domain.post.model.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Long>