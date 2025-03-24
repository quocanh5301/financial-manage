package com.example.financialManagement.core.util

import com.example.financialManagement.domain.model.dto.UserDto
import com.example.financialManagement.domain.model.entity.User

fun UserDto.toLocalClass(): User {
    return User(
        id = id,
        name = name,
        email = email,
        balance = balance,
        firebaseToken = firebaseToken,
        isVerified = verified,
        monthlyIncome = monthlyIncome,
        monthlyOutcome = monthlyOutcome
    )
}
