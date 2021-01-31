package com.heb.design_pattern_practice

abstract class Fruit {
    abstract val color: String
}

class Pear : Fruit() {
    override val color: String
        get() = "YELLOW"

    override fun toString(): String = "Pear of color $color"
}

class Orange : Fruit() {
    override val color: String
        get() = "ORANGE"

    override fun toString(): String = "Orange of color $color"
}

class Watermelon : Fruit() {
    override val color: String
        get() = "GREEN"

    override fun toString(): String = "Watermelon of color $color"
}

object FruitFactory {

    fun growFruit(color: String): Fruit? =
        when (color) {
            "YELLOW" -> Pear()
            "ORANGE" -> Orange()
            "GREEN" -> Watermelon()
            else -> null
        }
}

class Farm {

    fun growHarvest() {
        with(FruitFactory) {
            println(
                growFruit("YELLOW")
            )
            println(
                growFruit("ORANGE")
            )
            println(
                growFruit("GREEN")
            )
        }
    }

}

fun main() {
    Farm().growHarvest()
    //result
    //Pear of color YELLOW
    //Orange of color ORANGE
    //Watermelon of color GREEN
}