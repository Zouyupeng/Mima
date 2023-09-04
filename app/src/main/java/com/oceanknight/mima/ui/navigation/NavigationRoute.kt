package com.oceanknight.mima.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.oceanknight.mima.R

enum class NavigationRoute(
    val labelId: Int,
    val selectedIconId: Int? = null,
    val unselectedIconId: Int? = null,
) {
    // 总览
    DASH_BOARD(
        labelId = R.string.dash_board,
        selectedIconId = R.drawable.dash_board_selected,
        unselectedIconId = R.drawable.dash_board_unselectd
    ),
    // 账本
    LEDGER(
        labelId = R.string.ledger,
        selectedIconId = R.drawable.ledger_selected,
        unselectedIconId = R.drawable.ledger_unselected
    ),
    // 日记
    JOURNAL(
        labelId = R.string.journal,
        selectedIconId = R.drawable.journal_selected,
        unselectedIconId = R.drawable.journal_unselected
    ),
    MINE(
        labelId = R.string.mine,
        selectedIconId = R.drawable.mine_selected,
        unselectedIconId = R.drawable.mine_unselected
    )
}

