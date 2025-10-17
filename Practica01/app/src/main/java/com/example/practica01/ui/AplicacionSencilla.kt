package com.example.practica01.ui

import android.R.id.message
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica01.ui.theme.Practica01Theme

@Composable
fun AplicacionSencilla(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // vertical centrar
        horizontalAlignment = Alignment.CenterHorizontally // horizontal centrar

    ) {
        LazyRow {

            items(10) { index ->

                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 20.dp
                    ),
                    modifier = Modifier.padding(5.dp),
                ) {
                    Text(
                        text = "This is inside a Card #$index",
                        modifier = Modifier.padding(10.dp)
                    )
                }

            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()

        ) {
            Button(onClick = {}) { }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {}) { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AplicacionSencillaPreview() {
    Practica01Theme {
        AplicacionSencilla("Android")
    }
}