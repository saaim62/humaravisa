package com.thedesignerx.saim.humaravisa

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.card2
import kotlinx.android.synthetic.main.activity_home.card3
import kotlinx.android.synthetic.main.activity_home.card4
import kotlinx.android.synthetic.main.activity_home.card5
import kotlinx.android.synthetic.main.activity_home.card6
import kotlinx.android.synthetic.main.activity_home.cardImgCake
import kotlinx.android.synthetic.main.activity_home.cardImgHalwa
import kotlinx.android.synthetic.main.activity_home.cardImgInstant
import kotlinx.android.synthetic.main.activity_home.cardImgSamosa
import kotlinx.android.synthetic.main.activity_home.cardImgSweet
import kotlinx.android.synthetic.main.activity_home.cardImgTvc
import kotlinx.android.synthetic.main.activity_home.cardList
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.gridhome.*

class ActivityMain : AppCompatActivity() {
//    private lateinit var adapter: GridAdapter
//    private var gd: GridData = GridData()
    private lateinit var gv: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        onClickListeners()
        video()
//        cardBackground()
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
        cardList.setBackgroundResource(R.drawable.shape_react01)
        card2.setBackgroundResource(R.drawable.shape_react01)
        card3.setBackgroundResource(R.drawable.shape_react01)
        card4.setBackgroundResource(R.drawable.shape_react01)
        card5.setBackgroundResource(R.drawable.shape_react01)
        card6.setBackgroundResource(R.drawable.shape_react01)
    }

    private fun onClickListeners() {
        searchView.setOnClickListener {
            etSearch.visibility = View.VISIBLE
            searchBtnClose.visibility = View.VISIBLE
        }
        searchBtnClose.setOnClickListener {
            etSearch.visibility = View.GONE
            searchBtnClose.visibility = View.GONE
        }
        cardImgCake.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityTouristVisa::class.java
                )
            )
        }

        cardImgSamosa.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityStudyVisa::class.java
                )
            )
        }

        cardImgSweet.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityWorkVisa::class.java
                )
            )
        }

        cardImgHalwa.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityApply::class.java
                )
            )
        }

        cardImgInstant.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityVideoGuide::class.java
                )
            )
        }

        cardImgTvc.setOnClickListener {
            startActivity(
                Intent(
                    this@ActivityMain,
                    ActivityContactUs::class.java
                )
            )
        }
    }
}