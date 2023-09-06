package com.oceanknight.mima.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination

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
                        Icon(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(id = destination.selectedIconId!!),
                            contentDescription = label
                        )
                    } else {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(id = destination.unselectedIconId!!),
                            contentDescription = label
                        )
                    }
                },
                label = {
                    Text(text = label)
                }
            )
        }
    }
}