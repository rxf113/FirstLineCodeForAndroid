package com.rxf113.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rxf113.activitytest.databinding.SecondLayoutBinding
import com.rxf113.activitytest.databinding.ThirdLayoutBinding

class ThirdActivity : BaseActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d("ThirdActivity", "Task id is $taskId")
//        setContentView(R.layout.third_layout)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ThirdActivity", "Task id is $taskId")
        val binding = ThirdLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button3.setOnClickListener{
            ActivityCollector.finishAll()
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }
}