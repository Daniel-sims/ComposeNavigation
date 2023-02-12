package com.example.composenavigation

import androidx.compose.runtime.Composable

@Composable
fun ExampleApp() {

    /**
     * In here we can configure our "base" of our app.
     *
     * Such as a scaffold that has a toolbar, bottom navigation view.
     *
     * We can also dynamically set our start destination by passing
     * a startDestination to [ExampleNavHost] based on some logic.
     * Which is a common scenario such as checking authentication state.
     */
    ExampleNavHost()
}