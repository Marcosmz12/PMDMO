package com.example.proyectogeneral.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectogeneral.R
import com.example.proyectogeneral.ui.theme.ProyectoGeneralTheme

@Composable
fun Historia(navigationController: NavHostController){
    val context = LocalContext.current.applicationContext
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(MaterialTheme.colorScheme.primary)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = stringResource(R.string.fondo),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Hola"
        )

    }
}
@Preview(showBackground = true)
@Composable
fun HistoriaPreview() {
    ProyectoGeneralTheme {
        val navController = rememberNavController()
        Historia(navigationController = navController)
    }
}