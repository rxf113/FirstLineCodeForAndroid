package com.rxf113.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.rxf113.materialtest.databinding.ActivityFruitBinding

class FruitActivity : AppCompatActivity() {

    companion object {
        const val FRUIT_NAME = "fruit_name"
        const val FRUIT_IMAGE_ID = "fruit_image_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fruitBinding = ActivityFruitBinding.inflate(layoutInflater)
        setContentView(fruitBinding.root)

        val fruitName = intent.getStringExtra(FRUIT_NAME)
        val fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID,0)
        setSupportActionBar(fruitBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fruitBinding.collapsingToolbar.title = fruitName
        Glide.with(this).load(fruitImageId).into(fruitBinding.fruitImageView)
        fruitBinding.fruitContentText.text = generateFruitContent(fruitName)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun generateFruitContent(fruitName: String) = fruitName.repeat(500)

}