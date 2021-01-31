package com.heb.design_pattern_practice

class CarPlantFacade {

    fun orderCar(): Car =
        Car(
            wheels = WheelSupplier().provideWheels(),
            parts = PartSupplier().provideParts()
        ).apply { PaintingFacility().paintCar() }
}

data class Car(
    val wheels: ArrayList<WheelSupplier.Wheel>,
    val parts: ArrayList<PartSupplier.CarPart>
)

class WheelSupplier {

    class Wheel

    fun provideWheels(): ArrayList<Wheel> {
        println("Ordering wheels")
        return arrayListOf(Wheel(), Wheel(), Wheel(), Wheel())
    }
}

class PaintingFacility {

    fun paintCar() {
        println("Painting the car")
    }
}

class PartSupplier {

    open class CarPart
    class Engine : CarPart()
    class Breaks : CarPart()
    class Headlights : CarPart()

    fun provideParts(): ArrayList<CarPart> {
        println("Ordering car parts")
        return arrayListOf(
            Engine(),
            Breaks(),
            Headlights()
        )
    }
}

fun main() {
    CarPlantFacade().orderCar()
    println("The car was delivered")

    //result
    //Ordering wheels
    //Ordering car parts
    //Painting the car
    //The car was delivered
}



