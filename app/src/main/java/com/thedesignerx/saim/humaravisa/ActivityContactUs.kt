package com.thedesignerx.saim.humaravisa

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thedesignerx.saim.humaravisa.R

class ActivityContactUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }
}