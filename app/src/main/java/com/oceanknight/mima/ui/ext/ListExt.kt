package com.oceanknight.mima.ui.ext

import androidx.compose.foundation.lazy.LazyListState

/**
 * @author Oceanknight
 * @date 2023/9/10 14:42
 * @describe
 */
// 列表是否被滑动
val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0