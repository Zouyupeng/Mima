package com.oceanknight.mima.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.oceanknight.mima.ui.navigation.NavigationRoute
import com.oceanknight.mima.ui.navigation.NavigationType

/**
 * Mima应用状态
 * @author Oceanknight
 * @date 2023/08/21
 * @constructor 创建[MimaAppState]
 * @param [navController] 导航控制器
 * @param [windowSizeClass] 窗口尺寸类
 */
class MimaAppState(
    val navController: NavController,
    val windowSizeClass: WindowSizeClass
) {
    val shouldNavBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldNavRail: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Medium

    val shouldNavDrawer: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Expanded

    val navType: NavigationType
        get() = if (shouldNavBottomBar) NavigationType.BAR
                else if (shouldNavRail) NavigationType.RAIL
                else NavigationType.DRAWER

    fun getTopNavigationRoute(): List<NavigationRoute> {
        return NavigationRoute
            .values()
            .filter { it.selectedIconId != null && it.unselectedIconId != null }
    }

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val shouldShowNavigation: Boolean
        @Composable get() = when(currentDestination?.route) {
            stringResource(id = NavigationRoute.DASH_BOARD.labelId) -> true
            else -> false
        }
}



@Composable
fun rememberMimaAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavController = rememberNavController(),
): MimaAppState {
    return remember(
        windowSizeClass,
        navController,
    ) {
        MimaAppState(
            navController,
            windowSizeClass,
        )
    }
}