package com.heb.design_pattern_practice

interface IVisitor {
    fun visit(machine: IWashingMachine)
}

interface IWashingMachine {
    fun heatWater(degrees: Int)
    fun wash(minutes: Int)
    fun spin(minutes: Int)
}

class Shirt : IVisitor {
    override fun visit(machine: IWashingMachine) {
        println("Entering shirt washing mode...")
        machine.heatWater(40)
        machine.wash(10)
        machine.spin(5)
    }
}

class Pillow : IVisitor {
    override fun visit(machine: IWashingMachine) {
        println("Entering pillow washing mode...")
        machine.heatWater(60)
        machine.wash(20)
        machine.spin(10)
    }
}

class WashingMachine : IWashingMachine {
    override fun heatWater(degrees: Int) {
        println("Heating water to $degrees")
    }

    override fun wash(minutes: Int) {
        println("Washing for $minutes minutes")
    }

    override fun spin(minutes: Int) {
        println("Spinning for $minutes minutes")
    }

}

fun main() {
    val washingMachine = WashingMachine()
    Shirt().visit(washingMachine)
    Pillow().visit(washingMachine)
    //result
    //Entering shirt washing mode...
    //Heating water to 40
    //Washing for 10 minutes
    //Spinning for 5 minutes
    //Entering pillow washing mode...
    //Heating water to 60
    //Washing for 20 minutes
    //Spinning for 10 minutes
}