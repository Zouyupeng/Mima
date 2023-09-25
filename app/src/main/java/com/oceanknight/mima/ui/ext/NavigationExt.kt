package com.oceanknight.mima.ui.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * @author Oceanknight
 * @date 2023/9/19 21:38
 * @describe
 */
fun NavController.topLevelNavigateTo(destination: String) {
    // 保留这句话会更符合国内应用底栏习惯,不会反回到StartDestination.但是会导致状态无法保存-_-||思考一下怎么处理
    popBackStack()
    navigate(destination) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
fun NavController.getCurrentDestination(): String {
    val currentBackStackEntryAsState by currentBackStackEntryAsState()
    return currentBackStackEntryAsState?.destination?.route ?: "ERROR_PAGE"
}