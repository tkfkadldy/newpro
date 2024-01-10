package com.teamsparta.b03newsfeed.infra.security

import com.teamsparta.b03newsfeed.infra.security.jwt.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic{it.disable()}
            .formLogin{it.disable()}
            .csrf{it.disable()}
            .authorizeHttpRequests{
                it.requestMatchers(
                    "/login",
                    "/signup",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                ).permitAll()
                    .anyRequest().authenticated()
            }
            .build()
    }
}