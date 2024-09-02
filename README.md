# User Balance Update Service

## Overview

This Kotlin Spring Boot application provides a REST endpoint `/set-users-balance` that updates the balances of users in a PostgreSQL database. The endpoint accepts a `Map<Int, Int>`, where the key represents the user ID and the value represents the balance to be updated.


## Performance Improvements

- **Batch Processing:** Uses JDBC batch processing to handle large updates efficiently, reducing the number of database interactions.
- **Connection Pooling:** Utilizes connection pooling to optimize resource usage and improve performance.
- **Coroutines:** Leverages Kotlin coroutines for asynchronous processing, allowing the application to handle multiple update operations concurrently without blocking.
