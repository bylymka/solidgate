package com.solidgate.api.service.impl

import com.solidgate.api.repository.UserRepository
import com.solidgate.api.service.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
) : UserService {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val logger = LoggerFactory.getLogger(this::class.java)

    override suspend fun setUsersBalance(batchSize: Int, balances: Map<Int, Int>) {
        balances.entries
            .chunked(batchSize)
            .map { batch ->
                coroutineScope.launch {
                    runCatching {
                        userRepository.updateBalancesInBatch(batch)
                        logger.info("Batch is executed")
                    }.onFailure { exception ->
                        logger.error("The batch failed to update user balances: ${exception.message}", exception)
                    }
                }
            }
            .forEach{ it.join() }

        logger.info("Completed updating user balances")
    }
}