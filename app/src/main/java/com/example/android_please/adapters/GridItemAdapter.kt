package com.example.android_please.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_please.R
import com.example.android_please.fragments.BigPicFragment
import com.example.android_please.fragments.PhoneDialogFragment
import com.squareup.picasso.Picasso
import kotlin.coroutines.coroutineContext

class GridItemAdapter(val cardTitles: Array<String>, val cardImages: Array<String>, context: Context): RecyclerView.Adapter<GridItemAdapter.ViewHolder>() {


    val mCon = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardImage : ImageView = itemView.findViewById(R.id.cardImage)
        val cardTitle : TextView = itemView.findViewById(R.id.cardTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view, parent, false)
//        val cardSection = view.findViewById<CardView>(R.id.cardView)
//        cardSection.setOnClickListener{
//            val picUrl = cardSection.
//            val uri = Uri.parse()
//        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardTitle.text = "No.${position+1}: "+cardTitles[position]
        Picasso.get().load(cardImages[position]).into(holder.cardImage)
        holder.itemView.setOnClickListener {
            val uri = Uri.parse(cardImages[position])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            mCon.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return cardTitles.size
    }

}