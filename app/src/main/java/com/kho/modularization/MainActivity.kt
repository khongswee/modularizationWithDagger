package com.kho.modularization

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kho.base.navigate.FeatureOneNavigation
import com.kho.modularization.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
//            startActivity(FeatureOneNavigation.dynamicStart)
            throw RuntimeException("Test Crash") // Force a crash
        }
        binding.textVersion.text = getVersionName()
    }

    private fun getVersionName(): String {
        return try {
            val pInfo: PackageInfo =
                this.packageManager.getPackageInfo(this.packageName, 0)
            pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            "cannot get version name"
        }
    }
}