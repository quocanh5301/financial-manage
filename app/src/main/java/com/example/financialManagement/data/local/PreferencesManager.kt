package com.example.financialManagement.data.local

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.example.financialManagement.domain.model.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.google.gson.Gson

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class PreferencesManager(context: Context) {
    private val dataStore = context.dataStore

    companion object {
        val USER_KEY = stringPreferencesKey("username")
    }

    val userFlow: Flow<User> = dataStore.data.map { preferences ->
        preferences[USER_KEY].let { json ->
            Gson().fromJson(json, User::class.java)
        }
    }

    suspend fun saveUser(user: User) {
        dataStore.edit { preferences ->
            preferences[USER_KEY] = Gson().toJson(user)

        }
    }

    // Read preferences as Flow
//    val darkModeFlow: Flow<Boolean> = dataStore.data.map { preferences ->
//        preferences[DARK_MODE_KEY] ?: false
//    }

//    suspend fun saveUsername(username: String) {
//        dataStore.edit { preferences ->
//            preferences[USERNAME_KEY] = username
//        }
//    }
}
