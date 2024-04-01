package com.roblesdotdev.doa.authentication.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.onConsumedWindowInsetsChanged
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.roblesdotdev.doa.core.presentation.DOAButton
import com.roblesdotdev.doa.core.presentation.DOATextField

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 20.dp)
            .padding(bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Log in with Email",
            modifier = Modifier.padding(24.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.tertiary,
        )
        DOATextField(
            value = "",
            onValueChange = {},
            placeholder = "Email",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            leadingIcon = Icons.Outlined.Email,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
        )

        DOATextField(
            value = "",
            onValueChange = {},
            isPassword = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            leadingIcon = Icons.Outlined.Lock,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            )
        )

        DOAButton(text = "Login", onClick = {})

        TextButton(onClick = { }) {
            Text(
                text = "Forgot password?",
                color = MaterialTheme.colorScheme.tertiary,
                textDecoration = TextDecoration.Underline
            )
        }

        TextButton(onClick = {}) {
            Text(
                text = buildAnnotatedString {
                    append("Don't have an account?")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(" Sign up")
                    }
                }, color = MaterialTheme.colorScheme.tertiary,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}