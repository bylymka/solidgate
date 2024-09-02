package com.solidgate.api.repository

interface UserRepository {
    fun updateBalancesInBatch(batch: List<Map.Entry<Int, Int>>)
}