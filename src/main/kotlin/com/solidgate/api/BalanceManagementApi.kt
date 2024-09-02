package com.solidgate.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BalanceManagementApi

fun main(args: Array<String>) {
    runApplication<BalanceManagementApi>(*args)
}