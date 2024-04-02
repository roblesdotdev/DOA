package com.roblesdotdev.doa.authentication.presentation.signup.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.roblesdotdev.doa.authentication.presentation.signup.SignupEvent
import com.roblesdotdev.doa.authentication.presentation.signup.SignupUIState
import com.roblesdotdev.doa.core.presentation.DOAButton
import com.roblesdotdev.doa.core.presentation.DOATextField
import com.roblesdotdev.doa.core.presentation.DOATitle

@Composable
fun SignupForm(
    modifier: Modifier = Modifier,
    onLogin: () -> Unit,
    uiState: SignupUIState,
    onEvent: (SignupEvent) -> Unit,
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        DOATitle(text = "Create your account")
        Spacer(modifier = Modifier.height(32.dp))
        DOATextField(
            value = uiState.email,
            onValueChange = { onEvent(SignupEvent.EmailChange(it)) },
            contentDescription = "Enter your email",
            background = Color.White,
            placeholder = "Email",
            errorMessage = uiState.emailError,
            isEnabled = !uiState.isLoading,
            leadingIcon = Icons.Outlined.Email,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
            )
        )
        DOATextField(
            value = uiState.password,
            onValueChange = { onEvent(SignupEvent.PasswordChange(it)) },
            contentDescription = "Enter your password",
            background = Color.White,
            placeholder = "Password",
            errorMessage = uiState.passwordError,
            isEnabled = !uiState.isLoading,
            isPassword = true,
            leadingIcon = Icons.Outlined.Lock,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
            ),
            keyboardActions = KeyboardActions(onDone = {

            })
        )
        Spacer(modifier = Modifier.height(16.dp))
        DOAButton(
            text = "Create Account",
            onClick = { onEvent(SignupEvent.Signup) },
            isLoading = uiState.isLoading
        )
        TextButton(onClick = onLogin, enabled = !uiState.isLoading) {
            Text(text = buildAnnotatedString {
                append("Already have an account?")
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(" Sign In")
                }
            }, color = MaterialTheme.colorScheme.tertiary)
        }
    }
}