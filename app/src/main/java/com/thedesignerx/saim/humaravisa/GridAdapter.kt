//package com.thedesignerx.saim.humaravisa
//
//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast
//import androidx.cardview.widget.CardView
//import java.util.*
//
//class GridAdapter(private var c: Context, private var quotes: ArrayList<Quote>) : BaseAdapter() {
//
//    override fun getCount(): Int {
//        return quotes.size
//    }
//
//    override fun getItem(i: Int): Any {
//        return quotes[i]
//    }
//
//    override fun getItemId(i: Int): Long {
//        return i.toLong()
//    }
//
//    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
//        var view = view
//        if (view == null) {
//            //inflate layout resource if its null
//            view = LayoutInflater.from(c).inflate(R.layout.list_item, viewGroup, false)
//            val cardListItem = view?.findViewById(R.id.card1) as CardView
//            cardListItem.setBackgroundResource(R.drawable.shape_react01)
//        }
//
//        //get current quote
//        val quote = this.getItem(i) as Quote
//
//        //reference textviews and imageviews from our layout
//        val img = view.findViewById(R.id.cardImg) as ImageView
//        val nameTxt = view.findViewById(R.id.cardText) as TextView
//
//        //BIND data to TextView and ImageVoew
//        nameTxt.text = quote.getQuote()
//        img.setImageResource(quote.getImage())
//        view.setOnClickListener { Toast.makeText(c, quote.getQuote(), Toast.LENGTH_SHORT).show()
//            val intentGrid = Intent(c , FullViewActivity::class.java)
//            intentGrid.putExtra("id", i)
//            intentGrid.putExtra("pic", quote.getImage())
//            c.startActivity(intentGrid)
//        }
//
//        return view
//    }
//}
//
//class Quote(private var quote: String, private var image: Int) {
//
//    fun getQuote(): String {
//        return quote
//    }
//
//    fun getImage(): Int {
//        return image
//    }
//}
