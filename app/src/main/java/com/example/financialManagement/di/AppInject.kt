package com.example.financialManagement.di

import android.app.Application
import com.example.financialManagement.data.local.PreferencesManager
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppInject {

    @Provides
    @Singleton
    fun providePreferencesManager(application: Application): PreferencesManager {
        return PreferencesManager(application)
    }
}
