package com.example.koshelok.ui.util

import android.view.View
import com.example.koshelok.R
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import retrofit2.HttpException
import java.net.ConnectException
import javax.inject.Inject

class ErrorHandler @Inject constructor() {

    fun createErrorShackBar(throwable: Throwable, view: View) {
        when (throwable) {
            is HttpException -> {
                createSnackBar(view.context.getString(R.string.server_error), view)
            }
            is ConnectException -> {
                createSnackBar(view.context.getString(R.string.internet_error), view)
            }
            is ApiException -> {
                createSnackBar(view.context.getString(R.string.auth_error), view)
            }
            else -> {
                createSnackBar(view.context.getString(R.string.unknown_error), view)
            }
        }
    }

    private fun createSnackBar(message: String, view: View) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }
}
