package com.thedesignerx.saim.humaravisa

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thedesignerx.saim.humaravisa.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_study_visa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityStudyVisa : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_visa)

        recyclerView1.setBackgroundResource(R.drawable.shape_react01)
        recycler()

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
                    this@ActivityStudyVisa,
                    restaurant.images,
                    restaurant.name
                )
                initRecyclerView()
            }

            private fun initRecyclerView() {
                val linearLayoutManager = LinearLayoutManager(
                    this@ActivityStudyVisa,
                    LinearLayoutManager.VERTICAL,
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


}