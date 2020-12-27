package com.kho.dynamicfeatureone

import com.kho.base.BaseNetwork
import com.kho.base.BaseRepository

class FeatureOneDependent(
    private val name: String,
    private val baseRepository: BaseRepository,
    private val baseNetwork: BaseNetwork
) {

    fun getLoginResponse() = run {
        if (baseNetwork.isLoginSuccess())
            "This is ${name}\n"+baseRepository.getLoginInformation()
        else
            "no response"
    }
}
