    package com.example.shalatku

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Add
    import androidx.compose.material.icons.filled.CheckCircle
    import androidx.compose.material.icons.filled.Home
    import androidx.compose.material3.Icon
    import androidx.compose.material3.NavigationBar
    import androidx.compose.material3.NavigationBarItem
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Modifier
    import com.example.shalatku.ui.theme.ShalatkuTheme
    import androidx.compose.ui.tooling.preview.Preview

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                ShalatkuTheme {
                    ShalatkuApp()
                }
            }
        }
    }

    @Composable
    fun ShalatkuApp(
        viewModel: SalatKuViewModel = viewModel()
    ) {
        var selected by remember { mutableStateOf(0) }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = selected == 0,
                        onClick = { selected = 0 },
                        icon = { Icon(Icons.Default.Home, contentDescription = null) },
                        label = { Text("Home") }
                    )

                    NavigationBarItem(
                        selected = selected == 1,
                        onClick = { selected = 1 },
                        icon = { Icon(Icons.Default.CheckCircle, contentDescription = null) },
                        label = { Text("Tracker") }
                    )

                    NavigationBarItem(
                        selected = selected == 2,
                        onClick = { selected = 2 },
                        icon = { Icon(Icons.Default.Add, contentDescription = null) },
                        label = { Text("Tasbih") }
                    )
                }
            }
        ) { innerPadding ->

            val contentModifier = Modifier.padding(innerPadding)

            when (selected) {

                0 -> HomeScreen(
                    prayers = samplePrayers,
                    selectedDay = viewModel.selectedDay,
                    onSelectDay = viewModel::selectDay,
                    modifier = Modifier.padding(innerPadding)
                )

                1 -> TrackerScreen(
                    prayers = samplePrayers,
                    donePrayers = viewModel.donePrayers,
                    onToggle = viewModel::togglePrayer,
                    onClear = viewModel::clearPrayers,
                    modifier = Modifier.padding(innerPadding)
                )

                2 -> TasbihScreen(
                    count = viewModel.tasbihCount,
                    onIncrement = viewModel::incrementTasbih,
                    onReset = viewModel::resetTasbih,
                    modifier = contentModifier,
                    rounds = viewModel.completedRounds,
                    onSetRoundSize = viewModel::setRoundSize
                )
            }
        }
    }

    @Preview
    @Composable
    fun TasbihScreenPreview() {
        TasbihScreen(count = 12, rounds = 2, onIncrement = {}, onReset = {}, onSetRoundSize = {})
    }