package com.kho.base

import android.app.Application
class BaseApplication: Application() {
    companion object {
        val baseComponent by lazy {
            DaggerBaseComponent.create()
        }
        var packageNameDynamic : String = "com.kho.modularization"
    }

    override fun onCreate() {
        super.onCreate()
        packageNameDynamic = this.packageName
    }
}
