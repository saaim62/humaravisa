package com.thedesignerx.saim.humaravisa

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_small_recyclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SmallImageActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_recyclerview)

        onClickListeners()
        cardBackground()
        video()
        recycler()
    }
    override fun onResume() {
        super.onResume()
        video()
    }
    private fun recycler() {
        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Api::class.java)
        Log.d(ContentValues.TAG, "onClick  " + api.getContact())

        api.getContact()?.enqueue(object : Callback<JSONRestaurant?> {
            override fun onResponse(
                call: Call<JSONRestaurant?>?,
                response: Response<JSONRestaurant?>?
            ) {
                val restaurant = response?.body() as JSONRestaurant
                recyclerView?.adapter = SmallRecyclerAdapter(
                    this@SmallImageActivity,
                    restaurant.images,
                    restaurant.name
                )
                initRecyclerView()
            }

            private fun initRecyclerView() {
                val linearLayoutManager = LinearLayoutManager(
                    this@SmallImageActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                findViewById<RecyclerView?>(R.id.recyclerView1)?.layoutManager = linearLayoutManager
            }

            override fun onFailure(call: Call<JSONRestaurant?>?, t: Throwable?) {
                if (t != null) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
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
                    this@SmallImageActivity,
                    ActivityTouristVisa::class.java
                )
            )
        }

        val studyBtn = findViewById<Button>(R.id.studyBtn)
        studyBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@SmallImageActivity,
                    ActivityStudyVisa::class.java
                )
            )
        }

        val workBtn = findViewById<Button>(R.id.workBtn)
        workBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@SmallImageActivity,
                    ActivityWorkVisa::class.java
                )
            )
        }

        val applyBtn = findViewById<Button>(R.id.applyBtn)
        applyBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@SmallImageActivity,
                    ActivityApply::class.java
                )
            )
        }

        val guideBtn = findViewById<Button>(R.id.guideBtn)
        guideBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@SmallImageActivity,
                    ActivityVideoGuide::class.java
                )
            )
        }

        val contactBtn = findViewById<Button>(R.id.contactBtn)
        contactBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@SmallImageActivity,
                    ActivityContactUs::class.java
                )
            )
        }
    }
}