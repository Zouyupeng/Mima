package com.oceanknight.mima.ui.ext

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 *
 * @author: zouyupeng
 * @date: 2023/09/11
 * @describe:
 */
fun AndroidViewModel.getString(id: Int) : String {
    return getApplication<Application>().resources.getString(id)
}