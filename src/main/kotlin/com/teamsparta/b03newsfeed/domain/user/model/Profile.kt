package com.teamsparta.b03newsfeed.domain.user.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Profile(
    @Column(name = "nickname", nullable = false)
    var nickname: String,

    @Column(name = "introduce", nullable = false)
    var introduce: String
)
