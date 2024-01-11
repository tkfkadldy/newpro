package com.teamsparta.b03newsfeed.domain.post.exception

data class PostNotFoundException(val post: String, val postId: Long?) :
    RuntimeException("$post not found with given id: $postId")
