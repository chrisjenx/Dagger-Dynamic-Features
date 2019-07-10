package com.chrisjenx.dynamicdagger

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.dynamic_feature_button).setOnClickListener {
            val intent = Intent(this, Class.forName("com.chrisjenx.dynamicfeature.DynamicFeatureActivity"))
            startActivity(intent)
        }
    }
}
