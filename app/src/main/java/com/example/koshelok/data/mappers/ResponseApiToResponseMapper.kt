package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.ResponseApi
import javax.inject.Inject

class ResponseApiToResponseMapper @Inject constructor(
    private val serverCodeMapper: ServerCodeToResponseMapper
) {

    operator fun invoke(responseApi: ResponseApi) =
        serverCodeMapper(responseApi.code)
}
