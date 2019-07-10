package com.chrisjenx.core

import android.app.Application
import javax.inject.Inject

abstract class CoreApplication : Application() {
    @Inject lateinit var database: Database
}