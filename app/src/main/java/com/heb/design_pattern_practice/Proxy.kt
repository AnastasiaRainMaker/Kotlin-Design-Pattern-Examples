package com.heb.design_pattern_practice

interface Storage {
    fun access()
}

class OpenStorage : Storage {
    override fun access() {
        println("Accessing storage")
    }

}

class PrivateStorage(private val password: String) : Storage {

    private val _openStorage = OpenStorage()

    override fun access() {
        if (password == "correctPassword") {
            _openStorage.access()
        } else {
            println("Access denied. Incorrect password")
        }
    }

}