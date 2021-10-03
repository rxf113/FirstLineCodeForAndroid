package com.rxf113.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putInt
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rxf113.jetpacktest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(this, MainViewModelFactory(countReserved))
            .get(MainViewModel::class.java)

        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.plusOneBtn.setOnClickListener {
            //viewModel.counter++
            //refreshCounter()
            viewModel.plusOne()
        }

        binding.clearBtn.setOnClickListener {
//            viewModel.counter = 0
//            refreshCounter()
            viewModel.clear()
        }

        viewModel.counter.observe(this, Observer { count ->
            binding.infoText.text = count.toString()
        })

        //refreshCounter()

        lifecycle.addObserver(MyObserver(lifecycle))
    }

    override fun onPause() {
        super.onPause()
        // sp.edit().putInt("count_reserved", viewModel.counter)
         sp.edit().putInt("count_reserved", viewModel.counter.value ?: 0)
    }

    private fun refreshCounter() {
        binding.infoText.text = viewModel.counter.toString()
    }
}