package com.kho.dynamicfeatureone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kho.base.BaseApplication
import com.kho.dynamicfeatureone.databinding.ActivityOneMainBinding
import javax.inject.Inject

class OneMainActivity : AppCompatActivity() {

    @Inject
    lateinit var featureOneDependent: FeatureOneDependent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOneMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DaggerFeatureOneComponent.builder()
            .baseComponent(BaseApplication.baseComponent)
            .build()
            .inject(this)
        val message = featureOneDependent.getLoginResponse()
        binding.messageText.text = message
    }
}