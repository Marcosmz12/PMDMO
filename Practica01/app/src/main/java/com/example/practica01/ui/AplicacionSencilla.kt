package com.example.practica01.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica01.ui.theme.Practica01Theme
import com.example.practica01.R

@Composable
fun AplicacionSencilla(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var estado by remember { mutableStateOf(context.getString(R.string.estado_inicial)) }
    var pulsarHabilitado by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        LazyRow {

            items(10) { index ->

                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 20.dp
                    ),
                    modifier = Modifier.padding(5.dp)

                ) {
                    Text(
                        text = stringResource(id = R.string.texto_tarjeta, index),
                        modifier = Modifier.padding(10.dp)
                    )
                }

            }
        }
        Text(estado,
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    pulsarHabilitado = !pulsarHabilitado
                    estado = context.getString(R.string.estado_pulsado)
                },
                enabled = !pulsarHabilitado,

                ) {
                Text(stringResource(id = R.string.boton_pulsar))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                pulsarHabilitado = !pulsarHabilitado
                estado = context.getString(R.string.estado_inicial)
            }, enabled = pulsarHabilitado)
            {
                Text(stringResource(id = R.string.boton_resetear))
            }
        }
    }
}

@Preview(
    name = "Modo Oscuro",
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun AplicacionSencillaPreviewOscuro() {
    Practica01Theme {
        AplicacionSencilla("Android")
    }
}


@Preview(showBackground = true)
@Composable
fun AplicacionSencillaPreview() {
    Practica01Theme {
        AplicacionSencilla("Android")
    }
}