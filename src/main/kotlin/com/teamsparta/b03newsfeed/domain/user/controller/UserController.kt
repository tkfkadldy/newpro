package com.teamsparta.b03newsfeed.domain.user.controller

import com.teamsparta.b03newsfeed.domain.user.dto.SignRequest
import com.teamsparta.b03newsfeed.domain.user.dto.UpdateUserProfileRequest
import com.teamsparta.b03newsfeed.domain.user.dto.UserResponse
import com.teamsparta.b03newsfeed.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/signup") //회원가입
    fun signUp(@RequestBody signRequest: SignRequest): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.signUp(signRequest))
    }

    @GetMapping("/signin") //로그인
    fun signIn(@RequestBody signRequest: SignRequest): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.signIn(signRequest))
    }

    @PatchMapping("/users/{userId}/profile")
    fun updateUserProfile(@PathVariable userId: Long,
                          @RequestBody updateUserProfileRequest: UpdateUserProfileRequest
    ): ResponseEntity<UserResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.updateUserProfile(userId, updateUserProfileRequest))
    }

    @GetMapping() // 로그아웃
    fun signOut(@PathVariable userId: Long,
                @RequestBody signRequest: SignRequest): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.signOut(userId, signRequest))
    }


}