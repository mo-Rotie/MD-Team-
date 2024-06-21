package com.dicoding.morotie.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.dicoding.morotie.R
import com.dicoding.morotie.databinding.ActivityMainBinding
import com.dicoding.picodiploma.mycamera.UploadFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private var currentImageUri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        bottomNavigationView = binding.bottomNavigationn

        replaceFragment(HomeFragment())
        binding.bottomNavigationn.background = null

        binding.bottomNavigationn.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeNav -> replaceFragment(HomeFragment())
                R.id.uploadNav -> replaceFragment(UploadFragment())
            }
            true
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val btnRealtime = binding.realtimeScanBtn

        btnRealtime.setOnClickListener {
            val intent = Intent(this, RealTimeScanActivity::class.java)
            startActivity(intent)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFrame, fragment)
        fragmentTransaction.commit()
    }

    private fun startCameraX() {
        val intent = Intent(this, RealTimeScanActivity::class.java)
    }



}