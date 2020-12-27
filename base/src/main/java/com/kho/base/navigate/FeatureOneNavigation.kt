package com.kho.base.navigate

import android.content.Intent
import com.kho.base.DynamicFeature
import com.kho.base.loadIntentOrNull

object FeatureOneNavigation : DynamicFeature<Intent> {

    private const val ONE = "com.kho.dynamicfeatureone.OneMainActivity"

    override val dynamicStart: Intent?
        get() = ONE.loadIntentOrNull()
}