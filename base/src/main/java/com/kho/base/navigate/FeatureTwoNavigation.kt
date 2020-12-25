package com.elyeproj.base.navigate

import android.content.Intent
import com.elyeproj.base.DynamicFeature
import com.elyeproj.base.loadIntentOrNull

object FeatureTwoNavigation : DynamicFeature<Intent> {

    private const val TWO = "com.elyeproj.featuretwo.FeatureTwoActivity"

    override val dynamicStart: Intent?
        get() = TWO.loadIntentOrNull()
}