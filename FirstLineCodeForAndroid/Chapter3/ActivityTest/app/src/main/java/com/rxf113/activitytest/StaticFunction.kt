package com.rxf113

/**
 * 静态方法
 */
class Util {
    fun doAction1(){
        println("do action1")
    }

    companion object{
        @JvmStatic
        fun doAction2(){
            println("do action2")
        }
    }
}