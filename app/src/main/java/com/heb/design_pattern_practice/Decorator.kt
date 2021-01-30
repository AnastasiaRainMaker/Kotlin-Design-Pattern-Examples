package com.heb.design_pattern_practice

interface PrinterMachine {

    fun printDocument(document: String)
}

class BasePrinterMachine : PrinterMachine {
    override fun printDocument(document: String) {
        println("Printing black and white document -> $document")
    }
}

class UpgradedPrinterMachine(private val printer: PrinterMachine) : PrinterMachine {
    override fun printDocument(document: String) {
        printer.printDocument(document)
    }

    fun printColorCopy(document: String) {
        println("Upgraded printer is printing a colored version in addition -> $document")
    }
}

class Document {

    private val _contents: String = "Document contents"
    private val _basePrinter = BasePrinterMachine()
    private val _upgradedPrinter = UpgradedPrinterMachine(_basePrinter)

    fun submitForRegularPrinting() {
        _basePrinter.printDocument(_contents)
    }

    fun submitForEnhancedPrinting() {
        _upgradedPrinter.printDocument(_contents)
        _upgradedPrinter.printColorCopy(_contents)
    }
}
