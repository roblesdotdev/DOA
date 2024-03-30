package com.roblesdotdev.doa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.roblesdotdev.doa.ui.theme.DOATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DOATheme {
                Text(text = "DOA")
            }
        }
    }
}