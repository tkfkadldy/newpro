package com.teamsparta.b03newsfeed.infra.security.email

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class CertificationGenerator {
    fun createCertificationNumber(): String {
        var result: String = ""

        for (i in 0 until 6){
            result += Random.nextInt(10).toString()
        }

        return result
    }
}