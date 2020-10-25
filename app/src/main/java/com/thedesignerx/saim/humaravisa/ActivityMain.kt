package com.thedesignerx.saim.humaravisa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_recyclerview)
        onClickListeners()
        cardBackground()
        video()
    }
    override fun onResume() {
        super.onResume()
        video()
    }

    private fun video() {
        val videoView = findViewById<View>(R.id.videoView) as VideoView
        val uri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.introvid)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.setOnPreparedListener { mp -> mp.isLooping = true }
        videoView.start()
    }

    private fun cardBackground() {
        card1.setBackgroundResource(R.drawable.shape_react01)
        card2.setBackgroundResource(R.drawable.shape_react01)
        card3.setBackgroundResource(R.drawable.shape_react01)
        card4.setBackgroundResource(R.drawable.shape_react01)
        card5.setBackgroundResource(R.drawable.shape_react01)
        card6.setBackgroundResource(R.drawable.shape_react01)
    }

    private fun onClickListeners() {
        val touristBtn = findViewById<Button>(R.id.touristBtn)
        touristBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityTouristVisa::class.java
                )
            )
        }

        val studyBtn = findViewById<Button>(R.id.studyBtn)
        studyBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityStudyVisa::class.java
                )
            )
        }

        val workBtn = findViewById<Button>(R.id.workBtn)
        workBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityWorkVisa::class.java
                )
            )
        }

        val applyBtn = findViewById<Button>(R.id.applyBtn)
        applyBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityApply::class.java
                )
            )
        }

        val guideBtn = findViewById<Button>(R.id.guideBtn)
        guideBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityVideoGuide::class.java
                )
            )
        }

        val contactBtn = findViewById<Button>(R.id.contactBtn)
        contactBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityContactUs::class.java
                )
            )
        }
    }
}