package com.rxf113.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.rxf113.activitytest.databinding.FirstLayoutBinding
import com.rxf113.doSomething

//class FirstActivity : AppCompatActivity() {
class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         *
        原书中的 findViewById 和 kotlin-android-extensions插件 已过时,网上搜了下现在采用 View Binding 的方式,在src/build.gradle文件
        里加上

        buildFeatures {
        viewBinding true
        }

        然后点击 Build下面的Rebuild Project

         */

        //setContentView(R.layout.first_layout)
        super.onCreate(savedInstanceState)
        val binding = FirstLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //设置button1的点击监听
        Log.d("FirstActivity", "Task id is $taskId")
        binding.button1.setOnClickListener {
            //3.2.4　在Activity中使用Toast
//            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()

            //3.2.6　销毁一个Activity
//            finish()

            // 3.3.1　使用显式Intent
            // 使用显示intent, 在FirstActivity的基础上打开SecondActivity
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)

            //3.3.2　使用隐式Intent
            //隐式Intent , 启动能够响应com.rxf113.activitytest.ACTION_START这个action的Activity(也就是SecondActivity)
//            val intent = Intent("com.rxf113.activitytest.ACTION_START")
//            intent.addCategory("com.rxf113.activitytest.MY_CATEGORY")//每个Intent中只能指定一个action，但能指定多个category
//            startActivity(intent)

            //3.3.3　更多隐式Intent的用法
            //指定了Intent的action是Intent.ACTION_VIEW，这是一个Android系统内置的动作，其常量值为android.intent.action.VIEW。然后通过Uri.parse()方法将一个网址字符串解析成一个Uri对象，再调用Intent的setData()方法将这个Uri对象传递进去
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)
//
//            //指定了Intent的action是Intent.ACTION_DIAL，这又是一个Android系统的内置动作。然后在data部分指定了协议是tel，号码是10086
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
//            startActivity(intent)

            //3.3.4 向下一个Activity传递数据
//            val data = "Hello SecondAcctivity"
//            //使用显式Intent的方式来启动SecondActivity，并通过putExtra()方法传递了一个字符串。注意，这里putExtra()方法接收两个参数，第一个参数是键，用于之后从Intent中取值，第二个参数才是真正要传递的数据
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("extra_data", data)
//            startActivity(intent)

            //3.3.5　返回数据给上一个Activity
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivityForResult(intent, 1)

            //3.5　Activity的启动模式
//            val intent = Intent(this, FirstActivity::class.java)
//            startActivity(intent)

//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            //传递启动参数
            //SecondActivity.actionStart(this, "data1", "data2")

            //调用Helper.kt静态方法
            doSomething()
        }
    }

    /**
     * 3.2.5　在Activity中使用Menu
     * 允许创建的菜单显示出来允许创建的菜单显示出来
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    /**
     * 定义菜单响应事件
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
                .show()
        }
        return true
    }

    //3.3.5　返回数据给上一个Activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "returned data is $returnedData")
            }
        }
    }

    //3.3.5　返回数据给上一个Activity
    //用户按下Back键后，就会执行onBackPressed()方法中的代码，我们在这里添加返回数据的逻辑
    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello FirstActivity")
        setResult(RESULT_OK, intent)
        finish()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity", "onRestart")
    }
}