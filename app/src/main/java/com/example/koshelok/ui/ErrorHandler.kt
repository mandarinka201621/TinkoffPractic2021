package com.example.koshelok.ui

import android.view.View
import com.example.koshelok.R
import com.google.android.material.snackbar.Snackbar
import retrofit2.HttpException
import javax.inject.Inject

class ErrorHandler @Inject constructor() {

    fun createErrorShackBar(throwable: Throwable, view: View) {
        when (throwable) {
            is HttpException -> {
                createSnackBar(view.context.getString(R.string.server_error), view)
            }
            else -> {
                createSnackBar(view.context.getString(R.string.internet_error), view)
            }
        }
    }

    private fun createSnackBar(message: String, view: View) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }
}
