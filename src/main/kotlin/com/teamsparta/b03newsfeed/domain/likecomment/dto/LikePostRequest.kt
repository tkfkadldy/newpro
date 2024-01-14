package com.teamsparta.b03newsfeed.domain.likecomment.dto

data class LikePostRequest(

// 좋아요를 누른 사용자의 ID
// 좋아요를 누른 게시물의 ID
    val userId: Long,
    val postId: Long


)