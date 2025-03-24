package com.example.financialManagement.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financialManagement.core.util.Resource
import com.example.financialManagement.domain.model.dto.LoginResponseDto
import com.example.financialManagement.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _loginState = MutableStateFlow<Resource<LoginResponseDto>>(Resource.Idle())
    val loginState: StateFlow<Resource<LoginResponseDto>> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            authUseCase.login(email, password).collectLatest { resource ->
                _loginState.value = resource
            }
        }
    }
}
