package com.dicoding.morotie.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.morotie.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val btnRealtime = findViewById<Button>(R.id.realtime_scan_btn)
        val btnUpload = findViewById<Button>(R.id.upload_scan_button)
        val btnTrivia = findViewById<Button>(R.id.trivia_btn)
        val btnAboutUs = findViewById<Button>(R.id.aboutUs_btn)

        btnRealtime.setOnClickListener {
            val intent = Intent(this, RealTimeScanActivity::class.java)
            startActivity(intent)
        }

        btnUpload.setOnClickListener {
            val intent = Intent(this, UploadScanActivity::class.java)
            startActivity(intent)
        }

        btnTrivia.setOnClickListener {
            val intent =Intent(this, ArticleActivity::class.java)
            startActivity(intent)
        }

        btnAboutUs.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }

    }
}