package com.example.mapa

import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PantallaCalendario()
        }
    }
}

@Composable
fun PantallaCalendario() {

    var fechaSeleccionada by remember {
        mutableStateOf("Ninguna fecha seleccionada")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Calendario Compose",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        AndroidView(

            factory = { context ->

                CalendarView(context).apply {

                    setOnDateChangeListener {
                            _,
                            year,
                            month,
                            dayOfMonth ->

                        fechaSeleccionada =
                            "$dayOfMonth/${month + 1}/$year"
                    }
                }
            }
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Fecha seleccionada:"
        )

        Text(
            text = fechaSeleccionada,
            style = MaterialTheme.typography.titleLarge
        )
    }
}