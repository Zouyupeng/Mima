package com.oceanknight.mima.ui.component

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oceanknight.mima.ui.navigation.MimaNavBar

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MimaScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    shouldNavBottomBar: Boolean = false,
    shouldNavRail: Boolean = false,
    shouldNavDrawer: Boolean = false,
    currentNavDestination: String = "",
    topLevelNavigateTo: (String) -> Unit,
    leftPane: @Composable () -> Unit = {},
    rightPane: @Composable () -> Unit = {},
    singleContent: @Composable ( PaddingValues) -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (shouldNavBottomBar) {
                MimaNavBar(
                    currentNav = currentNavDestination,
                    topLevelNavigateTo = topLevelNavigateTo
                )
            }
        }
    ) { padding ->
        singleContent(padding)
    }
}