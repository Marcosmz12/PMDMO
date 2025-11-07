package com.example.proyectogeneral.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectogeneral.R
import com.example.proyectogeneral.ui.theme.ProyectoGeneralTheme

@Composable
fun Inicio(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.spacedBy(50.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
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

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Weekend Beach Festival",
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(10.dp))


    }
    EstablecerBotones(
        context,
    )
}

@Composable
fun EstablecerBotones(
    context: Context,
) {
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
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onTertiaryContainer
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .height(50.dp)
                .width(180.dp)
        ) {
            Text(
                stringResource(R.string.historia),
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onTertiaryContainer
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .height(50.dp)
                .width(180.dp),
        ) {
            Text(
                stringResource(R.string.acercade),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun InicioPreview() {
    ProyectoGeneralTheme {
        Inicio("Android")
    }
}