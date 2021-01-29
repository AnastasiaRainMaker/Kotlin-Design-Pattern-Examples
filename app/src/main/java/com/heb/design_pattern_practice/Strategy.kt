package com.heb.design_pattern_practice

import java.util.*


class Printer(private val formatStrategy: (String) -> String) {

    fun print(input: String) {
        println(formatStrategy(input))
    }
}

class LowerCaseReceiptPrinter {

    private val _printer = Printer { it.toLowerCase(Locale.getDefault()) }

    fun triggerReceiptPrinting(receiptPayLoad: String) {
        _printer.print(receiptPayLoad)
    }
}

class UpperCaseReceiptPrinter {

    private val _printer = Printer { it.toUpperCase(Locale.getDefault()) }

    fun triggerReceiptPrinting(receiptPayLoad: String) {
        _printer.print(receiptPayLoad)
    }
}

class Checkout {

    private val _lowerCaseReceiptPrinter = LowerCaseReceiptPrinter()
    private val _upperCaseReceiptPrinter = UpperCaseReceiptPrinter()

    fun finalizeOrder(useLowerCase: Boolean = false) {
        if (useLowerCase)
            _lowerCaseReceiptPrinter.triggerReceiptPrinting("My Receipt")
        else
            _upperCaseReceiptPrinter.triggerReceiptPrinting("My Receipt")
    }
}

