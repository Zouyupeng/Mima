package com.oceanknight.mima.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination

@Composable
fun MimaNavBar(
    topNavRoute: List<NavigationRoute>,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        topNavRoute.forEach{ destination ->
            val label = stringResource(id = destination.labelId)
            NavigationBarItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = { /*TODO*/ }
            )
        }
    }
}