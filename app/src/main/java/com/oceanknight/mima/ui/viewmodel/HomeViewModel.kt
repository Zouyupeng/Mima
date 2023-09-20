package com.oceanknight.mima.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.oceanknight.mima.ui.navigation.NavigationRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Oceanknight
 * @date 2023/9/19 22:24
 * @describe
 */
@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {
    /** 当前导航 */
    private val _currentNavRoute = mutableStateOf(NavigationRoute.DASH_BOARD)
    val currentNavRoute
        get() = _currentNavRoute.value
    fun setCurrentNavRoute(route: NavigationRoute) {
        _currentNavRoute.value = route
    }


}