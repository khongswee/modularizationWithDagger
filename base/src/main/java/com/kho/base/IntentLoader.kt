package com.kho.base

import android.content.Intent

private const val PACKAGE_NAME = "com.kho.modularization"

private fun intentTo(className: String): Intent =
    Intent(Intent.ACTION_VIEW).setClassName(BaseApplication.packageNameDynamic, className)

internal fun String.loadIntentOrNull(): Intent? =
    try {
        Class.forName(this).run { intentTo(this@loadIntentOrNull) }
    } catch (e: ClassNotFoundException) {
        null
    }
