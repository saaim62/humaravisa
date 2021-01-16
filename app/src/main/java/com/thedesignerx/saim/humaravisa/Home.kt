package com.thedesignerx.saim.humaravisa

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.cardList
import kotlinx.android.synthetic.main.gridhome.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gridhome)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        cardList.setBackgroundResource(R.drawable.shape_react01)
        nestedScrollView.isEnableScrolling = true
    }
}