package com.heb.design_pattern_practice

class User(private val chatMediator: ChatMediator, val name: String) {

    fun send(message: String) {
        chatMediator.send("Message from $name -> $message", this)
    }

    fun receive(message: String) {
        println("Message received $message")
    }
}

class ChatMediator {

    private val users: MutableList<User> = ArrayList()

    fun send(message: String, user: User) {
        users
            .filter { it != user }
            .forEach {
                it.receive(message)
            }
    }

    fun addUserToChat(vararg user: User) {
        users.addAll(user)
    }
}

class GroupChat {

    private val _charMediator = ChatMediator()

    init {
        _charMediator.addUserToChat(
            User(_charMediator, "John"),
            User(_charMediator, "Katy"),
            User(_charMediator, "Lucy"),
        )
    }

    fun sendMessageToGroup(user: User) {
        user.send("Hi, there!")
    }

}
