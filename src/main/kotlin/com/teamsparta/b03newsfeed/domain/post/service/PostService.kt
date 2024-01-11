package com.teamsparta.b03newsfeed.domain.post.service

import com.teamsparta.b03newsfeed.domain.post.dto.CreatePostRequest
import com.teamsparta.b03newsfeed.domain.post.dto.PostResponse
import com.teamsparta.b03newsfeed.domain.post.dto.TagResponse
import com.teamsparta.b03newsfeed.domain.post.dto.UpdatePostRequest


interface PostService {
     fun getPostList(): List<PostResponse>

     fun getPost(postId:Long) : PostResponse

     fun createPost(request: CreatePostRequest) :PostResponse

     fun updatePost(postId: Long, request: UpdatePostRequest) :PostResponse

     fun deletePost(postId: Long)

     fun getTag(tagId:Long) : TagResponse


}