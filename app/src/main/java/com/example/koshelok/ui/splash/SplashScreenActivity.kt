package com.example.koshelok.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koshelok.MainActivity
import com.example.koshelok.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_sceen_activity)
        startActivity(Intent(this, MainActivity::class.java))
    }
}
