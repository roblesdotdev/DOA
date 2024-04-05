package com.roblesdotdev.doa.habits.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.doa.ui.theme.DOATheme
import java.time.DayOfWeek

@Composable
fun DetailFrequency(
    modifier: Modifier = Modifier,
    selectedDays: List<DayOfWeek>,
    onFrequencyChange: (DayOfWeek) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        Text(
            text = "Frequency",
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.tertiary
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            val days = DayOfWeek.entries.toTypedArray()
            days.forEach { dayOfWeek ->
                DetailFrequencyDate(
                    date = dayOfWeek,
                    isChecked = selectedDays.contains(dayOfWeek),
                    onCheckedChange = {
                        onFrequencyChange(dayOfWeek)
                    })
            }
        }
    }
}

@Preview
@Composable
private fun DetailFrequencyPreview() {
    DOATheme {
        DetailFrequency(selectedDays = listOf(
            DayOfWeek.SATURDAY,
            DayOfWeek.THURSDAY,
        ), onFrequencyChange = {})
    }
}