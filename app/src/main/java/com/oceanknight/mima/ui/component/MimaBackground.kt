package com.oceanknight.mima.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache

/**
 * @author Oceanknight
 * @date 2023/9/14 22:11
 * @describe
 */
@Composable
fun MimaBackground(
    modifier : Modifier = Modifier,
    content : @Composable () -> Unit
) {
//    val
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onPrimary
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            content()
        }

    }
}