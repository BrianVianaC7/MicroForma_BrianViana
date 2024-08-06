package com.example.micropago_brianviana.data

import com.example.micropago_brianviana.data.network.HomeDataService
import com.example.micropago_brianviana.data.network.request.LoginUserRequest
import com.example.micropago_brianviana.data.network.response.HomeDataResponse
import com.example.micropago_brianviana.data.network.response.LoginUserResponse
import com.example.micropago_brianviana.domain.model.HomeDataModel
import com.example.micropago_brianviana.domain.model.LoginDataModel
import com.example.micropago_brianviana.domain.model.toDomain
import javax.inject.Inject

class HomeDataRepository @Inject constructor(
    private val api: HomeDataService
) {

    suspend fun getData(): List<HomeDataModel> {
        val response: List<HomeDataResponse> = api.getData()
        return response.map { convert -> convert.toDomain() }
    }


    suspend fun loginUser(request: LoginUserRequest): LoginDataModel {
        val response: LoginUserResponse = api.loginUser(request)
        return response.toDomain()
    }
}