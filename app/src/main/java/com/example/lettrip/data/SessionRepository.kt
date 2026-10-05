package com.example.lettrip.data

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

interface SessionRepository {
    suspend fun isLoggedIn(): Boolean
}

class FakeSessionRepository: SessionRepository {
    override suspend fun isLoggedIn(): Boolean {
        delay(1000.milliseconds)
        return true
    }
}
