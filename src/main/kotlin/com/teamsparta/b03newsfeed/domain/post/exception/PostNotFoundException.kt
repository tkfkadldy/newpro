package com.teamsparta.b03newsfeed.domain.post.exception

data class PostNotFoundException(val postName: String, val postid: Long?) :
    RuntimeException("$postName not found with given id: $postid")
