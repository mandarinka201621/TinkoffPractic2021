package com.example.koshelok.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koshelok.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.KoshelOK)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
