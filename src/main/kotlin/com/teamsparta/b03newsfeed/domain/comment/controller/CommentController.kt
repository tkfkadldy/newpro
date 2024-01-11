package com.teamsparta.b03newsfeed.domain.comment.controller

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.exception.CommentNotFoundException
import com.teamsparta.b03newsfeed.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//이름바꾼거 테스트

@RequestMapping("/posts/{postId}/comments")
@RestController
class CommentController(
    private val commentService: CommentService
) {

    @GetMapping("/{commentId}")
    fun getComment(@PathVariable postId:Long ,
                   @PathVariable commentId: Long): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.getCommentById(postId,commentId))
    }

    @GetMapping
    fun getCommentList(@PathVariable postId: Long): ResponseEntity<List<CommentResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.getAllCommentList(postId))
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable postId: Long,
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(postId ,commentId, updateCommentRequest))
    }

    @PostMapping
    fun createComment(
        @PathVariable postId: Long ,
        @RequestBody createCommentRequest: CreateCommentRequest): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(postId ,createCommentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable postId: Long,
        @PathVariable commentId: Long): ResponseEntity<Unit> {
        commentService.deleteComment(postId ,commentId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    @ExceptionHandler(CommentNotFoundException::class)
    fun handleCommentNotFoundException(e: CommentNotFoundException): ResponseEntity<com.teamsparta.b03newsfeed.domain.comment.exception.dto.ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(com.teamsparta.b03newsfeed.domain.comment.exception.dto.ErrorResponse(message = e.message))

    }
}