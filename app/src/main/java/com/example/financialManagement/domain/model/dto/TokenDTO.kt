package com.example.financialManagement.domain.model.dto

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("sessionToken") val sessionToken: String,
    @SerializedName("refreshSessionToken") val refreshSessionToken: String
)