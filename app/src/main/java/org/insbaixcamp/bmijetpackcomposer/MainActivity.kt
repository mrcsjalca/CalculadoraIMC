package org.insbaixcamp.bmijetpackcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.bmijetpackcomposer.ui.theme.BMIJetPackComposerTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SliderDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.bmijetpackcomposer.ui.theme.BMIStyles

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BMIJetPackComposerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    BMIScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BMIScreen(modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("Marcos") }
    var pes by remember { mutableStateOf(70) }
    var alçada by remember { mutableStateOf(170f) }
    var bmi by remember { mutableStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BMIStyles.Background)
            .padding(BMIStyles.ScreenPadding),
        verticalArrangement = Arrangement.spacedBy(BMIStyles.Spacing),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "BMI Calculadora",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = BMIStyles.TextDark
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = BMIStyles.CardShape,
            colors = CardDefaults.cardColors(containerColor = BMIStyles.CardBackground),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(BMIStyles.Spacing),
                verticalArrangement = Arrangement.spacedBy(BMIStyles.Spacing)
            ) {

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    shape = BMIStyles.ButtonShape,
                    modifier = Modifier.fillMaxWidth()
                )

                Text("Pes: $pes kg", color = BMIStyles.TextDark)
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(
                        onClick = { pes += 1 },
                        shape = BMIStyles.ButtonShape,
                        colors = ButtonDefaults.buttonColors(containerColor = BMIStyles.Primary)
                    ) { Text("+") }

                    Button(
                        onClick = { pes -= 1 },
                        shape = BMIStyles.ButtonShape,
                        colors = ButtonDefaults.buttonColors(containerColor = BMIStyles.Primary)
                    ) { Text("-") }
                }

                Text("Alçada: ${alçada.toInt()} cm", color = BMIStyles.TextDark)
                Slider(
                    value = alçada,
                    onValueChange = { alçada = it },
                    valueRange = 100f..250f,
                    colors = SliderDefaults.colors(
                        thumbColor = BMIStyles.Primary,
                        activeTrackColor = BMIStyles.Primary
                    )
                )
            }
        }

        Button(
            onClick = {
                val alçadaMetres = alçada / 100
                bmi = pes / (alçadaMetres * alçadaMetres)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = BMIStyles.ButtonShape,
            colors = ButtonDefaults.buttonColors(containerColor = BMIStyles.Primary)
        ) {
            Text("Calcular", fontSize = 18.sp)
        }

        Text(
            text = "Tu BMI es ${"%.1f".format(bmi)}",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = BMIStyles.TextDark
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BMIScreenPreview() {
    BMIJetPackComposerTheme {
        BMIScreen()
    }
}