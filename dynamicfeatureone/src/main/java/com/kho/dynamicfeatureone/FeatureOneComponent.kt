package com.kho.dynamicfeatureone

import com.elyeproj.base.ActivityScope
import com.elyeproj.base.BaseComponent
import dagger.Component

@ActivityScope
@Component(dependencies = [BaseComponent::class],modules = [FeatureOneDependentModule::class])
interface FeatureOneComponent {
    fun inject(featureOneActivity: OneMainActivity)
}