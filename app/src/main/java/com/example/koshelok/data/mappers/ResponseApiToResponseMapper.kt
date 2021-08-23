package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.ResponseApi
import com.example.koshelok.domain.Response
import javax.inject.Inject

class ResponseApiToResponseMapper @Inject constructor() {

    operator fun invoke(responseApi: ResponseApi) =
        Response(responseApi.code)
}
