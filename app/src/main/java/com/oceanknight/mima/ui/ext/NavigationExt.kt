package com.oceanknight.mima.ui.ext

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

/**
 *
 * @author: zouyupeng
 * @date: 2023/09/15
 * @describe:
 */
fun NavController.topLevelNavigateTo(destination: String) {
    popBackStack()
    navigate(destination) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}