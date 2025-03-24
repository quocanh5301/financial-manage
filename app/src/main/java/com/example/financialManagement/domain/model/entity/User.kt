package com.example.financialManagement.domain.model.entity

data class User(
    val id: String,
    val name: String,
    val email: String,
    val balance: Int,
    val firebaseToken: String,
    val isVerified: Boolean,
    val monthlyIncome: Int,
    val monthlyOutcome: Int
)
