package com.dhandyjoe.muviapp.vo

class Resource<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): Resource<T> = Resource(StatusResponse.SUCCESS, body, null)

        fun <T> error(msg: String, body: T): Resource<T> = Resource(StatusResponse.ERROR, body, msg)

        fun <T> loading(msg: String?, body: T): Resource<T> = Resource(StatusResponse.LOADING, body, msg)
    }
}
