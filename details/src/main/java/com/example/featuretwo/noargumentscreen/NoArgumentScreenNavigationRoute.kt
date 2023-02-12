package com.example.featuretwo.noargumentscreen

import androidx.navigation.NavController

const val noArgumentsScreenNavigationRoute = "no_arguments_screen_navigation_route"

fun NavController.navigateToDetailsWithNoArguments() {
    this.navigate(noArgumentsScreenNavigationRoute)
}
