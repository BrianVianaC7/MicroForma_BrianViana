package com.example.micropago_brianviana.data.network

import com.example.micropago_brianviana.data.network.request.LoginUserRequest
import com.example.micropago_brianviana.data.network.response.HomeDataResponse
import com.example.micropago_brianviana.data.network.response.HomeResponse
import com.example.micropago_brianviana.data.network.response.LoginUserResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class HomeDataService @Inject constructor(
    private val homeDataApiClient: HomeDataApiClient
) {

    suspend fun getData(): List<HomeDataResponse> {
        return withContext(Dispatchers.IO) {
            val response: Response<HomeResponse> = homeDataApiClient.getData()
            val dataResponse: HomeResponse? = response.body()
            dataResponse?.data ?: emptyList()
        }
    }

    suspend fun loginUser(request: LoginUserRequest): LoginUserResponse {
        return withContext(Dispatchers.IO) {
            val response: Response<LoginUserResponse> = homeDataApiClient.loginUser(request)
            val errorResponse = response.errorBody()?.string()
            val errorMessage = try {
                Gson().fromJson(errorResponse, LoginUserResponse::class.java).messages
            } catch (e: Exception) {
                emptyList()
            }
            response.body() ?: throw IllegalStateException("Error: $errorMessage")
        }
    }
}