package com.oceanknight.mima.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.oceanknight.mima.ui.ext.clipRoundedCorner

/**
 * @author Oceanknight
 * @date 2024/1/2 22:30
 * @describe
 */
@Composable
fun SelectLedgerCard(
    modifier: Modifier = Modifier,
    cardHeight: Dp = 60.dp,
    onLedgerSwitchClick:() -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier
            .height(cardHeight)
    ) {
        SelectLedgerCardBackground(
            modifier = Modifier.fillMaxWidth(),
            cardHeight = cardHeight
        )
    }

}

@Composable
fun SelectLedgerCardBackground(
    modifier: Modifier = Modifier,
    cardHeight: Dp = 60.dp,
    cardContainerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    buttonContainerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
    cardBackgroundColor: Color = MaterialTheme.colorScheme.surface,
) {
    val cardColor = CardDefaults.cardColors(containerColor = cardContainerColor)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(cardHeight)
            .clipRoundedCorner(),
        colors = cardColor
    ) {
        val radius = with(LocalDensity.current) { (cardHeight / 2).toPx() }
        Canvas(
            modifier = Modifier.fillMaxWidth().height(cardHeight)) {
            // 右正方形 背景色
            drawRect(
                color = cardBackgroundColor,
                topLeft = Offset(
                    x = size.width - (radius * 2f),
                    y = 0f
                ),
                size = size.copy(width = radius * 4f, height = radius * 2f)
            )

            // 右圆 背景色 离太远感觉不是太好看
            drawCircle(
                color = cardBackgroundColor,
                radius = radius,
                center = Offset(
                    x = size.width - (radius * 1.7f),
                    y = radius
                )
            )

            // 按钮背景
            drawCircle(
                color = buttonContainerColor,
                radius = radius,
                center = Offset(
                    x = size.width - (radius * 1f),
                    y = radius
                )
            )
        }
    }
}

@Preview
@Composable
fun SelectLedgerCardPrev() {
    SelectLedgerCard()
}