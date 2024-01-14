package com.teamsparta.b03newsfeed.domain.likecomment.exception

//좋아요가 존재하지 않을 때 발생하는 예외
class LikeNotFoundException(message: String) : RuntimeException(message)