package com.example.projectshub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LandingActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        supportActionBar?.hide()
    }
}