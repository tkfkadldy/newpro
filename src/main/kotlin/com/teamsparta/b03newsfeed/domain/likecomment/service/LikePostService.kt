package com.teamsparta.b03newsfeed.domain.likecomment.service

import com.teamsparta.b03newsfeed.domain.likecomment.dto.LikePostRequest

// 좋아요 관련 비즈니스 로직을 담당하는 서비스 인터페이스
interface LikePostService {
    // 좋아요를 추가하는 기능
    fun insert(likePostRequest: LikePostRequest)
    // 좋아요를 삭제하는 기능
    fun delete(likePostRequest: LikePostRequest)


}
