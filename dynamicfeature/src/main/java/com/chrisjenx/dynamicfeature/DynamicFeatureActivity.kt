package com.chrisjenx.dynamicfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chrisjenx.core.coreComponent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class DynamicFeatureActivity : AppCompatActivity() {

    @Inject lateinit var dynamicFeatureApi: DynamicFeatureApi

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerDynamicComponent.builder().activity(this).core(coreComponent()).build().also { c ->
            c.inject(this@DynamicFeatureActivity)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_feature)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "API Result: ${dynamicFeatureApi.doSomething()}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
