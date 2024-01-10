package com.teamsparta.b03newsfeed.domain.user.exception

data class InvalidCredentialException (
    override val message: String? = "The credential is invalid"
):RuntimeException()