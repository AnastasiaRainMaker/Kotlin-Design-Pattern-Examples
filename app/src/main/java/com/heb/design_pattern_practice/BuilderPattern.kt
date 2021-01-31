package com.heb.design_pattern_practice

class Vacation(builder: VacationBuilder) {

    private var hotel: String = ""
    private var excursions: List<String> = listOf()
    private var cuisine: List<String> = listOf()

    init {
        hotel = builder.hotel
        excursions = builder.excursions
        cuisine = builder.cuisine
    }

    override fun toString(): String =
        "hotel is $hotel, excursions are ${excursions.joinToString(",")}, cuisine types are ${cuisine.joinToString(",")}"

    class VacationBuilder {

        var hotel: String = ""
        var excursions: List<String> = listOf()
        var cuisine: List<String> = listOf()

        fun hotel(value: String): VacationBuilder {
            this.hotel = value
            return this
        }

        fun excursions(value: List<String>): VacationBuilder {
            this.excursions = value
            return this
        }

        fun cuisine(value: List<String>): VacationBuilder {
            this.cuisine = value
            return this
        }

        fun build(): Vacation = Vacation(this)
    }
}

fun main() {

    println(
        Vacation.VacationBuilder()
            .hotel("La Quinta")
            .excursions(arrayListOf("Tropical"))
            .cuisine(arrayListOf("Mexican", "Italian"))
            .build()
            .toString()
    )
    // result is
    // hotel is La Quinta, excursions are Tropical, cuisine types are Mexican,Italian
}
