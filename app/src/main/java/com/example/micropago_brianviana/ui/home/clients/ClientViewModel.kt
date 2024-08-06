package com.example.micropago_brianviana.ui.home.clients

import androidx.lifecycle.ViewModel
import com.example.micropago_brianviana.domain.usecase.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClientViewModel @Inject constructor(
    private val getAllUseCase: GetAllUseCase
) : ViewModel() {
}