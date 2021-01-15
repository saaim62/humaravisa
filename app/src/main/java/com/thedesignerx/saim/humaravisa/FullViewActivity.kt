package com.thedesignerx.saim.humaravisa
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FullViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_view)
        // Get intent data
        val id = intent.extras!!.getInt("id")
        val pic = intent.extras!!.getInt("pic")
        val imageView = findViewById<ImageView>(R.id.SingleView)
        imageView.setImageResource(pic)
    }
}