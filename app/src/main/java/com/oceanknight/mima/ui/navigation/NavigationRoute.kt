package com.oceanknight.mima.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.oceanknight.mima.R

enum class NavigationRoute(
    val labelId: Int,
    val selectedIconId: Int? = null,
    val unselectedIconId: Int? = null,
) {
    DASH_BOARD(
        labelId = R.string.dash_board,
        selectedIconId = R.drawable.dash_board_selected,
        unselectedIconId = R.drawable.dash_board_unselectd
    ),
    // ...
}