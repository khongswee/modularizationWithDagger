package com.kho.dynamicfeatureone

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elyeproj.base.BaseApplication
import javax.inject.Inject

class OneMainActivity : AppCompatActivity() {

    @Inject
    lateinit var featureOneDependent: FeatureOneDependent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_main)
        DaggerFeatureOneComponent.builder()
            .baseComponent(BaseApplication.baseComponent)
            .build()
            .inject(this)
        val message = featureOneDependent.getMessage()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}