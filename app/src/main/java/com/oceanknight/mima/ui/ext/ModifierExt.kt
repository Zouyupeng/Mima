package com.oceanknight.mima.ui.ext

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author Oceanknight
 * @date 2023/12/30 18:35
 * @describe
 */
fun Modifier.sidesPadding() = this.padding(start = 10.dp, end = 10.dp)

fun Modifier.clipRoundedCorner() = this.clip(RoundedCornerShape(15.dp))

fun Modifier.paddingTop(topDp: Dp = 15.dp) = this.padding(top = topDp)