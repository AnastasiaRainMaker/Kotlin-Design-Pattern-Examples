package com.heb.design_pattern_practice

import java.util.*

class Printer(var formatStrategy: ((String) -> String)? = null) {

    fun print(input: String) {
        println(formatStrategy?.let { it(input) })
    }
}

fun main() {
    val printer = Printer { it.toLowerCase(Locale.getDefault()) }
    printer.formatStrategy = { it.toLowerCase(Locale.getDefault()) }
    printer.print("My Receipt")
    printer.formatStrategy = { it.toUpperCase(Locale.getDefault()) }
    printer.print("My Receipt")

    //result
    //my receipt
    //MY RECEIPT
}

