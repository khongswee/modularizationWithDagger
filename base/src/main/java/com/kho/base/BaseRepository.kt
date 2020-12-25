package com.elyeproj.base

class BaseRepository(val name: String) {
    override fun toString(): String {
        return "BaseRepository $name ${super.toString()} "
    }
    fun getSomething():String{
        return "${name}:----"
    }
}
