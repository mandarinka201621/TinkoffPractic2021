package com.example.koshelok.ui

import android.content.Context
import android.util.Log
import com.example.koshelok.R
import retrofit2.HttpException
import javax.inject.Inject

class ErrorHandler @Inject constructor(
    private val context: Context
) {

    fun createErrorShackBar(throwable: Throwable) {
        when (throwable) {
            is HttpException -> {
                createSnackBar(context.getString(R.string.server_error))
            }
            else -> {
                createSnackBar(context.getString(R.string.internet_error))
            }
        }
    }

    private fun createSnackBar(message: String) {
        Log.d("tut", message)
        /* Snackbar.make(context, message, Snackbar.LENGTH_SHORT)
             .apply {
                 view.setBackgroundColor(ContextCompat.getColor(context, R.color.errorSnackBarColor))
                 view.findViewById<TextView>(id.snackbar_text)
                     .setTextColor(Color.WHITE)
             }
             .show()*/
    }
}
