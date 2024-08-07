package com.example.micropago_brianviana.ui.home.clients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.micropago_brianviana.domain.model.HomeDataModel
import com.example.micropago_brianviana.domain.usecase.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientViewModel @Inject constructor(
    private val getAllUseCase: GetAllUseCase
) : ViewModel() {

    private val _data = MutableStateFlow<List<HomeDataModel>>(emptyList())
    val data: StateFlow<List<HomeDataModel>> get() = _data

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun getData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val dataFromApi = getAllUseCase.getData()
                _data.value = dataFromApi
            } catch (e: Exception) {
                _data.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}