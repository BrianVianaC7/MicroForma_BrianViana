package com.example.micropago_brianviana.data.network

import com.example.micropago_brianviana.data.network.request.LoginUserRequest
import com.example.micropago_brianviana.data.network.response.HomeResponse
import com.example.micropago_brianviana.data.network.response.LoginUserResponse

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeDataApiClient {

    @POST("sgsmicroformas.login/api/auth/token")
    suspend fun loginUser(@Body request: LoginUserRequest): Response<LoginUserResponse>

    @GET("SgsMicroformas.Mobile.Cat/api/Ars/Technical?Id=126&Source=Microformas")
    suspend fun getData(): Response<HomeResponse>


}
