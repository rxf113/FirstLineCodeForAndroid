package com.rxf113.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rxf113.broadcasttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var timeChangeReceiver : TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val intentFilter = IntentFilter()
//
//        intentFilter.addAction("android.intent.action.TIME_TICK")
//        timeChangeReceiver = TimeChangeReceiver()
//
//        registerReceiver(timeChangeReceiver,intentFilter)
        binding.button.setOnClickListener{
            val intent = Intent("com.rxf113.broadcasttest.MY_BROADCAST")
            intent.setPackage(packageName)
            //标准广播
            //sendBroadcast(intent)

            //有序广播
            sendOrderedBroadcast(intent,null)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }

    }
}