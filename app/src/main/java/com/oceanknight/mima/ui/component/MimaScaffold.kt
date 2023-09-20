package com.oceanknight.mima.ui.component

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.oceanknight.mima.ui.MimaAppState
import com.oceanknight.mima.ui.ext.topLevelNavigateTo
import com.oceanknight.mima.ui.navigation.MimaNavBar
import com.oceanknight.mima.ui.navigation.NavigationRoute
import com.oceanknight.mima.ui.navigation.NavigationType
import com.oceanknight.mima.ui.navigation.shouldShowNav
import com.oceanknight.mima.ui.viewmodel.HomeViewModel

@Composable
fun MimaScaffold(
    modifier: Modifier = Modifier,
    appState: MimaAppState,
    content: @Composable (PaddingValues) -> Unit
) {
    val homeViewModel: HomeViewModel = viewModel()
    val currentNav = homeViewModel.currentNavRoute

    Scaffold(
        modifier = modifier
            .statusBarsPadding(),
        bottomBar = {
            if (appState.navType == NavigationType.BAR && currentNav.shouldShowNav) {
                MimaNavBar(
                    topNavigateTo = appState.navController::topLevelNavigateTo
                )
            }
        }
    ) { padding ->
        // TODO: 适配多尺寸屏幕
        if (appState.navType == NavigationType.RAIL) {

        }
        if (appState.navType == NavigationType.DRAWER) {

        }
        content(padding)
    }
}