package com.example.koshelok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.KoshelOK)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
