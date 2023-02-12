package com.example.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
internal fun HomeScreenRoute(
    onNavigateToDetailsWithNoArguments: () -> Unit,
    onNavigateToDetailsWithArgument: (
        stringArgument: String,
        intArgument: Int
    ) -> Unit
) {
    HomeScreen(
        onNavigateToDetailsWithNoArguments = onNavigateToDetailsWithNoArguments,
        onNavigateToDetailsWithArgument = onNavigateToDetailsWithArgument
    )
}

@Composable
private fun HomeScreen(
    onNavigateToDetailsWithNoArguments: () -> Unit,
    onNavigateToDetailsWithArgument: (
        stringArgument: String,
        intArgument: Int
    ) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttonModifier = Modifier.fillMaxWidth()
        Button(
            modifier = buttonModifier,
            onClick = { onNavigateToDetailsWithNoArguments() }) {
            Text(text = "Navigate To Details without any arguments")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = buttonModifier,
            onClick = {
                onNavigateToDetailsWithArgument(
                    "This is an argument!",
                    (0..100).random()
                )
            }) {
            Text(text = "Navigate To Details with arguments")
        }
    }
}