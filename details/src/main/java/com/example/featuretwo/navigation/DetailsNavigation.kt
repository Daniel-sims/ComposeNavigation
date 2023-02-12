package com.example.featuretwo.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.featuretwo.argumentscreen.ArgumentScreenRoute
import com.example.featuretwo.argumentscreen.argumentsScreenNavigationRoute
import com.example.featuretwo.argumentscreen.intArgumentId
import com.example.featuretwo.argumentscreen.stringArgumentId
import com.example.featuretwo.argumentscreen.uuidArgumentId
import com.example.featuretwo.noargumentscreen.NoArgumentScreenRoute
import com.example.featuretwo.noargumentscreen.noArgumentsScreenNavigationRoute
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.detailsNavigation(
    onBackPressed: () -> Unit
) {
    composable(route = noArgumentsScreenNavigationRoute) {
        NoArgumentScreenRoute(
            onBackPressed = onBackPressed
        )
    }

    composable(
        route = argumentsScreenNavigationRoute +
                "?stringArgument={$stringArgumentId}" +
                "&intArgument={$intArgumentId}",
        arguments = listOf(
            navArgument(stringArgumentId) {
                type = NavType.StringType
            },
            navArgument(intArgumentId) {
                type = NavType.IntType
            }

        )
    ) {
        ArgumentScreenRoute(
            onBackPressed = onBackPressed
        )
    }
}