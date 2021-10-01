package com.rxf113.retrofittest

import kotlinx.coroutines.*

fun main() {
//    GlobalScope.launch {
//        println("codes run in coroutine scope")
//        delay(1500)
//        println("codes run in coroutine finished")
//    }
//
//    Thread.sleep(1000)

//    runBlocking {
//        println("codes run in coroutine scope")
//        delay(1500)
//        println("codes run in coroutine finished")
//    }

//    runBlocking{
//        launch {
//            println("launch1")
//            delay(1000)
//            println("launch1 finished")
//        }
//
//        launch {
//            println("launch2")
//            delay(1000)
//            println("launch2 finished")
//        }
//    }

    val start = System.currentTimeMillis()
    runBlocking {
//        repeat(100000){
//            launch {
//                println(".")
//            }
//        }
        launch {
            delay(5000)
            println("l1")
        }
        launch {
            delay(5000)
            println("l2")
        }
        launch {
            delay(5000)
            println("l3")
        }
    }
    val end = System.currentTimeMillis()
    println(end - start)

//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch {
//        //
//        delay(5000)
//        println("l1")
//    }
//    scope.launch {
//        //
//        delay(5000)
//        println("l2")
//    }
//    job.cancel()


}