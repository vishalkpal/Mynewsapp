package com.example.mynewsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class newslistadapter(private val listner:NewsItemCLicked): RecyclerView.Adapter<newsviewholder>() {

    private val items: ArrayList<News> =ArrayList()

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
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.image.context).load(currentItem.imageUrl).into(holder.image)
    }
    fun updateNews(updatedNews: ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }

}
class newsviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)
    val image: ImageView = itemView.findViewById(R.id.image)
    val author: TextView = itemView.findViewById(R.id.author)
}

interface NewsItemCLicked{
    fun onItemClicked(item: News)

}