package com.teamsparta.b03newsfeed.domain.comment.controller

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.exception.CommentNotFoundException
import com.teamsparta.b03newsfeed.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


//댓글 관리를 위한 REST API를 제공하는 컨트롤러 클래스
//@RequestMapping 애노테이션을 사용하여 '/posts/{postId}/comments' 경로로 들어오는 요청을 처리
//@RestController 애노테이션을 사용하여 REST API 컨트롤러로 지정
//commentService를 주입받아 댓글 관련 서비스를 호출

@RequestMapping("/posts/{postId}/comments")
@RestController
class CommentController(
    private val commentService: CommentService
) {


    //@PathVariable 애노테이션을 사용하여 요청에 포함된 값을 변수에 넣고
    //commentService.getCommentById(postId, commentId) 메서드를 호출하여 특정 댓글을 조회합니다.
    //조회된 댓글을 CommentResponse 객체로 변환하고 응답 본문에 포함

    @GetMapping("/{commentId}")
    fun getComment(@PathVariable postId: Long,
                   @PathVariable commentId: Long): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.getCommentById(postId, commentId))
    }


    //commentService.getAllCommentList(postId) 메서드를 호출하여 게시물의 모든 댓글 목록을 조회
    //조회된 댓글 목록을 List<CommentResponse> 객체로 변환하고 응답 본문에 포함

    @GetMapping
    fun getCommentList(@PathVariable postId: Long): ResponseEntity<List<CommentResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.getAllCommentList(postId))
    }

    //@RequestBody 애노테이션을 사용하여 요청 본문에 포함된 값을 UpdateCommentRequest 객체로 변환
    //commentService.updateComment(postId, commentId, updateCommentRequest) 메서드를 호출하여 댓글을 수정
    //수정된 댓글을 CommentResponse 객체로 변환하고 응답 본문에 포함

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable postId: Long,
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(postId, commentId, updateCommentRequest))
    }


    //@RequestBody 애노테이션을 사용하여 요청 본문에 포함된 값을 CreateCommentRequest 객체로 변환
    //commentService.createComment(postId, createCommentRequest) 메서드를 호출하여 새로운 댓글을 생성
    //생성된 댓글을 CommentResponse 객체로 변환하고 응답 본문에 포함

    @PostMapping
    fun createComment(
        @PathVariable postId: Long,
        @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(postId , createCommentRequest))
    }

    //commentService.deleteComment(postId, commentId) 메서드를 호출하여 특정 댓글을 삭제
    //응답 본문에 포함할 내용이 없으므로 ResponseEntity.noContent()를 반환

    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable postId: Long,
        @PathVariable commentId: Long
    ): ResponseEntity<Unit> {
        commentService.deleteComment(postId, commentId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    //@ExceptionHandler 애노테이션을 사용하여 CommentNotFoundException 예외를 처리
    //예외가 발생하면 404 Not Found 응답을 반환
    @ExceptionHandler(CommentNotFoundException::class)
    fun handleCommentNotFoundException(e: CommentNotFoundException): ResponseEntity<com.teamsparta.b03newsfeed.domain.comment.exception.dto.ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(com.teamsparta.b03newsfeed.domain.comment.exception.dto.ErrorResponse(message = e.message))

    }
}