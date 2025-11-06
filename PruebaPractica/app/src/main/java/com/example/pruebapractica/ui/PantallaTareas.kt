package com.example.pruebapractica.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebapractica.R
import com.example.pruebapractica.ui.theme.PruebaPracticaTheme

@Composable
fun PantallaTareas(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var marcado1 by remember { mutableStateOf(false) }
    var titulo by remember { mutableStateOf(context.getString(R.string.titulo)) }
    val tareas = listOf(
        context.getString(R.string.tarea1),
        context.getString(R.string.tarea2),
        context.getString(R.string.tarea3),
        context.getString(R.string.tarea4)
    )

    val estadosTareas = remember { mutableStateListOf(false, false, false, false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.titulo),
            style = MaterialTheme.typography.displayLarge
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            items(tareas.indices.toList()) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    shape = RoundedCornerShape(8.dp),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 20.dp
                    ),
                ) {
                    Row (modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = estadosTareas[index],
                            onCheckedChange = { estadosTareas[index] = it }
                        )
                        Text(
                            text = tareas[index],
                            modifier = Modifier.padding(start = 8.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PantallaTareasPreview() {
    PruebaPracticaTheme {
        PantallaTareas("Android")
    }
}