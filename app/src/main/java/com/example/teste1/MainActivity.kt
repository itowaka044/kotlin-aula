package com.example.teste1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teste1.ui.theme.Teste1Theme


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Teste1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Perfil()
                }
            }
        }
    }
}

@Composable
fun Perfil(){

    var status by remember { mutableStateOf("Online") }

    val statusColor = if (status == "Online") Color.Green else Color.Gray

    Row(
        modifier = Modifier
            .padding(16.dp)
            .border(2.dp, Color.Gray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = Icons.Default.Person,
            contentDescription = "foto de perfil"
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        Column(){
            Text(
                text = "Maria da Silva",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = status,
                color = statusColor
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Button(onClick = {
                status = if (status == "Online") {
                    "Offline"
                } else {
                    "Online"
                }
            }) {
                Text("Mudar Status")
            }
        }
    }
}