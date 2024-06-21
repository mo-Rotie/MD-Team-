package com.dicoding.morotie.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.morotie.R
import com.dicoding.morotie.adapter.RvAdapter
import com.dicoding.morotie.model.DataItem

class AboutUsActivity : AppCompatActivity() {
    private lateinit var rvItem: RecyclerView
    private lateinit var adapter: RvAdapter
    private var dataItems = arrayListOf<DataItem>(
        DataItem("lazuardi","Muhammad Lazuardi Harahap"," I'm Muhammad Lazuardi Harahap from ML-67. Machine Learning Cohort 2024 Batch 1 at Bangkit Academy Ied by Google, Tokopedia, Gojek, & Traveloka."),
        DataItem("mario","Mario Veri Chuandra","Cloud Computing Cohort at Bangkit 2024 Batch 1. Originally a student from Universitas Mikroskil majoring in Computer Science."),
        DataItem("daniel","Daniel Haganta Barus","Mobile Development Cohort 2024 Batch 1 at Bangkit Academy led by Google, Tokopedia, Gojek, & Traveloka and student from Universitas Prima Indonesia, Sumatera Utara"),
        DataItem("frans","Frans Yohanes Padang","Hi, I am Frans, a student majoring in informatics at Mikroskil University. I am currently one of the students in the Bangkit Academy 2024 program by Google, GoTo, Tokopedia, Traveloka, and I am taking the Mobile Development learning path."),
        DataItem("willy","Willy Rumapea","Hello, my name is Willy Rumapea from CC-49 as a Cloud Computing Cohort 2024 Batch 1 at Bangkit Academy Ied by Google, Tokopedia, Gojek, & Traveloka."),
        DataItem("imanuel","Immanuel Samosir","Hello, i am Immanuel from ML-70 as a Machine Learning Cohort 2024 Batch 1 at Bangkit Academy Ied by Google, Tokopedia, Gojek, & Traveloka."),
        DataItem("brata","Brata Wijaya","Brata is my nickname and my real name is Brata Wijaya. I'm from Machine Learning learning path from ML-41 class at Bangkit Academy Ied by Google, Tokopedia, Gojek, & Traveloka."),

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        init()
        setupUI()

    }

    private fun init() {
        rvItem = findViewById(R.id.rv_item)
        rvItem.layoutManager = LinearLayoutManager(this)
        adapter = RvAdapter(this, arrayListOf())
        rvItem.adapter = adapter
    }

    private fun setupUI() {
        getData()
    }

    private fun getData() {
        retrieveList(dataItems)
    }

    private fun retrieveList(items: List<DataItem>) {
        adapter.apply {
            addItems(items)
            notifyDataSetChanged()
        }
    }

}