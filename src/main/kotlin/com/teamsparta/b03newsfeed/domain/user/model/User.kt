package com.teamsparta.b03newsfeed.domain.user.model

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

//    @OneToMany(mappedBy = "user")
//    val userPosts: MutableList

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}