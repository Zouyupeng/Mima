package com.oceanknight.mima.ui.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

/**
 * @author Oceanknight
 * @date 2023/9/4 21:54
 * @describe
 */
@Composable
fun MimaIcon(
    painterId: Int,
    description: String? = null
) {
    Icon(painterResource(id = painterId), contentDescription = description)
}