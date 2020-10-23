package com.thedesignerx.saim.humaravisa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.thedesignerx.saim.humaravisa.ZoomRecyclerAdapter.RecyclerViewHolder
import com.zolad.zoominimageview.ZoomInImageView

class ZoomRecyclerAdapter(private val context: Context?, private val items: List<Image>) :
    RecyclerView.Adapter<RecyclerViewHolder?>() {
    inner class RecyclerViewHolder(itemView: View) : ViewHolder(itemView) {
//        var imageView2: ZoomInImageView = itemView.findViewById<View>(R.id.imageView2) as ZoomInImageView

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ZoomRecyclerAdapter.RecyclerViewHolder {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_zoom, parent, false)

        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZoomRecyclerAdapter.RecyclerViewHolder, position: Int) {
//        val item = items[position]
//        if (context != null) {
//            Glide.with(context)
//                .load(item.url)
//                .into(holder.imageView2)
//
//        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}