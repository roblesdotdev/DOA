package com.roblesdotdev.doa.authentication.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.doa.R
import com.roblesdotdev.doa.authentication.presentation.signup.components.SignupForm
import com.roblesdotdev.doa.ui.theme.DOATheme

@Composable
fun SignupScreen(
    onLogin: () -> Unit,
    onSignIn: () -> Unit,
    viewModel: SignupViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = viewModel.uiState.isSignedIn) {
        if (viewModel.uiState.isSignedIn) {
            onSignIn()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
        SignupForm(
            uiState = viewModel.uiState,
            onLogin = onLogin,
            onEvent = viewModel::onEvent,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupScreenPreview() {
    DOATheme {
        SignupScreen(onLogin = {}, onSignIn = {})
    }
}