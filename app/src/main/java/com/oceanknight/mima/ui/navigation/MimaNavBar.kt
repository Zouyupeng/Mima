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
import androidx.hilt.navigation.compose.hiltViewModel
import com.oceanknight.mima.ui.viewmodel.HomeViewModel

@Composable
fun MimaNavBar(
    modifier: Modifier = Modifier,
    topNavRoute: List<NavigationRoute> = enumValues<NavigationRoute>()
        .filter { it.selectedIconId != null && it.unselectedIconId != null },
    homeViewModel: HomeViewModel = hiltViewModel(),
    topNavigateTo: (String) -> Unit = {}
) {
    NavigationBar(
        modifier = modifier
    ) {
        val currentNav = homeViewModel.currentNavRoute
        topNavRoute.forEach{ destination ->
            val label = stringResource(id = destination.labelId)
            NavigationBarItem(
                selected = currentNav == destination,
                onClick = {
                    homeViewModel.setCurrentNavRoute(destination)
                    topNavigateTo(destination.name)
                },
                icon = {
                    if (currentNav == destination) {
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