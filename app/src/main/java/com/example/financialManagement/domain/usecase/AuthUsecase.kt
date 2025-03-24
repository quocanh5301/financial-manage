package com.example.financialManagement.domain.usecase

import com.example.financialManagement.core.util.Resource
import com.example.financialManagement.data.repository.AuthRepository
import com.example.financialManagement.domain.model.dto.LoginResponseDto
import com.example.financialManagement.domain.model.entity.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    fun login(email: String, password: String): Flow<Resource<LoginResponseDto>> = flow {
        try {
            emit(Resource.Loading())
            val request = LoginRequest(email, password)
            val response = authRepository.login(request)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}
