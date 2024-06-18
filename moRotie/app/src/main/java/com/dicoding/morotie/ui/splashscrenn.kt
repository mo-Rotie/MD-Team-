package com.dicoding.morotie.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.morotie.R

class splashscrenn : AppCompatActivity() {private lateinit var progressBar: ProgressBar
    private val handler = Handler(Looper.getMainLooper())
    private var progressStatus = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscrenn)

        progressBar = findViewById(R.id.progressBar)

        handler.post(object : Runnable {
            override fun run() {
                if (progressStatus < 100) {
                    progressStatus += 1
                    progressBar.progress = progressStatus
                    handler.postDelayed(this, 30)
                } else {

                    startActivity(Intent(this@splashscrenn, MainActivity::class.java))
                    finish()
                }
            }
        })
    }
    }
