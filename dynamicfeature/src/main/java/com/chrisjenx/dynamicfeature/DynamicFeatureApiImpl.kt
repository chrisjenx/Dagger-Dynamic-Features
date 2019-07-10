package com.chrisjenx.dynamicfeature

import com.chrisjenx.core.Database
import javax.inject.Inject

class DynamicFeatureApiImpl
@Inject constructor(private val database: Database) : DynamicFeatureApi {
    override fun doSomething(): String = database.getData()
}