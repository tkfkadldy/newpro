package com.teamsparta.b03newsfeed.domain.comment.controller

import com.teamsparta.b03newsfeed.domain.comment.dto.CommentResponse
import com.teamsparta.b03newsfeed.domain.comment.dto.CreateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.b03newsfeed.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/posts/{postId}/comments")
@RestController
class CommentController(
    private val commentService: CommentService
) {

    @GetMapping("/{commentId}")
    fun getComment(@PathVariable commentId:Long): ResponseEntity<CommentResponse>{
       return ResponseEntity
           .status(HttpStatus.OK)
           .body(commentService.getCommentById(commentId))
    }

    @GetMapping
    fun getCommentList():ResponseEntity<List<CommentResponse>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.getAllCommentList())
    }
    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ):ResponseEntity<CommentResponse>
    {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(commentId,updateCommentRequest))
    }

    @PostMapping
    fun createComment(@RequestBody createCommentRequest: CreateCommentRequest):ResponseEntity<CommentResponse>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(createCommentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable commentId: Long):ResponseEntity<Unit>{
        commentService.deleteComment(commentId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}