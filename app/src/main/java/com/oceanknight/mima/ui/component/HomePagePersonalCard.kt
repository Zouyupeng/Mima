package com.oceanknight.mima.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.oceanknight.mima.R
import com.oceanknight.mima.data.util.DateUtil
import com.oceanknight.mima.ui.ext.clipRoundedCorner
import kotlinx.coroutines.delay

/**
 * @author Oceanknight
 * @date 2023/12/30 15:39
 * @describe
 */
@Composable
fun HomePagePersonalCard(
    modifier: Modifier = Modifier,
    cardHeight: Dp = 170.dp,
    cardContainerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    buttonContainerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
    cardBackgroundColor: Color = MaterialTheme.colorScheme.surface,
    onMenuClick:() -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier.height(cardHeight),
    ) {
        HomePagePersonalCardBackground(
            modifier = Modifier.fillMaxWidth(),
            cardHeight = cardHeight,
            cardContainerColor = cardContainerColor,
            buttonContainerColor = buttonContainerColor,
            cardBackgroundColor = cardBackgroundColor,
        )

        var visibility by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            delay(300)
            visibility = true
        }

        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn() + slideInHorizontally { fullHeight -> fullHeight }
        ) {
            CardBackgroundColorContent(
                modifier = Modifier.fillMaxWidth(),
                cardHeight = cardHeight,
                onMenuClick = onMenuClick
            )
        }
    }
}

@Composable
fun CardBackgroundColorContent(
    modifier: Modifier = Modifier,
    cardHeight: Dp = 170.dp,
    onMenuClick: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier.height(cardHeight)
    ) {
        val (avatarRef, dayRef, monthRef, dayOfWeekRef, dividerRef, welcomeRef, userNameRef, menuButtonRef) = createRefs()

        // TODO: 之后用真实的头像路径搞
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.image_des_avatar),
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
                .fillMaxHeight()
                .aspectRatio(1f)
                .constrainAs(avatarRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )

        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(dayRef) {
                    top.linkTo(parent.top)
                    start.linkTo(avatarRef.end)
                },
            text = DateUtil.getCurrentDayAsString(),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(dayOfWeekRef) {
                    baseline.linkTo(dayRef.baseline)
                    start.linkTo(dayRef.end, 5.dp)
                },
            text = DateUtil.getCurrentDayOfWeekAsString(context = LocalContext.current),
        )

        Text(
            modifier = Modifier
                .constrainAs(monthRef) {
                    start.linkTo(dayOfWeekRef.start)
                    top.linkTo(dayRef.top, 15.dp)
                },
            text = DateUtil.getCurrentMonthShorthandAsString()
        )

        Divider(
            modifier = Modifier.constrainAs(dividerRef) {
                top.linkTo(dayRef.bottom)
                start.linkTo(dayRef.start)
                end.linkTo(dayOfWeekRef.end)
                width = Dimension.fillToConstraints
            },
            thickness = 1.dp,
            color = Color.Black
        )

        Text(
            modifier = Modifier
                .constrainAs(welcomeRef) {
                    top.linkTo(dividerRef.bottom, 10.dp)
                    start.linkTo(avatarRef.end)
                },
            text = stringResource(id = R.string.welcome),
            fontSize = 20.sp,
            color = Color.DarkGray,
            fontStyle = FontStyle.Italic
        )
        
        val userNameEndLine = createGuidelineFromEnd(0f)

        // TODO: 之后用真实设置的用户名搞
        Box(modifier = Modifier
            .constrainAs(userNameRef) {
                top.linkTo(welcomeRef.bottom, 5.dp)
                bottom.linkTo(avatarRef.bottom, 10.dp)
                start.linkTo(welcomeRef.start)
                end.linkTo(userNameEndLine)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }) {
            Text(
                text = "Oceanknight",
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }


        Button(
            shape = CircleShape,
            contentPadding = PaddingValues(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .size(cardHeight * 2 / 5)
                .constrainAs(menuButtonRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            onClick = onMenuClick
        ) {
            Icon(
                modifier = Modifier.wrapContentSize(),
                painter = painterResource(id = R.drawable.dot_menu),
                contentDescription = stringResource(id = R.string.image_des_dashboard_menu)
            )
        }



    }
}

@Composable
fun HomePagePersonalCardBackground(
    modifier: Modifier = Modifier,
    cardContainerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    buttonContainerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
    cardBackgroundColor: Color = MaterialTheme.colorScheme.surface,
    cardHeight: Dp = 170.dp
) {
    val cardColor = CardDefaults.cardColors(containerColor = cardContainerColor)
    var radius = with(LocalDensity.current) {
        (cardHeight / 5).toPx()
    }
    Card(
        modifier = modifier
            .height(cardHeight)
            .clipRoundedCorner(),
        colors = cardColor
    ) {
        Canvas(modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)) {
            // 右 竖 方块 背景色
            drawRect(
                color = cardBackgroundColor,
                topLeft = Offset(
                    x = size.width - (radius * 0.8f),
                    y = 0f),
                size = size.copy(width = radius * 0.8f, height = radius * 0.8f + (radius * 2.8f)),
            )

            // 上 横 方块 背景色
            drawRect(
                color = cardBackgroundColor,
                topLeft = Offset(
                    x = size.width - (radius * 0.8f) - (radius * 2.8f),
                    y = 0f),
                size = size.copy(width = radius * 0.8f + (radius * 2.8f), height = radius * 0.8f),
            )

            // 右上 圆圈 背景
            drawCircle(
                color = cardBackgroundColor,
                radius = radius * 2,
                center = Offset(
                    x = size.width - (radius * 0.8f),
                    y = radius * 0.8f
                )
            )

            // 左上 圆圈 卡片侧
            drawCircle(
                color = cardContainerColor,
                radius = radius * 0.8f,
                center = Offset(
                    x = size.width - (radius * 0.8f) - (radius * 2.8f),
                    y = radius * 0.8f
                )
            )

            // 右下圆圈 卡片侧
            drawCircle(
                color = cardContainerColor,
                radius = radius * 0.8f,
                center = Offset(
                    x = size.width - (radius * 0.8f),
                    y = radius * 0.8f + (radius * 2.8f)
                )
            )

            // 右上角 方块 背景色
            drawRect(
                color = cardBackgroundColor,
                topLeft = Offset(
                    x = size.width - radius,
                    y = 0f),
                size = size.copy(width = radius, height = radius),
            )

            // 右上圆圈 卡片色 装功能按钮用
            drawCircle(
                color = buttonContainerColor,
                radius = radius ,
                center = Offset(
                    x = size.width - radius,
                    y = radius
                )
            )
        }
    }
}


@Preview
@Composable
fun CardBackgroundColorContentPreview() {
    CardBackgroundColorContent(
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview
@Composable
fun HomePagePersonalCardPreview() {
    HomePagePersonalCard(
        modifier = Modifier.fillMaxWidth(),
        cardHeight = 170.dp
    )
}