package com.teamsparta.b03newsfeed.domain.comment.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/posts/{postId}/comments")
@RestController
class CommentController {

    @GetMapping("/{commentId}")
    fun getComment(){
        TODO()
    }

    @GetMapping
    fun getCommentList(){
        TODO()
    }
    @PutMapping("/{commentId}")
    fun updateComment(){
        TODO()
    }
//asdgasgdgasdasdg
    @PostMapping
    fun createComment(){
        TODO()
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(){
        TODO()
    }

}