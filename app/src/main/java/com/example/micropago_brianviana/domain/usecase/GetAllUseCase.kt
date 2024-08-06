package com.example.micropago_brianviana.domain.usecase

import com.example.micropago_brianviana.data.HomeDataRepository
import com.example.micropago_brianviana.data.network.request.LoginUserRequest
import javax.inject.Inject

class GetAllUseCase @Inject constructor(
    private val repository: HomeDataRepository
) {
    suspend fun getData() = repository.getData()

    suspend fun loginUser(request: LoginUserRequest) = repository.loginUser(request)
}