package com.example.financialManagement.domain.model.dto

import com.google.gson.annotations.SerializedName

data class LoginResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: LoginData?
)

data class LoginData(
    @SerializedName("user") val user: UserDto,
    @SerializedName("token") val token: TokenDto
)

