package com.teamsparta.b03newsfeed.domain.likecomment.controller

import com.teamsparta.b03newsfeed.domain.likecomment.dto.LikePostRequest
import com.teamsparta.b03newsfeed.domain.likecomment.dto.LikePostResponse
import com.teamsparta.b03newsfeed.domain.likecomment.service.LikePostService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


// 컨트롤러 클래스 정의
// @RestController 어노테이션 사용하여 REST API를 제공하는 컨트롤러라는 소리
// @RequestMapping("/posts/likes") 어노테이션을 사용하여 /posts/likes 경로를 매핑
// LikePostService 타입의 likePostService 프로퍼티를 선언합니다.

@RestController
@RequestMapping("/posts/likes")
class LikePostController(
    private val likePostService: LikePostService
) {

// insert 좋아요 추가
// @PostMapping 어노테이션을 사용하여 POST 요청을 처리
// @RequestBody 어노테이션을 사용하여 요청 본문에 들어있는 LikePostRequest 객체를 받는다
// @Valid 어노테이션을 사용하여 LikePostRequest 객체의 유효성을 검사한다
// likePostService.insert() 메서드를 호출하여 좋아요를 추가
// ResponseEntity.ok().build() 메서드를 사용하여 200 OK 응답을 반환


    @PostMapping
    fun insert(@RequestBody @Valid likePostRequest: LikePostRequest): ResponseEntity<String> {
        likePostService.insert(likePostRequest)
        return ResponseEntity.ok("좋아요~")
    }


// 좋아요 삭제
// @DeleteMapping 어노테이션을 사용하여 DELETE 요청을 처리합니다.
// @RequestBody 어노테이션을 사용하여 요청 본문에 들어있는 LikePostRequest 객체를 받습니다.
// @Valid 어노테이션을 사용하여 LikePostRequest 객체의 유효성을 검사합니다.
// likePostService.delete() 메서드를 호출하여 좋아요를 삭제합니다.
// ResponseEntity.ok().build() 메서드를 사용하여 200 OK 응답을 반환


    @DeleteMapping
    fun delete(@RequestBody @Valid likePostRequest: LikePostRequest): ResponseEntity<String> {
        likePostService.delete(likePostRequest)
        return ResponseEntity.ok("좋아요 취소")
    }

}
