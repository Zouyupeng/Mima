package com.oceanknight.mima.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.oceanknight.mima.ui.component.MimaIcon

@Composable
fun MimaNavBar(
    modifier: Modifier = Modifier,
    topNavRoute: List<NavigationRoute> = enumValues<NavigationRoute>()
        .filter { it.selectedIconId != null && it.unselectedIconId != null },
    currentNav: String,
    navController: NavController
) {
    NavigationBar(
        modifier = modifier
    ) {
        topNavRoute.forEach{ destination ->
            val label = stringResource(id = destination.labelId)
            NavigationBarItem(
                selected = currentNav == destination.name,
                onClick = {
                    navController.popBackStack()
                    navController.navigate(destination.name) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if (currentNav == destination.name) {
                        MimaIcon(destination.selectedIconId!!, label)
                    } else {
                        MimaIcon(destination.unselectedIconId!!, label)
                    }
                }
            )
        }
    }
}