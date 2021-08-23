package com.rxf113.uiwidgetest

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.rxf113.uiwidgetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.button.id -> {
                //此处添加逻辑
                //显示editText中的文字
//                val inputText = binding.editText.text.toString()
//                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()

                //切换image
                //binding.imageView.setImageResource(R.drawable.img_2)

                //进度条显示隐藏
//                if (binding.processBar.visibility == View.VISIBLE) {
//                    binding.processBar.visibility = View.GONE
//                } else {
//                    binding.processBar.visibility = View.VISIBLE
//                }

                //水平进度条更改
                //binding.processBar.progress = binding.processBar.progress + 10

                //AlertDialog可以在当前界面弹出一个对话框
                AlertDialog.Builder(this).apply {
                    setTitle("This is Dialog")
                    setMessage("Something important.")
                    setCancelable(false)
                    setPositiveButton("OK") { _, _
                        ->
                    }
                    setNegativeButton("Cancel") { _, _
                        ->
                    }
                    show()
                }
            }
        }
    }
}