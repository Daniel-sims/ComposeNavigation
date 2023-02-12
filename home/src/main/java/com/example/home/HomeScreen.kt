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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.filterNotNull

@Composable
internal fun HomeScreenRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToDetailsWithNoArguments: () -> Unit,
    onNavigateToDetailsWithArgument: (
        stringArgument: String,
        intArgument: Int
    ) -> Unit
) {

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val currentNoArguments by rememberUpdatedState(onNavigateToDetailsWithNoArguments)
    val currentWithArguments by rememberUpdatedState(onNavigateToDetailsWithArgument)
    LaunchedEffect(viewModel, lifecycle) {
        snapshotFlow { viewModel.navigation }
            .filterNotNull()
            .flowWithLifecycle(lifecycle)
            .collect {
                viewModel.onUiEvent(HomeUiEvent.OnNavigationEventConsumed)
                when (it) {
                    HomeNavigationEvent.NavigateWithNoArguments -> currentNoArguments()
                    is HomeNavigationEvent.NavigateWithArguments -> currentWithArguments(
                        it.stringArgument,
                        it.intArgument
                    )
                }
            }
    }

    HomeScreen(
        onUiEvent = viewModel::onUiEvent
    )
}

@Composable
private fun HomeScreen(
    onUiEvent: (HomeUiEvent) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttonModifier = Modifier.fillMaxWidth()
        Button(
            modifier = buttonModifier,
            onClick = { onUiEvent(HomeUiEvent.OnNoArgumentsButtonPressed) }) {
            Text(text = "Navigate To Details without any arguments")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = buttonModifier,
            onClick = {
                onUiEvent(
                    HomeUiEvent.OnWithArgumentsButtonPressed(
                        stringArgument = "This is a string argument",
                        intArgument = (0..20).random()
                    )
                )
            }) {
            Text(text = "Navigate To Details with arguments")
        }
    }
}