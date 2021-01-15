package com.thedesignerx.saim.humaravisa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.GridView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import saim.com.ButtSweets.activities.main.GridData

class ActivityMain : AppCompatActivity() {
    private lateinit var adapter: GridAdapter
    private var gd: GridData = GridData()
    private lateinit var gv: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        gv = findViewById(R.id.gridview)
        //instantiate and set adapter
        adapter = GridAdapter(this, gd.data)
        gv.adapter = adapter

        gv.setOnScrollListener(object : AbsListView.OnScrollListener {
            //     Boolean isScrollStop=false;
            override fun onScrollStateChanged(view: AbsListView, scrollState: Int) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    (gv.adapter as GridAdapter).notifyDataSetChanged()
                }
            }

            override fun onScroll(
                view: AbsListView, firstVisibleItem: Int,
                visibleItemCount: Int, totalItemCount: Int
            ) {
            }
        })

        onClickListeners()
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