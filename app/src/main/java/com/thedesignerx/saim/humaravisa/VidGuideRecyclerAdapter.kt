package com.thedesignerx.saim.humaravisa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.zolad.zoominimageview.ZoomInImageView

class VidGuideRecyclerAdapter(
    private val context: Context?,
    private val items: List<Video>
) :
    RecyclerView.Adapter<VidGuideRecyclerAdapter.RecyclerViewHolder?>() {
    inner class RecyclerViewHolder(itemView: View) : ViewHolder(itemView) {
        var vidCardImg: TextView = itemView.findViewById<View>(R.id.vidCardImg) as TextView
        var vidCardText: TextView = itemView.findViewById<View>(R.id.vidCardText) as TextView

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VidGuideRecyclerAdapter.RecyclerViewHolder {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_vid_work, parent, false)

        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: VidGuideRecyclerAdapter.RecyclerViewHolder,
        position: Int
    ) {
        val item = items[position]
        if (context != null) {
            holder.vidCardText.text = item.name
            holder.vidCardImg.text = item.url

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}