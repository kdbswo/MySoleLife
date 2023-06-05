package com.loci.mysolelife.contentsList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.loci.mysolelife.R

class ContentRVAdapter(val context: Context, val items: ArrayList<ContentModel>) :
    RecyclerView.Adapter<ContentRVAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: ContentModel) {

            itemView.setOnClickListener {
                Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ContentShowActivity::class.java)
                intent.putExtra("url", item.webUrl)
                itemView.context.startActivity(intent)
            }

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

            bookmarkArea.setOnClickListener {
                Toast.makeText(context, "클릭", Toast.LENGTH_SHORT).show()
            }

            contentTitle.text = item.title
            Glide.with(context).load(item.imageUrl).into(imageViewArea)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}