package com.example.mynewsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class newslistadapter(val items: ArrayList<String>, private val listner:NewsItemCLicked): RecyclerView.Adapter<newsviewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsviewholder {

        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = newsviewholder(View)
        View.setOnClickListener {
             listner.onItemClicked(items[viewHolder.absoluteAdapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: newsviewholder, position: Int) {

        val currentItem = items[position]
        holder.titleView.text = currentItem
    }

}
class newsviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)

}

interface NewsItemCLicked{
    fun onItemClicked(item: String)
}