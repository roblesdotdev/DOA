package com.roblesdotdev.doa.habits.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maxkeppeker.sheets.core.models.base.SheetState
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import com.roblesdotdev.doa.core.presentation.DOAButton
import com.roblesdotdev.doa.core.presentation.DOATextField
import com.roblesdotdev.doa.habits.presentation.detail.components.DetailFrequency
import com.roblesdotdev.doa.habits.presentation.detail.components.DetailReminder
import com.roblesdotdev.doa.ui.theme.DOATheme
import java.time.LocalTime

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onSave: () -> Unit = onBack,
) {
    val uiState = viewModel.uiState
    val clockState = rememberSheetState()

    DetailClock(state = clockState, defaultTime = uiState.reminder, onSelect = { hours, minutes ->
        viewModel.onEvent(DetailEvent.ReminderChange(LocalTime.of(hours, minutes)))
    })


    LaunchedEffect(key1 = uiState.isSaved) {
        if (uiState.isSaved) {
            onSave()
        }
    }

    Scaffold(
        topBar = { TopBar(onBack) },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            DOATextField(
                value = uiState.habitName,
                onValueChange = { viewModel.onEvent(DetailEvent.NameChange(it)) },
                placeholder = "Habit name",
                contentDescription = "Enter habit name",
                background = Color.White,
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {}
                )
            )
            DetailFrequency(selectedDays = uiState.frequency, onFrequencyChange = {
                viewModel.onEvent(DetailEvent.FrequencyChange(it))
            })
            DetailReminder(
                reminder = uiState.reminder,
                onTimeClick = {
                    clockState.show()
                },
            )
            Spacer(modifier = Modifier.weight(1f))
            DOAButton(
                text = "Save Habit",
                isLoading = uiState.isLoading,
                onClick = {
                    viewModel.onEvent(DetailEvent.HabitSave)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onBack: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(text = "New Habit", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
        modifier = Modifier.padding(horizontal = 16.dp),
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailClock(
    state: SheetState,
    defaultTime: LocalTime?,
    onSelect: (Int, Int) -> Unit
) {
    ClockDialog(
        state = state,
        selection = ClockSelection.HoursMinutes { hours, minutes ->
            onSelect(hours, minutes)
        },
        config = ClockConfig(
            defaultTime = defaultTime,
            is24HourFormat = true,
        )
    )

}


@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    DOATheme {
        DetailScreen(onBack = {})
    }
}