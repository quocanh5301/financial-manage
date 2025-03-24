package com.example.financialManagement.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.financialManagement.data.local.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    val preferencesManager: PreferencesManager
) : ViewModel()
