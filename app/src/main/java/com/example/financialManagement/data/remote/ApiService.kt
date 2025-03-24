package com.example.financialManagement.data.remote

import com.example.financialManagement.domain.model.dto.LoginResponseDto
import com.example.financialManagement.domain.model.entity.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponseDto
}
