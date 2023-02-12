package com.example.featuretwo.noargumentscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun NoArgumentScreenRoute(
    viewModel: NoArgumentViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    NoArgumentScreen(
        onBackPressed = onBackPressed
    )
}

@Composable
private fun NoArgumentScreen(
    onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is a details screen with no arguments.")
        Button(onClick = { onBackPressed() }) {
            Text(text = "Go Back")
        }
    }
}