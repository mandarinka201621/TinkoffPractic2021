package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.ResponseWithWalletIdApi
import com.example.koshelok.ui.editwallet.ResponseWithWalletEntity
import javax.inject.Inject

class ResponseWithWalletApiToEntityMapper @Inject constructor(
    private val serverCodeMapper: ServerCodeToResponseMapper
) {

    operator fun invoke(responseWithWalletIdApi: ResponseWithWalletIdApi) =
        ResponseWithWalletEntity(
            responseWithWalletIdApi.walletId,
            serverCodeMapper(responseWithWalletIdApi.code)
        )
}
