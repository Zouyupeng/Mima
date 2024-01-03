package com.oceanknight.mima.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.oceanknight.mima.R
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

        SelectLedgerCardContent(
            modifier = Modifier.fillMaxWidth(),
            cardHeight = cardHeight,
            onMenuClick = onLedgerSwitchClick
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
            modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight)) {
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

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SelectLedgerCardContent(
    modifier: Modifier = Modifier,
    cardHeight: Dp = 60.dp,
    onMenuClick: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier.height(cardHeight)
    ) {
        val (iconRef, nameRef, buttonRef) = createRefs()

        val verticalTextEndLine = createGuidelineFromEnd(0.3f)

        Icon(
            painter = painterResource(id = R.drawable.ledger_unselected),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(iconRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start, 15.dp)
                }
        )

        Box(
            Modifier
                .basicMarquee()
                .constrainAs(nameRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(iconRef.end, 15.dp)
                    end.linkTo(verticalTextEndLine)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {
            // TODO: 之后用真实数据替换
            Text(
                text = "当前账本名称2023abxy",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .basicMarquee()
                    .align(Alignment.Center)
            )
        }

        Button(
            contentPadding = PaddingValues(15.dp),
            shape = CircleShape,
            modifier = Modifier
                .size(cardHeight)
                .constrainAs(buttonRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = onMenuClick
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_switch_unselected),
                contentDescription = stringResource(id = R.string.image_des_switch_ledger),
                modifier = Modifier.size(cardHeight)
            )
        }
    }
}

@Preview
@Composable
fun SelectLedgerCardPrev() {
    SelectLedgerCard()
}