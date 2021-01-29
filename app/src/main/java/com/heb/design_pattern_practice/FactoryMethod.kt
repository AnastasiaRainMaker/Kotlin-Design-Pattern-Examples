package com.heb.design_pattern_practice

object ColorFactory {

    fun generateColor(fruit: Fruit) =
        when (fruit) {
            is Pear -> "YELLOW"
            is Orange -> "ORANGE"
            is Watermelon -> "GREEN"
            else -> "NO COLOR"
        }
}

abstract class Fruit {
    abstract val color: String
}

class Pear : Fruit() {
    override val color: String
        get() = ColorFactory.generateColor(this)
}

class Orange : Fruit() {
    override val color: String
        get() = ColorFactory.generateColor(this)
}

class Watermelon : Fruit() {
    override val color: String
        get() = ColorFactory.generateColor(this)
}

class Farm {

    fun collectFruit() {
        println(Pear())
        println(Orange())
        println(Watermelon())
    }

}