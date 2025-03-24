package com.example.financialManagement.domain.model.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("balance") val balance: Int,
    @SerializedName("firebaseToken") val firebaseToken: String,
    @SerializedName("verified") val verified: Boolean,
    @SerializedName("monthlyIncome") val monthlyIncome: Int,
    @SerializedName("monthlyOutcome") val monthlyOutcome: Int
)

