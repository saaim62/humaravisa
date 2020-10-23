package com.thedesignerx.saim.humaravisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thedesignerx.saim.humaravisa.R
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        card1.setBackgroundResource(R.drawable.shape_react01)
    }
}