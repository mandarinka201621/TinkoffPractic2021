package com.example.koshelok.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.AccountSharedPreferences
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentOnboardingScreenBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class OnBoardingScreenFragment : Fragment(R.layout.fragment_onboarding_screen) {

    private val viewBinding by viewBinding(FragmentOnboardingScreenBinding::bind)
    private val loginResultHandler =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult? ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result?.data)
            val account = task.result

            startDetailWalletFragment(account)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.buttonGoogle.setOnClickListener {
            loginResultHandler.launch(getSignInIntent())
        }
    }

    override fun onStart() {
        super.onStart()
        context?.let {
            val account = GoogleSignIn.getLastSignedInAccount(it)
            startDetailWalletFragment(account)
        }
    }

    private fun getSignInIntent(): Intent {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        return mGoogleSignInClient.signInIntent
    }

    private fun startDetailWalletFragment(account: GoogleSignInAccount?) {
        if (account != null) {
            context?.let { AccountSharedPreferences.writeEmail(it, account.email ?: "") }
            viewBinding.buttonGoogle.visibility = View.INVISIBLE
        }
    }
}
