package com.example.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor() : ViewModel() {

    var navigation by mutableStateOf<HomeNavigationEvent?>(null)
        private set

    fun onUiEvent(uiEvent: HomeUiEvent) {
        when (uiEvent) {
            HomeUiEvent.OnNoArgumentsButtonPressed -> {
                navigation = HomeNavigationEvent.NavigateWithNoArguments
            }

            is HomeUiEvent.OnWithArgumentsButtonPressed -> {
                navigation = HomeNavigationEvent.NavigateWithArguments(
                    stringArgument = uiEvent.stringArgument,
                    intArgument = uiEvent.intArgument
                )
            }

            HomeUiEvent.OnNavigationEventConsumed -> navigation = null
        }
    }
}

sealed interface HomeUiEvent {
    data class OnWithArgumentsButtonPressed(
        val stringArgument: String,
        val intArgument: Int
    ) : HomeUiEvent

    object OnNoArgumentsButtonPressed : HomeUiEvent
    object OnNavigationEventConsumed : HomeUiEvent
}

sealed interface HomeNavigationEvent {
    object NavigateWithNoArguments : HomeNavigationEvent
    data class NavigateWithArguments(
        val stringArgument: String,
        val intArgument: Int
    ) : HomeNavigationEvent
}