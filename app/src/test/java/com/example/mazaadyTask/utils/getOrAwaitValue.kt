package com.example.mazaadyTask.utils

import androidx.annotation.VisibleForTesting
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@VisibleForTesting(otherwise = VisibleForTesting.NONE)
fun <T> Flow<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val collector = kotlinx.coroutines.flow.FlowCollector<T> { value ->
        data = value
        latch.countDown()
    }
    this.onEach { collector.emit(it) }
        .launchIn(GlobalScope)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the StateFlow is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("StateFlow value was never set.")
        }

    } finally {
        // Cancel the flow to prevent leaks
        this.onEach { }.launchIn(GlobalScope)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}