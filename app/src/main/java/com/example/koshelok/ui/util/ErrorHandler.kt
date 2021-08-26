package com.example.koshelok.ui.util

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
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
        layoutInflater: LayoutInflater,
    ) {
        when (throwable) {
            is HttpException -> {
                createToastBarHttp(layoutInflater)
            }
            is ConnectException -> {
                createToastBarConnect(layoutInflater)
            }
            is ApiException -> {
                createToastBarHttp(layoutInflater)
            }
            else -> {
                createToastBarHttp(layoutInflater)
            }
        }
    }

    private fun createToastBarHttp(layoutInflater: LayoutInflater) {
        val layout = layoutInflater.inflate(R.layout.item_custom_snackbar_http, null)
        showToast(layout)
    }

    private fun createToastBarConnect(layoutInflater: LayoutInflater) {
        val layout = layoutInflater.inflate(R.layout.item_custom_snackbar_connect, null)
        showToast(layout)
    }

    private fun showToast(layout: View) {
        val toast = Toast(context)
        with(toast) {
            setGravity(Gravity.TOP, 0, 0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}
