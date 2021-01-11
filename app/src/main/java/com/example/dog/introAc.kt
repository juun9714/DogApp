package com.example.dog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class introAc : AppCompatActivity() {
    private val time : Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },time)
    }
}