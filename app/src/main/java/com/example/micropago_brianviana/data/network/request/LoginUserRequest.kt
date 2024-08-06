package com.example.micropago_brianviana.data.network.request

import com.google.gson.annotations.SerializedName

data class LoginUserRequest(
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("version") var version: String? = null,
    @SerializedName("origin") var origin: String? = null
)

//"username": "android",
//"password": "LuneS2024*",
//"version": "1.0.0",
//"origin": "mobile"
