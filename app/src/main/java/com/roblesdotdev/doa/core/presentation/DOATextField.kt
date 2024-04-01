package com.roblesdotdev.doa.core.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.doa.ui.theme.DOATheme

@Composable
fun DOATextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    contentDescription: String = "",
    errorMessage: String? = null,
    leadingIcon: ImageVector? = null,
    isPassword: Boolean = false,
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    var hidePassword by remember {
        mutableStateOf(true)
    }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .semantics { this.contentDescription = contentDescription },
            leadingIcon = if (leadingIcon == null) null else {
                {
                    Icon(imageVector = leadingIcon, contentDescription = null)
                }
            },
            enabled = isEnabled,
            isError = errorMessage != null,
            trailingIcon = {
                if (isPassword) {
                    TextButton(onClick = { hidePassword = !hidePassword }, enabled = isEnabled) {
                        Text(
                            text = if (hidePassword) "Show" else "Hide",
                            color = MaterialTheme.colorScheme.tertiary,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }
            },
            placeholder = { Text(text = placeholder) },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            visualTransformation = if (isPassword && hidePassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.primary,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                unfocusedLeadingIconColor = MaterialTheme.colorScheme.tertiary,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.tertiary.copy(alpha = .5f),
                focusedPlaceholderColor = MaterialTheme.colorScheme.tertiary.copy(alpha = .5f),
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Transparent,
            ),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
        )

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DOATextFieldPreview() {
    DOATheme {
        DOATextField(value = "demo@email", onValueChange = {}, leadingIcon = Icons.Outlined.Email)
    }
}

@Preview(showBackground = true)
@Composable
private fun DOATextFieldErrorPreview() {
    DOATheme {
        DOATextField(
            value = "demo@email",
            onValueChange = {},
            errorMessage = "Invalid email",
            leadingIcon = Icons.Outlined.Email
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DOATextFieldPasswordPreview() {
    DOATheme {
        DOATextField(
            value = "mypassword",
            onValueChange = {},
            leadingIcon = Icons.Outlined.Lock,
            placeholder = "Password",
            isPassword = true
        )
    }
}