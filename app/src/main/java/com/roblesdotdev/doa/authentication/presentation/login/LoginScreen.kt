package com.roblesdotdev.doa.authentication.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.doa.R
import com.roblesdotdev.doa.authentication.presentation.login.components.LoginForm
import com.roblesdotdev.doa.core.presentation.DOATitle

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.loginbg),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .aspectRatio(1f)
                .graphicsLayer(
                    scaleX = 1.2f,
                    scaleY = 1.2f,
                )
        )
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.background,
                        )
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier)
            Spacer(modifier = Modifier)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DOATitle(text = "Welcome to")
                DOATitle(text = "Monumental Habits")
            }
            LoginForm(uiState = viewModel.uiState, onEvent = { viewModel.onEvent(it) })
        }
    }
}