package com.oceanknight.mima.ui.ext

import com.oceanknight.mima.ui.navigation.NavigationRoute

/**
 *
 * @author: zouyupeng
 * @date: 2023/09/25
 * @describe:
 */

val String.shouldShowNav: Boolean
    get() = this == NavigationRoute.DASH_BOARD.name ||
            this == NavigationRoute.LEDGER.name ||
            this == NavigationRoute.JOURNAL.name ||
            this == NavigationRoute.MINE.name