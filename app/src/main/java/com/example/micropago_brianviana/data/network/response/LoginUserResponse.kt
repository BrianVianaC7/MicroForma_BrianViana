package com.example.micropago_brianviana.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginUserResponse(
    @SerializedName("access_token") var accessToken: String? = null,
    @SerializedName("userId") var userId: Int? = null,
    @SerializedName("descEnv") var descEnv: String? = null,
    @SerializedName("messages") var messages: ArrayList<String> = arrayListOf()
)