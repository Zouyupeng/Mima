package com.oceanknight.mima.ui.component

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oceanknight.mima.ui.MimaAppState
import com.oceanknight.mima.ui.navigation.MimaNavBar
import com.oceanknight.mima.ui.navigation.NavigationRoute

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MimaScaffold(
    modifier: Modifier = Modifier,
    appState: MimaAppState,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (appState.shouldNavBottomBar) {
                MimaNavBar(
                    currentNav = appState.currentNavDestination ?: "",
                    navController = appState.navController
                )
            }
        }
    ) { padding ->
        Row (
            modifier = Modifier
                .fillMaxSize()
                // 系统导航栏与状态栏的padding
                .consumeWindowInsets(padding)
        ){
            if (appState.shouldNavRail) {

            }

            content()
        }
    }
}