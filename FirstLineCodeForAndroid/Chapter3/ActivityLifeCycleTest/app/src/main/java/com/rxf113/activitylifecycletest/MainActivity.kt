package com.rxf113.activitylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.rxf113.activitylifecycletest.databinding.ActivityMainBinding
import com.rxf113.activitylifecycletest.databinding.DialogLayoutBinding
import com.rxf113.activitylifecycletest.databinding.NormalLayoutBinding

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //3.4.5　Activity被回收了怎么办 ,取出onSaveInstanceState方法中保存数据
        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getString("data_key")
            Log.d(tag, "template is $tempData")
        }

        binding.startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }

        binding.startDialogActivity.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * 3.4.5　Activity被回收了怎么办 被回收前一定执行此方法 重写，保存数据
     */
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState)
        val tempData = "Something you just typed"
        outState.putString("data_key", tempData)
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")

    }
}