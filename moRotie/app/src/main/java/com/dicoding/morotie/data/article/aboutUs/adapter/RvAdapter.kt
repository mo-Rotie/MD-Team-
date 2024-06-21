package com.dicoding.morotie.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.morotie.R
import com.dicoding.morotie.model.DataItem
import com.dicoding.morotie.ui.AboutUsActivity

class RvAdapter(private val context: Context, private val items: ArrayList<DataItem>) : RecyclerView.Adapter<RvAdapter.DataHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_trivia, viewGroup, false)
        return DataHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.bindData(items[position])

    }

    inner class DataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItemPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvItemDescription: TextView = itemView.findViewById(R.id.tv_item_description)

        fun bindData(dataItem: DataItem) {

            val imageResource = context.resources.getIdentifier(
                dataItem.image!!,
                "drawable",
                context.packageName
            )

            Glide.with(itemView.context)
                .load(imageResource)
                .into(imgItemPhoto)

            tvItemName.text = dataItem.nama
            tvItemDescription.text = dataItem.deskripsi

        }
    }

    fun addItems(items: List<DataItem>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}
