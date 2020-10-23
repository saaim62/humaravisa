package com.thedesignerx.saim.humaravisa

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.thedesignerx.saim.humaravisa.SmallRecyclerAdapter.RecyclerViewHolder
import com.zolad.zoominimageview.ZoomInImageView
import java.io.Serializable

class SmallRecyclerAdapter(
    private val context: Context?,
    private val items: List<Image>,
    private val name: String
) : RecyclerView.Adapter<RecyclerViewHolder?>() {

    inner class RecyclerViewHolder(itemView: View?) : ViewHolder(itemView!!) {
        lateinit var imageView1: ZoomInImageView

        init {
            if (itemView != null) {
                imageView1 = itemView.findViewById<View?>(R.id.cardImg) as ZoomInImageView
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_small_images, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = items[position]
        if (context != null) {
            Glide.with(context)
                .load(item.url)
                .into(holder.imageView1)

            holder.adapterPosition
            holder.imageView1.setOnClickListener {
                moveToImageViewerScreen(holder)
            }
        }
    }

    private fun moveToImageViewerScreen(holder: RecyclerViewHolder) {
        val intent = Intent(context, ImageGallaryDetailActivity::class.java)
        intent.putExtra("img position", holder.adapterPosition)
        intent.putExtra("name", name)
        intent.putExtra("contact", items as Serializable)

        context?.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}