package com.example.koshelok.ui.util

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.example.koshelok.R
import com.google.android.gms.common.api.ApiException
import retrofit2.HttpException
import java.net.ConnectException
import javax.inject.Inject

class ErrorHandler @Inject constructor(
    private val context: Context
) {

    fun createErrorToastBar(
        throwable: Throwable,
    ) {
        when (throwable) {
            is HttpException -> {
                showToast(R.layout.item_custom_snackbar_http)
            }
            is ConnectException -> {
                showToast(R.layout.item_custom_snackbar_connect)
            }
            is ApiException -> {
                showToast(R.layout.item_custom_snackbar_http)
            }
            else -> {
                showToast(R.layout.item_custom_snackbar_http)
            }
        }
    }

    private fun showToast(@LayoutRes layoutId: Int) {
        val layout = LayoutInflater.from(context).inflate(layoutId, null)
        val toast = Toast(context)
        with(toast) {
            setGravity(Gravity.TOP, 0, 0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}
