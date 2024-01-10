package com.teamsparta.b03newsfeed.domain.post.service

import com.teamsparta.b03newsfeed.domain.post.dto.CreatePostRequest
import com.teamsparta.b03newsfeed.domain.post.dto.PostResponse
import com.teamsparta.b03newsfeed.domain.post.dto.UpdatePostRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostServicelmpl:PostService {
    override fun getAllPostList(): List<PostResponse> {
        TODO("Not yet implemented")
        //TODO: DB에서 모든 post를 가져와서 PostResponse로 변환 후 반환
    }

    override fun getPostById(postId: Long): PostResponse {
        TODO("Not yet implemented")
        // TODO: 만약 postId에 해당하는 post가 없다면 throw PostNotFoundException
        // TODO: DB에서 postId에 해당하는 Post를 가져와서 PostResponse로 변환 후 반환
    }

    @Transactional
    override fun createPost(request: CreatePostRequest): PostResponse {
        TODO("Not yet implemented")
        // TODO: request를 post로 변환 후 DB에 저장
    }
    @Transactional
    override fun updatePost(postId: Long, request: UpdatePostRequest): PostResponse {
        TODO("Not yet implemented")
        // TODO: 만약 postId에 해당하는 post가 없다면 throw postNotFoundException
        // TODO: DB에서 postId에 해당하는 post를 가져와서 request로 업데이트 후 DB에 저장, 결과를 PostResponse로 변환 후 반환
    }

    @Transactional
    override fun deletePost(postId: Long) {
        TODO("Not yet implemented")
        // TODO: 만약 postId에 해당하는 Post가 없다면 throw postNotFoundException
        // TODO: DB에서 postId에 해당하는 Post를 삭제, 연관된 comment 모두 삭제
    }


}