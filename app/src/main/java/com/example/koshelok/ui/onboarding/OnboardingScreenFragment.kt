package com.example.koshelok.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.koshelok.databinding.FragmentOnboardingScreenBinding

class OnboardingScreenFragment : Fragment() {

    private var viewBinding: FragmentOnboardingScreenBinding? = null
    private val binding: FragmentOnboardingScreenBinding
        get() = viewBinding ?: throw NullPointerException("FragmentOnboardScreenBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentOnboardingScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGoogle.setOnClickListener {
            launchChooseRegisterFragment()
        }
    }

    private fun launchChooseRegisterFragment() {
        TODO()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}
