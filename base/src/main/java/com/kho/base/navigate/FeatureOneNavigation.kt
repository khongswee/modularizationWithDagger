package com.elyeproj.base.navigate

import android.content.Intent
import com.elyeproj.base.DynamicFeature
import com.elyeproj.base.loadIntentOrNull

object FeatureOneNavigation : DynamicFeature<Intent> {

    private const val ONE = "com.kho.dynamicfeatureone.OneMainActivity"

    override val dynamicStart: Intent?
        get() = ONE.loadIntentOrNull()
}