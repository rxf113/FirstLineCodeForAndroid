package com.rxf113.jetpacktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//class MainViewModel(countReserved: Int) : ViewModel() {
//
//    var counter = countReserved
//}

class MainViewModel(countReserved: Int) : ViewModel() {

    //var counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter

    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne(){
        val count = counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear(){
        _counter.value = 0
    }
}