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

class ErrorHandler @Inject constructor() {

    fun createErrorToastBar(
        throwable: Throwable,
        layoutInflater: LayoutInflater,
        context: Context
    ) {
        when (throwable) {
            is HttpException -> { createToastBarHttp(layoutInflater, context) }
            is ConnectException -> { createToastBarConnect(layoutInflater, context) }
            is ApiException -> { createToastBarHttp(layoutInflater, context) }
            else -> { createToastBarHttp(layoutInflater, context) }
        }
    }

    private fun createToastBarHttp(
        layoutInflater: LayoutInflater,
        context: Context
    ) {
        val layout = layoutInflater.inflate(R.layout.item_custom_snackbar_http, null)
        showToast(layout, context)
    }

    private fun createToastBarConnect(
        layoutInflater: LayoutInflater, context: Context
    ) {
        val layout = layoutInflater.inflate(R.layout.item_custom_snackbar_connect, null)
        showToast(layout, context)
    }

    private fun showToast(layout: View, context: Context) {
        val toast = Toast(context)
        with(toast) {
            setGravity(Gravity.TOP, 0, 0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}
