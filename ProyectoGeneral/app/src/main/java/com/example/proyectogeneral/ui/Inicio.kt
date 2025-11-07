package com.example.proyectogeneral.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectogeneral.ui.theme.ProyectoGeneralTheme
import androidx.compose.ui.Alignment

@Composable
fun Inicio(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ReggaetonBeachFestival"
        )

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {

            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .height(56.dp)
                .width(135.dp),
        ) {
            Text(
                text = "Historia"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun InicioPreview() {
    ProyectoGeneralTheme {
        Inicio("Android")
    }
}