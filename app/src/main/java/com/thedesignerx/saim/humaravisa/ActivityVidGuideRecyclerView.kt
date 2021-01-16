package com.thedesignerx.saim.humaravisa

import android.content.ContentValues
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tourist_visa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityVidGuideRecyclerView : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vid_guide_recyclerview)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        recycler()

    }
    private fun recycler() {
        recyclerView = findViewById(R.id.recyclerViewVidGuide)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Api::class.java)
        Log.d(ContentValues.TAG, "onClick  " + api.getContact())

        api.getContact()?.enqueue(object : Callback<JsonVisa?> {
            override fun onResponse(
                call: Call<JsonVisa?>?,
                response: Response<JsonVisa?>?
            ) {
                val visa = response?.body() as JsonVisa
                recyclerView?.adapter = VidGuideRecyclerAdapter(
                    this@ActivityVidGuideRecyclerView,
                    visa.videos
                )
                initRecyclerView()
            }

            private fun initRecyclerView() {
                val linearLayoutManager = LinearLayoutManager(
                    this@ActivityVidGuideRecyclerView,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                findViewById<RecyclerView?>(R.id.recyclerViewVidGuide)?.layoutManager = linearLayoutManager
            }

            override fun onFailure(call: Call<JsonVisa?>?, t: Throwable?) {
                if (t != null) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}