package com.thedesignerx.saim.humaravisa

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.thedesignerx.saim.humaravisa.R
import kotlinx.android.synthetic.main.activity_video_guide.*

class ActivityVideoGuide : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_guide)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        onClickListeners()
    }

    private fun onClickListeners() {
        val vidTouristBtn = findViewById<Button>(R.id.vidTouristBtn)
        vidTouristBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityVideoGuide,
                    ActivityTouristVisa::class.java
                )
            )
        }

        val vidStudyBtn = findViewById<Button>(R.id.vidStudyBtn)
        vidStudyBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityVideoGuide,
                    ActivityStudyVisa::class.java
                )
            )
        }

        val vidWorkBtn = findViewById<Button>(R.id.vidWorkBtn)
        vidWorkBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityVideoGuide,
                    ActivityVidGuideRecyclerView::class.java
                )
            )
        }
    }
}