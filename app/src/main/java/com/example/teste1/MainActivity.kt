package com.example.teste1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teste1.ui.theme.Teste1Theme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Teste1Theme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF6C63FF),
                                    Color(0xFF4ECDC4)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Perfil()
                }
            }
        }
    }
}

@Composable
fun Perfil() {
    var status by remember { mutableStateOf("Online") }

    val statusColor by animateColorAsState(
        targetValue = if (status == "Online") Color(0xFF4CAF50) else Color(0xFF9E9E9E),
        animationSpec = tween(durationMillis = 300),
        label = "statusColor"
    )

    val cardBackgroundColor by animateColorAsState(
        targetValue = if (status == "Online") Color.White else Color(0xFFF5F5F5),
        animationSpec = tween(durationMillis = 300),
        label = "cardBackground"
    )

    Card(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(0.9f)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = Color.Black.copy(alpha = 0.1f),
                spotColor = Color.Black.copy(alpha = 0.1f)
            ),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar com indicador de status
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    Color(0xFF6C63FF).copy(alpha = 0.2f),
                                    Color(0xFF4ECDC4).copy(alpha = 0.1f)
                                )
                            ),
                            shape = CircleShape
                        )
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Foto de perfil",
                        modifier = Modifier.size(60.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF6C63FF))
                    )
                }

                // Indicador de status
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            color = statusColor,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                            .align(Alignment.Center)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(
                                    color = statusColor,
                                    shape = CircleShape
                                )
                                .align(Alignment.Center)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Nome do usuário
            Text(
                text = "USER TESTE",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF2C3E50),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Status
            Text(
                text = status,
                fontSize = 16.sp,
                color = statusColor,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botão de mudança de status
            Button(
                onClick = {
                    status = if (status == "Online") "Offline" else "Online"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (status == "Online") Color(0xFFFF6B6B) else Color(0xFF4CAF50)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 4.dp
                )
            ) {
                Text(
                    text = if (status == "Online") "Ficar Offline" else "Ficar Online",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Informação adicional
            Text(
                text = "Toque no botão para alterar seu status",
                fontSize = 12.sp,
                color = Color(0xFF7F8C8D),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilPreview() {
    Teste1Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF6C63FF),
                            Color(0xFF4ECDC4)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Perfil()
        }
    }
}