package com.roblesdotdev.doa.habits.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.doa.habits.presentation.home.components.HomeDateSelector
import com.roblesdotdev.doa.habits.presentation.home.components.HomeListItem
import com.roblesdotdev.doa.habits.presentation.home.components.HomeQuote

@Composable
fun HomeScreen(
    onCreateAction: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState
    Scaffold(
        topBar = { TopAppBar() },
        floatingActionButton = { FloatingButton(onClick = onCreateAction) },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            item {
                HomeQuote(
                    quote = "We first make our habits, and then our habits makes us.",
                    author = "Anonymous",
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Habits".uppercase(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.tertiary,
                    )
                    HomeDateSelector(
                        selectedDate = uiState.selectedDate,
                        mainData = uiState.currentDate,
                        onDateTimeClick = { viewModel.onEvent(HomeEvent.ChangeDate(it)) }
                    )
                }
            }

            items(uiState.habits) { habit ->
                HomeListItem(
                    habit = habit,
                    onCheckedChange = { viewModel.onEvent(HomeEvent.CompleteHabit(habit)) },
                    selectedDate = uiState.selectedDate.toLocalDate(),
                    onHabitClick = {})
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Habits", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    )
}

@Composable
fun FloatingButton(
    onClick: () -> Unit,
) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primary,
        shape = CircleShape,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add a new habit",
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
}