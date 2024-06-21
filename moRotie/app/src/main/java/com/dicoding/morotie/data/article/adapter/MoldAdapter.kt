package com.dicoding.morotie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.morotie.R
import com.dicoding.morotie.model.MoldItem

class MoldAdapter(
    private val moldList: List<MoldItem>,
    private val listener: (MoldItem) -> Unit
) : RecyclerView.Adapter<MoldAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_trivia, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mold = moldList[position]

        holder.tvItemName.text = mold.Nama
        holder.tvItemDescription.text = mold.Deskripsi

        Glide.with(holder.itemView.context)
            .load(mold.Gambar)
            .centerCrop()
            .into(holder.imgItemPhoto)

        holder.itemView.setOnClickListener { listener(mold) }
    }

    override fun getItemCount(): Int {
        return moldList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItemPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvItemDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}
