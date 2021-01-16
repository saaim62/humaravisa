package com.thedesignerx.saim.humaravisa

import android.content.ContentValues
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.jaeger.library.StatusBarUtil


class ImageGallaryDetailActivity : AppCompatActivity() {
    lateinit var button_close: Button
    lateinit var textView: TextView

    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_recyclerview)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        button_close = findViewById<TextView>(R.id.button_close) as Button
        textView = findViewById(R.id.textView)
        StatusBarUtil.setTransparent(this)

        val contactList = intent.extras!!.getSerializable("contact") as List<Image>
        val name = intent.extras!!.getString("name") as String
        Log.d(ContentValues.TAG, "name       $name")
        Log.d(ContentValues.TAG, "contactlist  $contactList")
        val position = intent.extras!!.getInt("img position")

        recyclerView = findViewById<RecyclerView?>(R.id.recyclerView2)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = ZoomRecyclerAdapter(this@ImageGallaryDetailActivity, contactList)


        initRecyclerView()
        textView.text = name
        button_close.setOnClickListener {
            finish()
        }
        recyclerView?.scrollToPosition(position)
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(recyclerView)
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this@ImageGallaryDetailActivity, LinearLayoutManager.HORIZONTAL, false)
        findViewById<RecyclerView?>(R.id.recyclerView2)?.layoutManager = linearLayoutManager

    }
}
