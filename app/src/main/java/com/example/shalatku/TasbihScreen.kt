package com.example.shalatku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TasbihScreen(
    count: Int,
    rounds: Int,
    roundSize: Int,
    onIncrement: () -> Unit,
    onReset: () -> Unit,
    onSelectRoundSize: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Tasbih",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Pilih Target",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = { onSelectRoundSize(33) }
            ) {
                Text("33")
            }

            Button(
                onClick = { onSelectRoundSize(99) }
            ) {
                Text("99")
            }

            Button(
                onClick = { onSelectRoundSize(100) }
            ) {
                Text("100")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Target : $roundSize",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Rounds : $rounds",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "$count / $roundSize",
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onIncrement
        ) {
            Text("+1")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = onReset
        ) {
            Text("Reset")
        }
    }
}