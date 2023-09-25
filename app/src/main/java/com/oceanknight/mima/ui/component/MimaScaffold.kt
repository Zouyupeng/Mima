package com.oceanknight.mima.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oceanknight.mima.ui.MimaAppState
import com.oceanknight.mima.ui.ext.getCurrentDestination
import com.oceanknight.mima.ui.ext.shouldShowNav
import com.oceanknight.mima.ui.ext.topLevelNavigateTo
import com.oceanknight.mima.ui.navigation.MimaNavBar
import com.oceanknight.mima.ui.navigation.NavigationType

@Composable
fun MimaScaffold(
    modifier: Modifier = Modifier,
    appState: MimaAppState,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (appState.getNavType() == NavigationType.BAR && appState.navController.getCurrentDestination().shouldShowNav) {
                MimaNavBar(
                    topNavigateTo = appState.navController::topLevelNavigateTo,
                    currentDestination = appState.navController.getCurrentDestination()
                )
            }
        }
    ) { padding ->
        // TODO: 适配多尺寸屏幕
        if (appState.getNavType() == NavigationType.RAIL) {

        }
        if (appState.getNavType() == NavigationType.DRAWER) {

        }
        content(padding)
    }
}