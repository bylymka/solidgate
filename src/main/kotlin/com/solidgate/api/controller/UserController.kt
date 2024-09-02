package com.solidgate.api.controller

import com.solidgate.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class UserController(
    private var userService: UserService
) {
    @PostMapping("/set-users-balance")
    suspend fun setUsersBalance(@RequestBody balances: Map<Int, Int>): ResponseEntity<Void> {
        userService.setUsersBalance(1500, balances)

        return ResponseEntity.ok().build()
    }
}