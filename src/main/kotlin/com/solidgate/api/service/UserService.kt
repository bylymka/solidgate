package com.solidgate.api.service

interface UserService {
    suspend fun setUsersBalance(batchSize: Int, balances: Map<Int, Int>)
}