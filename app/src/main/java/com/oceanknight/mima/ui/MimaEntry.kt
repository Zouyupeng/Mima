package com.oceanknight.mima.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oceanknight.mima.ui.component.MimaScaffold
import com.oceanknight.mima.ui.navigation.NavigationRoute
import com.oceanknight.mima.ui.navigation.NavigationType
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
    MimaScaffold(
        appState = appState
    ){ padding ->
        NavHost(
            modifier = Modifier,
            navController = appState.navController,
            startDestination = NavigationRoute.DASH_BOARD.name
        ) {
            composable(NavigationRoute.DASH_BOARD.name) {
                DashBoardScreen(
                    shouldNavBottomBar = appState.getNavType() == NavigationType.BAR,
                    paddingValues = padding
                )
            }
            composable(NavigationRoute.LEDGER.name) {
                LedgerScreen()
            }
            composable(NavigationRoute.JOURNAL.name) {
                JournalScreen()
            }
            composable(NavigationRoute.MINE.name) {
                MineScreen()
            }
        }
    }
}