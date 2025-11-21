package com.example.proyectogeneral.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectogeneral.R
import com.example.proyectogeneral.datos.ConfiguracionDataStore
import com.example.proyectogeneral.ui.theme.ProyectoGeneralTheme
import kotlinx.coroutines.launch


@Composable
fun Configuracion() {

    val context = LocalContext.current
    val dataStore = remember { ConfiguracionDataStore(context) }
    val scope = rememberCoroutineScope()

    val tipos = listOf("General", "VIP", "Backstage")
    var tipoEntrada by remember { mutableStateOf(tipos.first()) }

    var recibirRecordatorios by remember { mutableStateOf(false) }

    var reservarEstancia by remember { mutableStateOf(false) }

    val cantidades = (1..10).toList()
    var cantidadSeleccionada by remember { mutableStateOf(1) }

    // Recuperar datos guardados
    LaunchedEffect(Unit) {
        launch {
            dataStore.tipoEntradaFlow.collect { tipoEntrada = it }
        }
        launch {
            dataStore.recibirRecordatoriosFlow.collect { recibirRecordatorios = it }
        }
        launch {
            dataStore.reservarEstanciaFlow.collect { reservarEstancia = it }
        }
        launch {
            dataStore.cantidadEntradasFlow.collect { cantidadSeleccionada = it }
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(16.dp)
    ) {

        // Radiobuttons
        TipoEntrada(
            tipos = tipos,
            seleccionado = tipoEntrada,
            onSeleccionChange = { tipoEntrada = it }
        )

        // Checkbox
        Recordatorios(
            recibirRecordatorios = recibirRecordatorios,
            onRecordatoriosChange = { recibirRecordatorios = it }
        )

        // Switch
        ReservarEstancia(
            reservarEstancia = reservarEstancia,
            onReservarEstanciaChange = { reservarEstancia = it }
        )

        // DropdownMenu
        CantidadEntradas(
            cantidades = cantidades,
            cantidadSeleccionada = cantidadSeleccionada,
            onCantidadChange = { cantidadSeleccionada = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                scope.launch {
                    dataStore.guardarConfiguracion(
                        tipoEntrada,
                        recibirRecordatorios,
                        reservarEstancia,
                        cantidadSeleccionada
                    )
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Guardar Configuración")
        }
    }
}


@Composable
fun TipoEntrada(
    tipos: List<String>,
    seleccionado: String,
    onSeleccionChange: (String) -> Unit
) {
    tipos.forEach { tipo ->
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = seleccionado == tipo,
                onClick = { onSeleccionChange(tipo) }
            )
            Text(tipo)
        }
    }
}

@Composable
fun Recordatorios(
    recibirRecordatorios: Boolean,
    onRecordatoriosChange: (Boolean) -> Unit
) {
    Row {
        Checkbox(
            checked = recibirRecordatorios,
            onCheckedChange = onRecordatoriosChange
        )
        Text(stringResource(R.string.recibir))
    }
}

@Composable
fun ReservarEstancia(
    reservarEstancia: Boolean,
    onReservarEstanciaChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(R.string.reservar_estancia),
            modifier = Modifier.weight(1f)
        )

        Switch(
            checked = reservarEstancia,
            onCheckedChange = onReservarEstanciaChange
        )
    }
}

@Composable
fun CantidadEntradas(
    cantidades: List<Int>,
    cantidadSeleccionada: Int,
    onCantidadChange: (Int) -> Unit
) {
    var expandir by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expandir = true }) {
            Text(cantidadSeleccionada.toString())
        }

        DropdownMenu(
            expanded = expandir,
            onDismissRequest = { expandir = false }
        ) {
            cantidades.forEach { cantidad ->
                DropdownMenuItem(
                    text = { Text(cantidad.toString()) },
                    onClick = {
                        onCantidadChange(cantidad)
                        expandir = false
                    }
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun ConfiguracionPreview() {
    ProyectoGeneralTheme {
        Configuracion()
    }
}