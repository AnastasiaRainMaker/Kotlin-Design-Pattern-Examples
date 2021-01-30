package com.heb.design_pattern_practice

abstract class Plant {
    abstract fun produce()
}

class CarPlant : Plant() {
    override fun produce() {
        println("Producing a car")
    }
}

class ComputerPlant : Plant() {
    override fun produce() {
        println("Producing a computer")
    }
}

abstract class PlantFactory {

    abstract fun makePlant(): Plant

    companion object {
        inline fun <reified T : Plant> createFactory(): PlantFactory? =
            when (T::class) {
                CarFactory::class -> CarFactory()
                ComputerFactory::class -> ComputerFactory()
                else -> null
            }
    }
}

class CarFactory : PlantFactory() {
    override fun makePlant(): Plant = CarPlant()
}

class ComputerFactory : PlantFactory() {
    override fun makePlant(): Plant = ComputerPlant()
}

class OrderManufacturer {

    private val carPlantFactory = PlantFactory.createFactory<CarPlant>()
    private val computerPlantFactory = PlantFactory.createFactory<ComputerPlant>()

    private val carPlant = carPlantFactory?.makePlant()
    private val computerPlant = computerPlantFactory?.makePlant()

    fun orderCar() = carPlant?.produce()

    fun orderComputer() = computerPlant?.produce()
}
