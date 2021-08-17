package com.example.koshelok.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract val bindingInflater: (inflater: LayoutInflater, viewGroup: ViewGroup?,
                                   attach: Boolean) -> VB

    private var _viewBinding: VB? = null
    protected val viewBinding: VB
        get() = requireNotNull(_viewBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_viewBinding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingView()
    }

    abstract fun settingView()

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}