package com.jesil.pratice.aad.utils

sealed class DataResult<out T : Any>{
    data class Success<T:Any>(val data : T?): DataResult<T>()
    data class Error(val error: Throwable):DataResult<Nothing>()
    class Loading: DataResult<Nothing>()
}
