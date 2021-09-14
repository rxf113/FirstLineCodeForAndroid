package com.rxf113.providertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.util.Log
import androidx.core.content.contentValuesOf
import com.rxf113.providertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var bookId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addData.setOnClickListener {
            // 添加数据
            val uri = Uri.parse("content://com.rxf113.databasetest.provider/book")
            val values = contentValuesOf("name" to "A Clash of Kings", "author" to "George Martin", "pages" to 1040, "price" to 22.85)
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
        }
        binding.queryData.setOnClickListener {
            // 查询数据
            val uri = Uri.parse("content://com.rxf113.databasetest.provider/book")
            contentResolver.query(uri, null, null, null, null)?.apply {
                while (moveToNext()) {
                    val name = getString(getColumnIndex("name"))
                    val author = getString(getColumnIndex("author"))
                    val pages = getInt(getColumnIndex("pages"))
                    val price = getDouble(getColumnIndex("price"))
                    Log.d("MainActivity", "book name is $name")
                    Log.d("MainActivity", "book author is $author")
                    Log.d("MainActivity", "book pages is $pages")
                    Log.d("MainActivity", "book price is $price")
                }
                close()
            }
        }
        binding.updateData.setOnClickListener {
            // 更新数据
            bookId?.let {
                val uri = Uri.parse("content://com.rxf113.databasetest.provider/book/$it")
                val values = contentValuesOf("name" to "A Storm of Swords", "pages" to 1216, "price" to 24.05)
                contentResolver.update(uri, values, null, null)
            }
        }
        binding.deleteData.setOnClickListener {
            // 删除数据
            bookId?.let {
                val uri = Uri.parse("content://com.rxf113.databasetest.provider/book/$it")
                contentResolver.delete(uri, null, null)
            }
        }
    }
}
