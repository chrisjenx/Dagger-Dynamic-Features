package com.chrisjenx.dynamicdagger

import com.chrisjenx.core.CoreApplication
import com.chrisjenx.core.CoreComponent
import com.chrisjenx.core.CoreComponentProvider
import com.chrisjenx.core.DaggerCoreComponent

class MainApplication : CoreApplication(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        coreComponent = DaggerCoreComponent.builder().application(this).build().also { c ->
            c.inject(this)
        }
        super.onCreate()
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent
}