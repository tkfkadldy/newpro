package com.teamsparta.b03newsfeed.domain.post.exception.dto

import com.teamsparta.b03newsfeed.domain.post.exception.PostNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(PostNotFoundException::class)
    fun handlePostNotFoundException(e: PostNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(e.message))
    }
}