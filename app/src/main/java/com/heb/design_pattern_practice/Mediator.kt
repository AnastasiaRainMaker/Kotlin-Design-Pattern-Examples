package com.heb.design_pattern_practice

class User(private val chatMediator: ChatMediator? = null, private val name: String) {

    fun send(message: String) {
        chatMediator?.send("Message from $name -> $message", this)
    }

    fun receive(message: String) {
        println("$name received $message")
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

class GroupChat(vararg users: User, charMediator: ChatMediator) {

    init {
        charMediator.addUserToChat(*users)
    }

    fun sendMessageToGroup(user: User) {
        user.send("Hi, there!")
    }

}

fun main() {
    val charMediator = ChatMediator()
    val john = User(charMediator, "John")
    val groupChat = GroupChat(
        john,
        User(charMediator, "Katy"),
        User(charMediator, "Lucy"),
        charMediator = charMediator
    )
    groupChat.sendMessageToGroup(john)

    //result
    //Katy received Message from John -> Hi, there!
    //Lucy received Message from John -> Hi, there!
}
