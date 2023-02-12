package com.example.composenavigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.featuretwo.argumentscreen.navigateToDetailsWithArgument
import com.example.featuretwo.navigation.detailsNavigation
import com.example.featuretwo.noargumentscreen.navigateToDetailsWithNoArguments
import com.example.home.homeScreenNavigationRoute
import com.example.home.navigation.homeNavigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExampleNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    startDestination: String = homeScreenNavigationRoute
) {

    AnimatedNavHost(modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left) },
        exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right) }
    ) {
        /**
         * Home screen navigation
         */
        homeNavigation(
            onNavigateToDetailsWithNoArguments = {
                navController.navigateToDetailsWithNoArguments()
            },
            onNavigateToDetailsWithArgument = { stringArgument, intArgument ->
                navController.navigateToDetailsWithArgument(
                    stringArgument,
                    intArgument
                )
            }
        )

        /**
         * Details screen navigation
         */
        detailsNavigation(
            onBackPressed = { navController.popBackStack() }
        )
    }
}