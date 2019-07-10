package com.chrisjenx.core

import android.app.Activity
import android.app.Application
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    fun inject(application: CoreApplication)

    // Dependencies
    fun database(): Database

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }
}

@Module
interface CoreModule {
    @Binds fun bindsDatabase(impl: DatabaseImpl): Database
}

fun Activity.coreComponent(): CoreComponent = (applicationContext as? CoreComponentProvider)?.provideCoreComponent()
    ?: throw IllegalStateException("CoreComponentProvider not implemented: $applicationContext")