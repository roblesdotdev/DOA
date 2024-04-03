package com.roblesdotdev.doa.habits.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeQuote(
    modifier: Modifier = Modifier,
    quote: String,
    author: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .clip(RoundedCornerShape(12.dp))
            .height(146.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(vertical = 26.dp, horizontal = 16.dp)
                .padding(end = 100.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = quote.uppercase(),
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            Text(
                text = "- ${author.uppercase()}",
                color = MaterialTheme.colorScheme.tertiary.copy(
                    alpha = .5f
                ),
                fontSize = 12.sp
            )
        }
    }

}