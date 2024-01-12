package com.teamsparta.b03newsfeed.domain.user.controller

import com.teamsparta.b03newsfeed.domain.user.dto.EmailCertificationRequest
import com.teamsparta.b03newsfeed.domain.user.service.EmailService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users/{userId}")
class EmailController(
    private val emailService: EmailService
) {

    @GetMapping()
    fun getUserEmail(@PathVariable userId: Long): ResponseEntity<String>{
        emailService.sendEmail(userId)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body("가입 시 입력한 이메일로 인증 번호가 전송되었어요.")
    }

    @PatchMapping("/check")
    fun checkUserEmail(
        @PathVariable userId: Long,
        @RequestBody emailCertificationRequest: EmailCertificationRequest): ResponseEntity<String>{
        emailService.checkEmail(userId, emailCertificationRequest)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body("이메일 인증이 완료되었습니다.")
    }
}