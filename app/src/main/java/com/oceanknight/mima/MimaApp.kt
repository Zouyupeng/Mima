package com.oceanknight.mima

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MimaApp : Application() {


    override fun onCreate() {
        super.onCreate()
    }
}