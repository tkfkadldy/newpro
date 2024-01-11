package com.teamsparta.b03newsfeed.domain.post.exception

data class PostNotFoundException(val Post: String, val postid: Long?) :
    RuntimeException("$Post not found with given id: $postid")
