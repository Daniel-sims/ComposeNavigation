package com.example.featuretwo.argumentscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun ArgumentScreenRoute(
    viewModel: ArgumentViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    ArgumentScreen(
        state = viewModel.uiState,
        onBackPressed = onBackPressed
    )
}

@Composable
private fun ArgumentScreen(
    state: WithArgumentsUiState,
    onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This is a details screen with arguments.\n\n" +
                    "String Argument: ${state.stringArgument}\n\n" +
                    "Int Argument: ${state.intArgument}"
        )
        Button(onClick = { onBackPressed() }) {
            Text(text = "Go Back")
        }
    }
}