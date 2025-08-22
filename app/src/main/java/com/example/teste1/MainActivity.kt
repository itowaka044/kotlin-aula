package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.os.Bundle
import android.view.Surface
import android.widget.Button
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
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
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.myapplication.ui.theme.MyApplicationTheme



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Button(
                                onClick = {}
                            ){
                                Icon(
                                    imageVector = Icons.Filled.Home,
                                    contentDescription = "home",
                                )
                            }

                            Button(
                                onClick = {}
                            ){
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = "favorite",
                                )
                            }

                            Button(
                                onClick = {}
                            ){
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "profile",
                                )
                            }

                        }
                    }
                },
            ) {

                var chords = remember { mutableStateListOf("creep", "jigsaw falling into place", "patience") }
                var genres = remember { mutableStateListOf("sla", "pop", "jazz", "folk") }

                Column(
                    modifier = Modifier
                        .size(width = 500.dp, height = 1000.dp)
                        .padding(vertical = 30.dp, horizontal = 20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        CardTop()
                    }

                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        MusicGenre(genres)
                    }

                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        ImageBanner()
                    }

                    Spacer(
                        modifier = Modifier
                            .height(15.dp)
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Top cifras",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        modifier = Modifier
                            .size(width = 500.dp, height = 1000.dp)
                            .padding(vertical = 30.dp, horizontal = 10.dp)
                    ) {

                        for (i in 0..chords.size - 1) {

                            var number = i + 1

                            Row { CardChords("$number", chords[i]) }

                            Spacer(
                                modifier = Modifier
                                    .height(3.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardTop(){

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 500.dp,
                height = 100.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            ) {

            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "logo",
                modifier = Modifier
                    .size(width = 80.dp, height = 40.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = {}
                ){
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "search",
                    )
                }

                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(width = 80.dp, height = 40.dp)
                )
            }
        }
    }
}

@Composable
fun MusicGenre(genres: SnapshotStateList<String>){

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 500.dp,
                height = 60.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

            ) {

            for(i in 0 .. genres.size - 1){
                Button(
                    onClick = {},
                    modifier = Modifier
                        .size(width = 84.dp, height = 50.dp)
                ) {
                    Text(
                        text = genres[i],
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ImageBanner(){
    Card(
        modifier = Modifier
            .size(width = 500.dp, height = 200.dp),
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = stringResource(id = R.string.app_name)
        )
    }
}

@Composable
fun CardChords(i:String, chordName:String){

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 500.dp,
                height = 100.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 25.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "logo",
                modifier = Modifier
                    .size(width = 80.dp, height = 40.dp)
            )

            Spacer(
                modifier = Modifier
                    .width(30.dp)
            )

            Text(
                text = i,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier
                    .width(20.dp)
            )

            Text(
                text = chordName,
                fontSize = 18.sp,
            )
        }
    }
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
