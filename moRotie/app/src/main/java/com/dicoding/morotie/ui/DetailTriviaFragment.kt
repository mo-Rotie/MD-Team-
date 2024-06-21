package com.dicoding.morotie.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dicoding.morotie.R


 class DetailTriviaFragment : Fragment() {private lateinit var nama: String
     private lateinit var deskripsi: String
     private lateinit var gambar: String

     private lateinit var imageView: ImageView

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         arguments?.let {
             nama = it.getString("nama", "")
             deskripsi = it.getString("deskripsi", "")
             gambar = it.getString("gambar", "")
         }
     }

     override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         val view = inflater.inflate(R.layout.fragment_detail_trivia, container, false)

         view.findViewById<TextView>(R.id.tv_item_name).text = nama
         view.findViewById<TextView>(R.id.tv_item_description).text = deskripsi
         imageView = view.findViewById(R.id.img_item_photo)

         Glide.with(this)
             .load(gambar)
             .centerCrop()
             .into(imageView)

         return view
     }
}