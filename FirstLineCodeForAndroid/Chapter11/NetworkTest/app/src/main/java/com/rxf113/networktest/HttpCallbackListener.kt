package com.rxf113.networktest

interface HttpCallbackListener {
    fun onFinish(response: String)
    fun onError(e: Exception)
}