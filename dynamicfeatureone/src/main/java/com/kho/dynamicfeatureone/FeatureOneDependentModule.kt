package com.kho.dynamicfeatureone

import com.kho.base.BaseNetwork
import com.kho.base.BaseRepository
import dagger.Module
import dagger.Provides

@Module
class FeatureOneDependentModule {
    @Provides
    fun appModel(baseRepository: BaseRepository, baseNetwork: BaseNetwork) =
        FeatureOneDependent("FeatureOne",baseRepository,baseNetwork)
}