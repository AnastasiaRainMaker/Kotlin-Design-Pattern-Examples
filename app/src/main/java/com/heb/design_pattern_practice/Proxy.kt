package com.heb.design_pattern_practice

interface Storage {
    fun access()
}

class OpenStorage : Storage {
    override fun access() {
        println("Accessing storage")
    }
}

/**
 * Proxy
 */
class PrivateStorage(private val password: String) : Storage {

    private val openStorage = OpenStorage()

    override fun access() {
        if (password == "correctPassword") {
            openStorage.access()
        } else {
            println("Access denied. Incorrect password")
        }
    }
}

fun main() {
    OpenStorage().access()
    PrivateStorage("incorrectPassword").access()
    PrivateStorage("correctPassword").access()

    //result
    //Accessing storage
    //Access denied. Incorrect password
    //Accessing storage
}