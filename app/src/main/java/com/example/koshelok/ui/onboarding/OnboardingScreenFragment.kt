package com.example.koshelok.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentOnboardingScreenBinding

class OnboardingScreenFragment : Fragment(R.layout.fragment_onboarding_screen) {

    private val viewBinding by viewBinding(FragmentOnboardingScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.buttonGoogle.setOnClickListener {
            launchChooseRegisterFragment()
        }
    }

    private fun launchChooseRegisterFragment() {
        TODO()
    }
}
