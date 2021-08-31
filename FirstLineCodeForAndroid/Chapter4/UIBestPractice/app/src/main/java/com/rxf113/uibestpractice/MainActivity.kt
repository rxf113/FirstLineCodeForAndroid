package com.rxf113.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rxf113.uibestpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()

    //private var adapter: MsgAdapter? = null
    private lateinit var adapter: MsgAdapter

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

//        if(!::adapter.isInitialized){
//         判断延迟初始化
//        }

        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }


        binding.recyclerView.adapter = adapter
        binding.send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.send -> {
                val content = binding.inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新RecyclerView中的显示
                    binding.recyclerView.scrollToPosition(msgList.size - 1)  // 将 RecyclerView定位到最后一行
                    binding.inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}