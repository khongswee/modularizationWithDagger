package com.kho.modularization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elyeproj.base.navigate.FeatureOneNavigation
import com.kho.modularization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textHello.setOnClickListener {
            startActivity(FeatureOneNavigation.dynamicStart)
        }
    }
}