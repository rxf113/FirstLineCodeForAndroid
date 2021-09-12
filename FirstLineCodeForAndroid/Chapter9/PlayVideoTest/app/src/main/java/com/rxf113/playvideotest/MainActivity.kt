package com.rxf113.playvideotest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rxf113.playvideotest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")

        binding.apply {
            videoView.setVideoURI(uri)
            play.setOnClickListener {
                if (!videoView.isPlaying) {
                    videoView.start() // 开始播放
                }
                Log.d("MainActivity", "video is playing")
            }
            pause.setOnClickListener {
                if (videoView.isPlaying) {
                    videoView.pause() // 暂停播放
                }
            }
            replay.setOnClickListener {
                if (videoView.isPlaying) {
                    videoView.resume() // 重新播放
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.videoView.suspend()
    }

}