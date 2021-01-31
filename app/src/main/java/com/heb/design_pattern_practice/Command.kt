package com.heb.design_pattern_practice

interface OrderCommand {
    fun execute()
}

class AddToOrderCommand(private val product: String) : OrderCommand {
    override fun execute() {
        println("Added $product")
    }
}

class RemoveFromOrderCommand(private val product: String) : OrderCommand {
    override fun execute() {
        println("Removing $product")
    }
}

class CommandProcessor {
    private val queue = ArrayList<OrderCommand>()

    fun enqueueCommand(command: OrderCommand): CommandProcessor {
        queue.add(command)
        return this
    }

    fun processCommands(): CommandProcessor {
        queue.forEach {
            it.execute()
        }
        queue.clear()
        return this
    }
}

fun main() {
    CommandProcessor()
        .enqueueCommand(AddToOrderCommand("Bread"))
        .enqueueCommand(AddToOrderCommand("Onions"))
        .enqueueCommand(AddToOrderCommand("Coke"))
        .enqueueCommand(RemoveFromOrderCommand("Coke"))
        .processCommands()

    //result
    //Added Bread
    //Added Onions
    //Added Coke
    //Removing Coke
}