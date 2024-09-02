package com.solidgate.api

import com.solidgate.api.repository.UserRepository
import com.solidgate.api.service.impl.UserServiceImpl
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import kotlinx.coroutines.runBlocking
import org.mockito.Mockito.*
import org.slf4j.LoggerFactory
import kotlin.test.Test

class UserServiceImplTest {

    private val userRepository: UserRepository = mock(UserRepository::class.java)
    private val userService = UserServiceImpl(userRepository)

    @Test
    fun shouldUpdateUserBalancesInBatches(): Unit = runBlocking {

        val balances = mapOf(
            1 to 100,
            2 to 200,
            3 to 300,
            4 to 400,
            5 to 500,
            6 to 600
        )
        val batchSize = 3

        coEvery { userRepository.updateBalancesInBatch(any()) } just Runs

        userService.setUsersBalance(batchSize, balances)
        val expectedBatches = balances.entries.chunked(batchSize)

        expectedBatches.forEach { batch ->
            coVerify {
                userRepository.updateBalancesInBatch(batch)
            }
        }

        coVerify(exactly = expectedBatches.size) { userRepository.updateBalancesInBatch(any()) }
    }
}