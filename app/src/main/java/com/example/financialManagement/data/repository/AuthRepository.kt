package com.example.financialManagement.data.repository

import com.example.financialManagement.data.remote.ApiService
import com.example.financialManagement.domain.model.dto.LoginResponseDto
import com.example.financialManagement.domain.model.entity.LoginRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: ApiService
)  {
    suspend fun login(request: LoginRequest): LoginResponseDto {
        return apiService.login(request)
    }
}
