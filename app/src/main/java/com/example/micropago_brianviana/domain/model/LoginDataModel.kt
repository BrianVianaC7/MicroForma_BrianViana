package com.example.micropago_brianviana.domain.model

import com.example.micropago_brianviana.data.network.response.LoginUserResponse

data class LoginDataModel(
    var accessToken: String? = null,
    var userId: Int? = null,
    var descEnv: String? = null,
    var messages: ArrayList<String> = arrayListOf()
)

fun LoginUserResponse.toDomain() = LoginDataModel(
    accessToken = accessToken,
    userId = userId,
    descEnv = descEnv,
    messages = messages
)

