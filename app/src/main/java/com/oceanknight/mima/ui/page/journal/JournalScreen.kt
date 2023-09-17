package com.oceanknight.mima.ui.page.journal

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oceanknight.mima.ui.component.MimaScaffold
import com.oceanknight.mima.ui.navigation.NavigationType

/**
 * @author Oceanknight
 * @date 2023/9/4 22:50
 * @describe
 */
@Composable
fun JournalScreen(
    navType: NavigationType,
    currentNavDestination : String = "",
    topLevelNavigateTo: (String) -> Unit = {}
) {
    MimaScaffold(
        topLevelNavigateTo = topLevelNavigateTo,
        navType = navType,
        currentNavDestination = currentNavDestination,
        modifier = Modifier
            .statusBarsPadding()
    ) {
        Text(text = "日记页ヾ(•ω•`)o")
    }


}