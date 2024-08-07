package com.example.micropago_brianviana.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.micropago_brianviana.data.network.request.LoginUserRequest
import com.example.micropago_brianviana.domain.model.HomeDataModel
import com.example.micropago_brianviana.domain.model.LoginDataModel
import com.example.micropago_brianviana.domain.usecase.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getAllUseCase: GetAllUseCase
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    suspend fun loginUser(request: LoginUserRequest): LoginDataModel {
        _isLoading.value = true
        return try {
            getAllUseCase.loginUser(request)
        } finally {
            _isLoading.value = false
        }
    }
}