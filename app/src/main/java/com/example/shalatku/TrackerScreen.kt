package com.example.shalatku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrackerScreen(
    prayers: List<Prayer>,
    donePrayers: List<String>,
    doneCount: Int,
    onToggle: (String) -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "$doneCount of ${prayers.size} prayers done today",
            style = MaterialTheme.typography.titleMedium
        )

        Button(
            onClick = onClear,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Clear All")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(prayers) { prayer ->

                Row {

                    Checkbox(
                        checked = prayer.name in donePrayers,
                        onCheckedChange = {
                            onToggle(prayer.name)
                        }
                    )

                    Text(
                        prayer.name,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}