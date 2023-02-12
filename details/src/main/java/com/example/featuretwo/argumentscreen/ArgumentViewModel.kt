package com.example.featuretwo.argumentscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class ArgumentViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val args: DetailsWithArgumentArgs = DetailsWithArgumentArgs(savedStateHandle)

    val uiState = WithArgumentsUiState(
        stringArgument = args.stringArgument,
        intArgument = args.integerArgument
    )
}

data class WithArgumentsUiState(
    val stringArgument: String = "",
    val intArgument: Int = 0
)