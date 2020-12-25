package com.kho.dynamicfeatureone

import com.elyeproj.base.BaseNetwork
import com.elyeproj.base.BaseRepository

class FeatureOneDependent(
    val name: String,
    private val baseRepository: BaseRepository,
    private val baseNetwork: BaseNetwork
) {
    override fun toString(): String {
        return "FeatureOneDependent $name ${super.toString()}  with\n$baseRepository and\n$baseNetwork"
    }

    fun getMessage() = baseRepository.getSomething()
}
