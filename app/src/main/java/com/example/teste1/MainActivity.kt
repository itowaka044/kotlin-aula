package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.os.Bundle
import android.view.Surface
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.myapplication.ui.theme.MyApplicationTheme



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var tasks = remember { mutableStateListOf("") }

            Column(
                modifier = Modifier
                    .size(height = 1000.dp, width = 500.dp)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CardProfile("jeferso")
                }

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    TextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .size(width = 300.dp, height = 50.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .width(10.dp)
                    )

                    Button(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "criar tarefa",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "TAREFAS:"

                )
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )

                Column(
                    modifier = Modifier
                        .size(height = 500.dp, width = 500.dp)

                ){
                    if(tasks[1] != ""){
                        for(i in 1 .. tasks.size){

                            CheckboxCard("")

                            Spacer(
                                modifier = Modifier
                                    .height(10.dp)
                            )
                        }
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )


            }
        }
    }
}

@Composable
fun CreateTask() {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .size(width = 300.dp, height = 50.dp)
    )
}

@Composable
fun CardProfile(userName: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 500.dp,
                height = 100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(20.dp)
        ){

            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "pessoa",
                modifier = Modifier
                    .size(80.dp)

            )


            Spacer(
                modifier = Modifier
                    .width(20.dp)
            )

            Column {
                Text(
                    text = userName,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight(500)
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "$userName kkkkkk é foda"
                )
            }

        }
    }
}


@Composable
fun CheckboxCard(taskName: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 500.dp,
                height = 40.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)

        ){
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "pessoa"
            )

            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )

            Text(
                text = taskName
            )
        }
    }
}

@Preview
@Composable
fun Calculadora(){

    var result by remember { mutableStateOf(0) }
    var input1 by remember { mutableStateOf(0) }
    var input2 by remember { mutableStateOf(0)}
    var aux by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .border(2.dp, Color.Black)
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {

                Row {
                    Text(
                        text = "Resultado"
                    )
                }

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Row {
                    Text(
                        text = result.toString()
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 1
                        result = 1
                    } else {
                        input2 = 1
                        result = 1
                    }
                }) {
                Text("1")
            }

            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 2
                        result = 2
                    } else {
                        input2 = 2
                        result = 2
                    }
                }) {
                Text("2")
            }

            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 3
                        result = 3
                    } else {
                        input2 = 3
                        result = 3
                    }
                }) {
                Text("3")
            }

            Spacer(
                modifier = Modifier.width(4.dp)
            )

            Button(onClick = {
                aux = 1
            }) {
                Text("+")
            }
        }

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 4
                        result = 4
                    } else {
                        input2 = 4
                        result = 4
                    }
                }) {
                Text("4")
            }

            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 5
                        result = 5
                    } else {
                        input2 = 5
                        result = 5
                    }
                }) {
                Text("5")
            }

            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 6
                        result = 6
                    } else {
                        input2 = 6
                        result = 6
                    }
                }) {
                Text("6")
            }

            Spacer(
                modifier = Modifier.width(4.dp)
            )

            Button(onClick = {
                aux = 2
            }) {
                Text("-")
            }
        }

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 7
                        result = 7
                    } else {
                        input2 = 7
                        result = 7
                    }
                }) {
                Text("7")
            }

            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 8
                        result = 8
                    } else {
                        input2 = 8
                        result = 8
                    }
                }) {
                Text("8")
            }

            Button(
                onClick = {
                    if(input1 == 0){
                        input1 = 9
                        result = 9
                    } else {
                        input2 = 9
                        result = 9
                    }
                }) {
                Text("9")
            }

            Spacer(
                modifier = Modifier.width(4.dp)
            )

            Button(onClick = {
                if(aux == 1){
                    result = input1 + input2
                }
                if(aux == 2){
                    result = input1 - input2
                }
            }) {
                Text("=")
            }
        }
    }
}
