package com.kho.dynamicfeatureone

import com.kho.base.ActivityScope
import com.kho.base.BaseComponent
import dagger.Component

@ActivityScope
@Component(dependencies = [BaseComponent::class],modules = [FeatureOneDependentModule::class])
interface FeatureOneComponent {
    fun inject(featureOneActivity: OneMainActivity)
}