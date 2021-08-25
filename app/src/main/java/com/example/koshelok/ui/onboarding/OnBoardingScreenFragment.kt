package com.example.koshelok.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentOnboardingScreenBinding
import com.example.koshelok.domain.Result
import com.example.koshelok.ui.main.appComponent
import com.example.koshelok.ui.util.ErrorHandler
import com.example.koshelok.ui.util.factory.ViewModelFactory
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import javax.inject.Inject

class OnBoardingScreenFragment : Fragment(R.layout.fragment_onboarding_screen) {

    @Inject
    lateinit var errorHandler: ErrorHandler

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewBinding by viewBinding(FragmentOnboardingScreenBinding::bind)
    private val viewModel: OnBoardScreenViewModel by viewModels { viewModelFactory }
    private val loginResultHandler =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult? ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result?.data)
            val account = task.result
            if (account != null) {
                startDetailWalletFragment(account)
            }
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        if (account != null) {
            findNavController().navigate(
                R.id.walletListFragment, null, NavOptions.Builder()
                    .setPopUpTo(R.id.onboardScreenFragment, true)
                    .build()
            )
        }
        viewBinding.buttonGoogle.setOnClickListener {
            loginResultHandler.launch(getSignInIntent())
        }

        viewModel.resultData.observe(viewLifecycleOwner) { result: Result ->
            when (result) {
                is Result.Success<*> -> {
                    findNavController()
                        .navigate(R.id.action_onboardScreenFragment_to_walletListFragment)
                }
                is Result.Error -> errorHandler.createErrorShackBar(
                    result.throwable,
                    viewBinding.root
                )
            }
        }
    }

    private fun getSignInIntent(): Intent {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        return mGoogleSignInClient.signInIntent
    }

    private fun startDetailWalletFragment(account: GoogleSignInAccount) {
        val email = account.email.orEmpty()
        viewModel.registrationUser(email = email)
    }
}
