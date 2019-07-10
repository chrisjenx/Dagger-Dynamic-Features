package com.chrisjenx.dynamicfeature

import androidx.fragment.app.FragmentActivity
import com.chrisjenx.core.CoreComponent
import com.chrisjenx.core.Database
import com.chrisjenx.core.FeatureScope
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [DynamicModule::class]
)
interface DynamicComponent {

    fun inject(activity: DynamicFeatureActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: FragmentActivity): Builder
        fun core(core: CoreComponent): Builder
        fun build(): DynamicComponent
    }
}

@Module
interface DynamicModule {
    @Binds fun bindsDynamicFeatureApi(impl: DynamicFeatureApiImpl): DynamicFeatureApi
}