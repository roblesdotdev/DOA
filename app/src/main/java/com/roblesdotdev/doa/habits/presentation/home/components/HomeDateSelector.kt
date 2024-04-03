package com.roblesdotdev.doa.habits.presentation.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.time.ZonedDateTime

@Composable
fun HomeDateSelector(
    modifier: Modifier = Modifier,
    date: ZonedDateTime = ZonedDateTime.now(),
    mainData: ZonedDateTime = ZonedDateTime.now(),
    onDateTimeClick: (ZonedDateTime) -> Unit,
    datesToShow: Int = 5,
) {
    Row {
        repeat(datesToShow) {
            val d = mainData.plusDays(it.toLong())
            HomeDateItem(date = d, isSelected = d.toLocalDate() == date.toLocalDate()) {
            }
        }
    }
}