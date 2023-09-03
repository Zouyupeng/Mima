package com.oceanknight.mima.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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