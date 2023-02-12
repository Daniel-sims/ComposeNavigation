package com.example.featuretwo.argumentscreen

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import java.util.UUID

const val argumentsScreenNavigationRoute = "arguments_screen_navigation_route"

internal const val stringArgumentId = "stringArgumentId"
internal const val intArgumentId = "intArgumentId"

internal class DetailsWithArgumentArgs(
    val stringArgument: String,
    val integerArgument: Int
) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        stringArgument = Uri.decode(checkNotNull(savedStateHandle[stringArgumentId])),
        integerArgument = checkNotNull(savedStateHandle[intArgumentId])
    )
}

fun NavController.navigateToDetailsWithArgument(
    argumentString: String,
    argumentInt: Int
) {
    // We encode our string argument, as navigation is via URL and special characters will
    // mess with it
    this.navigate(
        argumentsScreenNavigationRoute +
                "?stringArgument=${Uri.encode(argumentString)}" +
                "&intArgument=${argumentInt}"
    )
}
