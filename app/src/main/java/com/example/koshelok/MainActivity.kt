package com.example.koshelok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.KoshelOK)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
            val navController: NavController = navHostFragment.navController
            navController.navigate(R.id.detailWalletFragment)
        }
    }
}
