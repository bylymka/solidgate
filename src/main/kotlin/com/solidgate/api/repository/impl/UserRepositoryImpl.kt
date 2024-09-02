package com.solidgate.api.repository.impl

import com.solidgate.api.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource

@Component
class UserRepositoryImpl(
    private val dataSource: DataSource
) : UserRepository {

    @Transactional(rollbackFor = [Exception::class])
    override fun updateBalancesInBatch(batch: List<Map.Entry<Int, Int>>) {
        dataSource.connection.use { connection ->
            connection.prepareStatement("UPDATE users SET balance = ? WHERE id = ?").use { statement ->
                batch.forEach { (userId, balance) ->
                    statement.setInt(1, balance)
                    statement.setInt(2, userId)
                    statement.addBatch()
                }
                statement.executeBatch()
            }
        }
    }
}