package com.teamsparta.b03newsfeed.domain.user.service

import com.teamsparta.b03newsfeed.domain.user.dto.EmailCertificationRequest
import com.teamsparta.b03newsfeed.domain.user.exception.ModelNotFoundException
import com.teamsparta.b03newsfeed.domain.user.repository.UserRepository
import com.teamsparta.b03newsfeed.infra.security.email.CertificationGenerator
import org.springframework.data.repository.findByIdOrNull
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmailService(
    private val javaMailSender: JavaMailSender,
    private val certificationGenerator: CertificationGenerator,
    private val userRepository: UserRepository,
) {

    fun sendEmail(userId: Long): String {
        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)
        val number = certificationGenerator.createCertificationNumber()

        user.certification = number
        userRepository.save(user)


        val message = SimpleMailMessage()
        message.setTo(user.email)
        message.subject = "b03 newsfeed 본인 인증 이메일입니다."
        message.text = "인증 번호는 \n\n\n$number\n\n\n 입니다."

        javaMailSender.send(message)
        return "본인 인증 이메일이 발송되었습니다."
    }

    @Transactional
    fun checkEmail(userId: Long, request: EmailCertificationRequest): String {
        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)

        if (user.certification == request.certificationNumber) {
            user.certification = "Verified"
            userRepository.save(user)
            return "이메일이 인증되었습니다."
        } else {
            return "인증번호가 다릅니다."
        }

    }

}