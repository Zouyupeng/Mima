package com.oceanknight.mima.ui.page.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.oceanknight.mima.R

/**
 * @author Oceanknight
 * @date 2023/9/4 22:48
 * @describe
 */
@Composable
fun DashBoardScreen(
    shouldNavBottomBar: Boolean = true
) {
    if (shouldNavBottomBar) {
        Column() {
            LedgerSelectTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f)
            )


        }
    }

}

// TODO: 待数据库做好以后修改数据来源
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LedgerSelectTopBar(
    modifier : Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (imageRef, ledgerNameRef, switchButtonRef) = createRefs()

        createHorizontalChain(
            imageRef, ledgerNameRef, switchButtonRef,
            chainStyle = ChainStyle.SpreadInside
        )

        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.ledger_select_hint),
            modifier = Modifier
                .fillMaxHeight()
                .padding(4.dp)
                .clip(RoundedCornerShape(10.dp))
                .constrainAs(imageRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxHeight()

        )
        
        Column(
            modifier = Modifier
                .constrainAs(ledgerNameRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }
        ) {
            Text(
                text = stringResource(id = R.string.current_ledger)
            )

            // 账本名称实现跑马灯的效果
            Text(
                text = "默认账本",
                fontSize = 28.sp,
                modifier = Modifier
                    .wrapContentWidth()
                    .basicMarquee()
            )
        }

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(end = 10.dp)
                .constrainAs(switchButtonRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_switch_unselected),
                contentDescription = stringResource(id = R.string.switch_ledger_hint),
            )
        }



    }
}
