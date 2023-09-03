package com.oceanknight.mima.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable

/**
 * Mima程序入口
 * @param [windowSizeClass] 窗口大小类
 */
@Composable
fun MimaEntry(
    windowSizeClass: WindowSizeClass,
    appState: MimaAppState = rememberMimaAppState(windowSizeClass = windowSizeClass)
) {

}