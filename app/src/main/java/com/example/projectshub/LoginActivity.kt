package com.example.projectshub

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class LoginActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val btn=findViewById<MaterialButton>(R.id.loginBtnMain)
        btn.setOnClickListener{
            val intent=Intent(this,DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}