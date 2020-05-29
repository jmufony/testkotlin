package com.example.testkotlin

import kotlinx.coroutines.*

fun main() {
//    GlobalScope.launch { // 在后台启动一个新的协程并继续
//        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
//        println("World!") // 在延迟后打印输出
//    }
//    println("Hello,") // 协程已在等待时主线程还在继续
//    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活

//    runBlocking {
//        println("runBlocking start")
//        testCoroutineScrope()
//        println("runBlocking end")
//    }

//    runBlocking{
//        coroutineScope {
//            launch { doWorld() }
//        }
//        println("Hello,")
//    }
//
//    runBlocking{
//        launch { doWorld() }
//        println("Hello,")
//    }

    runBlocking {
        //global scope 像守护线程，优先级低，runblocking 不会等
        //如果不delay保活，world都打不出来
        //如果使用join则可以保证执行完
        var job = GlobalScope.launch {
            delay(1000)
            println("world")
        }
        println("hello")
        job.join()
//        delay(1500)
    }
}

suspend fun testCoroutineScrope(){
    coroutineScope {
        println("first coroutine")
        launch {
            delay(1000)
            launch {
                delay(2000)
                println("third coroutine ")
            }
            println("second coroutine ")
        }
    }
}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}