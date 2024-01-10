package com.teamsparta.b03newsfeed.domain.user.model

import com.teamsparta.b03newsfeed.B03newsfeedApplication
import com.teamsparta.b03newsfeed.domain.user.dto.UserResponse
import jakarta.persistence.*

@Entity
@Table(name = "app_user")
class User(

    @Column(name= "email", nullable = false)
    val email: String,

    @Column(name= "password", nullable = false)
    val password: String,

    @Embedded
    var profile: Profile,

    @Enumerated(EnumType.STRING)
    @Column(name= "role", nullable = false)
    val role: UserRole,
//
//    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
//    val b03newsfeedApplications: MutableList<B03newsfeedApplication> = mutableListOf()

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}

fun User.toResponse(): UserResponse {
    return UserResponse(
        id = id!!,
        nickname = profile.nickname,
        email = email,
        role = role.name
    )
}