package com.dicoding.morotie.ui

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.morotie.R
import java.io.File

class UploadScanActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    private lateinit var imageUrl : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_upload_scan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnUpload = findViewById<Button>(R.id.uploadbtn)
        val btnCamera = findViewById<Button>(R.id.camerabtn)
        val btnResult = findViewById<Button>(R.id.resultbtn)
        val imgGallery = findViewById<ImageView>(R.id.imageView3)

        imageUrl = createImageUri()

        val contract = registerForActivityResult(ActivityResultContracts.GetContent()){
            imgGallery.setImageURI(it)
        }
        val contractCamera = registerForActivityResult(ActivityResultContracts.TakePicture()){
            imgGallery.setImageURI(null)
            imgGallery.setImageURI(imageUrl)
        }

        btnUpload.setOnClickListener {
            contract.launch("image/*")
        }

        btnCamera.setOnClickListener {
            contractCamera.launch(imageUrl)
        }

    }
    private fun createImageUri():Uri{
        val image = File(filesDir, "camera_photos.png")
        return FileProvider.getUriForFile(this,
            "com.dicoding.morotie.ui.FileProvider",
            image)
    }
}