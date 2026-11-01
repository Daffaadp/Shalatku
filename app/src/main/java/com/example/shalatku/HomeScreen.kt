package com.example.shalatku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    prayers: List<Prayer>,
    selectedDay: Int,
    onSelectDay: (Int) -> Unit,
    prayerTimes: PrayerTimesUiState,
    onRefreshPrayerTimes: () -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item {
            Text(
                text = "Shalatku",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        item {
            Text(
                text = "Today's Prayer Times",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        item {
            PrayerTimesSection(
                state = prayerTimes,
                onRefresh = onRefreshPrayerTimes
            )
        }

        items(prayers) { prayer ->
            PrayerCard(prayer)
        }
    }
}

@Composable
fun PrayerCard(prayer: Prayer) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = prayer.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = prayer.time,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        prayers = samplePrayers,
        selectedDay = 0,
        onSelectDay = {},

        prayerTimes = PrayerTimesUiState.Success(samplePrayers),
        onRefreshPrayerTimes = {}
    )
}
