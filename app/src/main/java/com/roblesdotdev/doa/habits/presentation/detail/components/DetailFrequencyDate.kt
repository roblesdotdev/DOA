package com.roblesdotdev.doa.habits.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roblesdotdev.doa.core.presentation.DOACheckbox
import com.roblesdotdev.doa.ui.theme.DOATheme
import java.time.DayOfWeek

@Composable
fun DetailFrequencyDate(
    modifier: Modifier = Modifier,
    date: DayOfWeek,
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(vertical = 8.dp, horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = date.name.take(3),
            fontSize = 10.sp,
            color = MaterialTheme.colorScheme.tertiary.copy(alpha = .5f),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        DOACheckbox(
            isChecked = isChecked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.semantics { contentDescription = date.name })

    }
}

@Preview(showBackground = true)
@Composable
private fun DetailFrequencyDatePreview() {
    DOATheme {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            DetailFrequencyDate(date = DayOfWeek.FRIDAY, isChecked = true, onCheckedChange = {})
            DetailFrequencyDate(date = DayOfWeek.SATURDAY, isChecked = false, onCheckedChange = {})
        }
    }
}