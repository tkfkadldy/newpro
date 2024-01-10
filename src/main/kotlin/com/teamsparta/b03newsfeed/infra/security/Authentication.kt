package com.teamsparta.b03newsfeed.infra.security

import org.springframework.security.core.GrantedAuthority
import java.io.Serializable
import java.security.Principal


interface Authentication : Principal, Serializable {
    val authorities: Collection<GrantedAuthority?>?

    val credentials: Any?

    val details: Any?

    val principal: Any?

    @set:Throws(IllegalArgumentException::class)
    var isAuthenticated: Boolean
}