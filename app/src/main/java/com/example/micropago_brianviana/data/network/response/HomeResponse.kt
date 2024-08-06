package com.example.micropago_brianviana.data.network.response

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("statusCode") var statusCode: Int? = null,
    @SerializedName("data") var data: ArrayList<HomeDataResponse> = arrayListOf()
)