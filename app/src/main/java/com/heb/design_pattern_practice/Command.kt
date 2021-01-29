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

    fun enqueueCommand(command: OrderCommand) {
        queue.add(command)
    }

    fun bulkEnqueue(commands: List<OrderCommand>) {
        queue.addAll(commands)
    }

    fun processCommands(): CommandProcessor {
        queue.forEach {
            it.execute()
        }
        queue.clear()
        return this
    }
}

class OrderHandler {

    private val _commandProcessor = CommandProcessor()

    fun addToOrder(product: String) {
        _commandProcessor.enqueueCommand(AddToOrderCommand(product))
    }

    fun removeFromOrder(product: String) {
        _commandProcessor.enqueueCommand(RemoveFromOrderCommand(product))
    }

    fun bulkAdd(commands: List<OrderCommand>) {
        _commandProcessor.bulkEnqueue(commands)
    }

    fun finalizeOrder() {
        _commandProcessor.processCommands()
    }
}