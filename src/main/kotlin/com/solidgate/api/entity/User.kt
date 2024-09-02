package com.solidgate.api.entity

import jakarta.persistence.*
@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    var balance: Int
)