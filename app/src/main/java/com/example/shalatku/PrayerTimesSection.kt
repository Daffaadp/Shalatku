package com.example.shalatku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PrayerTimesSection(
    state: PrayerTimesUiState,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            when (state) {

                PrayerTimesUiState.Loading -> {

                    CircularProgressIndicator()

                    Text("Loading prayer times...")
                }

                is PrayerTimesUiState.Success -> {

                    Text(
                        "Prayer Times",
                        style = MaterialTheme.typography.titleMedium
                    )

                    state.times.forEach {

                        Text("${it.name} : ${it.time}")

                    }

                    Button(onClick = onRefresh) {

                        Text("Refresh")

                    }
                }

                is PrayerTimesUiState.Error -> {

                    Text(
                        state.message,
                        color = MaterialTheme.colorScheme.error
                    )

                    Button(onClick = onRefresh) {

                        Text("Retry")

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrayerTimesLoadingPreview() {

    PrayerTimesSection(
        state = PrayerTimesUiState.Loading,
        onRefresh = {}
    )

}

@Preview(showBackground = true)
@Composable
fun PrayerTimesSuccessPreview() {

    PrayerTimesSection(
        state = PrayerTimesUiState.Success(samplePrayers),
        onRefresh = {}
    )

}

@Preview(showBackground = true)
@Composable
fun PrayerTimesErrorPreview() {

    PrayerTimesSection(
        state = PrayerTimesUiState.Error("Network Error"),
        onRefresh = {}
    )

}