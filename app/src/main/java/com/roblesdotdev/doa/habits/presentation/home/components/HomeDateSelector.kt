package com.roblesdotdev.doa.habits.presentation.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.time.ZonedDateTime

@Composable
fun HomeDateSelector(
    modifier: Modifier = Modifier,
    selectedDate: ZonedDateTime = ZonedDateTime.now(),
    mainData: ZonedDateTime = ZonedDateTime.now(),
    onDateTimeClick: (ZonedDateTime) -> Unit,
    datesToShow: Int = 5,
) {
    Row(modifier = modifier) {
        repeat(datesToShow) {
            val date = mainData.plusDays(it.toLong())
            HomeDateItem(date = date, isSelected = date.toLocalDate() == selectedDate.toLocalDate()) {
                onDateTimeClick(date)
            }
        }
    }
}