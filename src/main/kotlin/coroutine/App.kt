package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val start = System.currentTimeMillis()

    runBlocking(Dispatchers.Default) {
        runBlocking {
            doCoroutine1()
        }
        runBlocking {
            doCoroutine2()
            doCoroutine3()
        }

    }

    val end = System.currentTimeMillis()

    println("진행시간 : ${end - start}")
}

suspend fun doCoroutine1() {
    delay(1000)
    println("first")
}

suspend fun doCoroutine2() {
    delay(2000)
    println("second")
}

suspend fun doCoroutine3() {
    delay(3000)
    println("third")
}