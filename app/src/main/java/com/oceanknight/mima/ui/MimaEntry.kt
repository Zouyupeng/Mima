package com.oceanknight.mima.ui

import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oceanknight.mima.ui.component.MimaScaffold
import com.oceanknight.mima.ui.ext.topLevelNavigateTo
import com.oceanknight.mima.ui.navigation.NavigationRoute
import com.oceanknight.mima.ui.page.dashboard.DashBoardScreen
import com.oceanknight.mima.ui.page.journal.JournalScreen
import com.oceanknight.mima.ui.page.ledger.LedgerScreen
import com.oceanknight.mima.ui.page.mine.MineScreen

/**
 * Mima程序入口
 * @param [windowSizeClass] 窗口大小类
 */
@Composable
fun MimaEntry(
    windowSizeClass: WindowSizeClass,
    appState: MimaAppState = rememberMimaAppState(windowSizeClass = windowSizeClass)
) {
    NavHost(
        navController = appState.navController,
        startDestination = NavigationRoute.DASH_BOARD.name,
    ) {
        composable(NavigationRoute.DASH_BOARD.name) {
            DashBoardScreen(
                appState.navType,
                appState.currentNavDestination ?: "",
                appState.navController::topLevelNavigateTo
            )
        }
        composable(NavigationRoute.LEDGER.name) {
            LedgerScreen(
                appState.navType,
                appState.currentNavDestination ?: "",
                appState.navController::topLevelNavigateTo
            )
        }
        composable(NavigationRoute.JOURNAL.name) {
            JournalScreen(
                appState.navType,
                appState.currentNavDestination ?: "",
                appState.navController::topLevelNavigateTo
            )
        }
        composable(NavigationRoute.MINE.name) {
            MineScreen(
                appState.navType,
                appState.currentNavDestination ?: "",
                appState.navController::topLevelNavigateTo
            )
        }
    }
}

