package com.example.koshelok.data.mappers

import com.example.koshelok.domain.Response
import javax.inject.Inject

private const val OK_CODE = 200

class ServerCodeToResponseMapper @Inject constructor() : (Int) -> Response {

    override operator fun invoke(code: Int) =
        when (code) {
            OK_CODE -> Response.OK
            else -> Response.ERROR
        }
}
