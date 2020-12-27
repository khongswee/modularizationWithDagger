package com.kho.base.navigate

import android.content.Intent
import com.kho.base.DynamicFeature
import com.kho.base.loadIntentOrNull

object FeatureTwoNavigation : DynamicFeature<Intent> {

    private const val TWO = "...FeatureTwoActivity"

    override val dynamicStart: Intent?
        get() = TWO.loadIntentOrNull()
}