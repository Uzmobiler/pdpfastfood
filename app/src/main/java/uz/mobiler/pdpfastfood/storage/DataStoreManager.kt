package uz.mobiler.pdpfastfood.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore("settings")

@Singleton
class DataStoreManager @Inject constructor(val context: Context) {

    private val dataStore = context.dataStore

    private object PreferencesKeys {
        val ACCESS_TOKEN = stringPreferencesKey("pref_dark_theme")
    }

    suspend fun setAccessToken(accessToken: String) {
        dataStore.setValue(PreferencesKeys.ACCESS_TOKEN, accessToken)
    }

    val getAccessToken: Flow<String>
        get() = dataStore.getValueAsFlow(PreferencesKeys.ACCESS_TOKEN, "")


    suspend fun clearPreferenceStorage() {
        dataStore.edit {
            it.clear()
        }
    }

    private fun <T> DataStore<Preferences>.getValueAsFlow(
        key: Preferences.Key<T>,
        defaultValue: T
    ): Flow<T> {
        return dataStore.data.catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                // we try again to store the value in the map operator
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            // return the default value if it doesn't exist in the storage
            preferences[key] ?: defaultValue
        }
    }

    private suspend fun <T> DataStore<Preferences>.setValue(
        key: Preferences.Key<T>,
        value: T
    ) {
        this.edit { preferences ->
            // save the value in prefs
            preferences[key] = value
        }
    }
}