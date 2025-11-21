package com.example.proyectogeneral.datos

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extensión para crear DataStore
val Context.configDataStore by preferencesDataStore(name = "configuracion")

class ConfiguracionDataStore(private val context: Context) {

    companion object {
        val TIPO_ENTRADA_KEY = stringPreferencesKey("tipo_entrada")
        val RECIBIR_RECORDATORIOS_KEY = booleanPreferencesKey("recibir_recordatorios")
        val RESERVAR_ESTANCIA_KEY = booleanPreferencesKey("reservar_estancia")
        val CANTIDAD_ENTRADAS_KEY = intPreferencesKey("cantidad_entradas")
    }

    // Guardar configuración
    suspend fun guardarConfiguracion(
        tipoEntrada: String,
        recibirRecordatorios: Boolean,
        reservarEstancia: Boolean,
        cantidadEntradas: Int
    ) {
        context.configDataStore.edit { prefs ->
            prefs[TIPO_ENTRADA_KEY] = tipoEntrada
            prefs[RECIBIR_RECORDATORIOS_KEY] = recibirRecordatorios
            prefs[RESERVAR_ESTANCIA_KEY] = reservarEstancia
            prefs[CANTIDAD_ENTRADAS_KEY] = cantidadEntradas
        }
    }

    // Flows para consultar valores
    val tipoEntradaFlow: Flow<String> = context.configDataStore.data
        .map { prefs -> prefs[TIPO_ENTRADA_KEY] ?: "General" }

    val recibirRecordatoriosFlow: Flow<Boolean> = context.configDataStore.data
        .map { prefs -> prefs[RECIBIR_RECORDATORIOS_KEY] ?: false }

    val reservarEstanciaFlow: Flow<Boolean> = context.configDataStore.data
        .map { prefs -> prefs[RESERVAR_ESTANCIA_KEY] ?: false }

    val cantidadEntradasFlow: Flow<Int> = context.configDataStore.data
        .map { prefs -> prefs[CANTIDAD_ENTRADAS_KEY] ?: 1 }
}