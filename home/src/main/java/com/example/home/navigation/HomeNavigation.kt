package com.example.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.home.HomeScreenRoute
import com.example.home.homeScreenNavigationRoute
import com.google.accompanist.navigation.animation.composable
import java.util.UUID

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeNavigation(
    onNavigateToDetailsWithNoArguments: () -> Unit,
    onNavigateToDetailsWithArgument: (
        stringArgument: String,
        intArgument: Int
    ) -> Unit
) {
    composable(route = homeScreenNavigationRoute) {
        HomeScreenRoute(
            onNavigateToDetailsWithNoArguments = onNavigateToDetailsWithNoArguments,
            onNavigateToDetailsWithArgument = onNavigateToDetailsWithArgument
        )
    }
}