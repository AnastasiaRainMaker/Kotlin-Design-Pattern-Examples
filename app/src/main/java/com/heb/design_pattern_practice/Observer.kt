package com.heb.design_pattern_practice

import kotlin.properties.Delegates

interface TextChangeObserver {

    fun onTextChanged(oldValue: String, newValue: String)
}

class NameChangeObserver : TextChangeObserver {
    override fun onTextChanged(oldValue: String, newValue: String) {
        println("Name changed from $oldValue to $newValue")
    }
}

class UserName(observer: TextChangeObserver, initValue: String = "No name recorded") {
    var name: String by Delegates.observable(initValue) { _, old, new ->
        if (old != new) {
            observer.onTextChanged(old, new)
        }
    }
}

class Profile {

    private val _userName = UserName(NameChangeObserver())

    fun assignNewName(newName: String) {
        _userName.name = newName
    }
}