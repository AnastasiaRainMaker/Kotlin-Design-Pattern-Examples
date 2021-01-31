package com.heb.design_pattern_practice

interface IPrinterMachine {

    fun printDocument(document: String)
}

class BasePrinterMachine : IPrinterMachine {
    override fun printDocument(document: String) {
        println("Base printing document -> $document")
    }
}

class UpgradedPrinterMachine(private val printer: IPrinterMachine) : IPrinterMachine {

    override fun printDocument(document: String) {
        println("Document received for printing")
        printer.printDocument(document)
        println("Sending the document to default email")
    }
}

class Document {

    private val contents: String = "Document contents"
    private val basePrinter = BasePrinterMachine()
    private val upgradedPrinter = UpgradedPrinterMachine(basePrinter)

    fun submitForRegularPrinting() {
        basePrinter.printDocument(contents)
    }

    fun submitForEnhancedPrinting() {
        upgradedPrinter.printDocument(contents)
    }
}

fun main() {
    val document = Document()

    document.submitForRegularPrinting()
    document.submitForEnhancedPrinting()

    //result:
    //Base printing document -> Document contents
    //Document received for printing
    //Base printing document -> Document contents
    //Sending the document to default email
}
