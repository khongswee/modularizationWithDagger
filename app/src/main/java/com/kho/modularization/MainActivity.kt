package com.kho.modularization

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.kho.base.navigate.FeatureOneNavigation
import com.kho.modularization.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
        private const val LOADING_PHRASE_CONFIG_KEY = "loading_phrase"
        private const val WELCOME_MESSAGE_KEY = "welcome_message"
        private const val WELCOME_MESSAGE_CAPS_KEY = "welcome_message_caps"
    }
    private lateinit var remoteConfig: FirebaseRemoteConfig
    private lateinit var binding: ActivityMainBinding
    private val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 3600
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        remoteConfig = Firebase.remoteConfig
        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d(TAG, "Config params updated: $updated")
                    Toast.makeText(this, "Fetch and activate succeeded",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Fetch failed",
                        Toast.LENGTH_SHORT).show()
                }
                displayWelcomeMessage()
            }

        binding.btnLogin.setOnClickListener {
            startActivity(FeatureOneNavigation.dynamicStart)
//            throw RuntimeException("Test Crash") // Force a crash
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

    private fun displayWelcomeMessage() {
        // [START get_config_values]
        val welcomeMessage = remoteConfig[WELCOME_MESSAGE_KEY].asString()
        // [END get_config_values]
        binding.welcomeTextView.isAllCaps = remoteConfig[WELCOME_MESSAGE_CAPS_KEY].asBoolean()
        binding.welcomeTextView.text = welcomeMessage
    }

}