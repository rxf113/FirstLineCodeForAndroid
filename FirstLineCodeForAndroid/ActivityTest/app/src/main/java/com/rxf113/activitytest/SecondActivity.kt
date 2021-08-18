package com.rxf113.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rxf113.activitytest.databinding.FirstLayoutBinding
import com.rxf113.activitytest.databinding.SecondLayoutBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //3.3.4 向下一个Activity传递数据
/*        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra data is ${extraData}")*/
        //3.3.4 向下一个Activity传递数据

        //3.3.5　返回数据给上一个Activity
        //在SecondActivity中给按钮注册点击事件，并在点击事件中添加返回数据
        binding.button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return","Hello FirstActivity")
            setResult(RESULT_OK,intent)
            finish()
        }
        //3.3.5　返回数据给上一个Activity
    }
}