package com.heb.design_pattern_practice

class Student(private val name: String) {

    fun goOnExcursion() {
        println("$name is going on excursion")
    }
}

class Class(private val students: List<Student>) {

    fun takeClassToExcursion() {
        students.forEach { it.goOnExcursion() }
    }
}

class Implementation {

    private val _class = Class(listOf(Student("Mary"), Student("Victor")))

    fun organizeExcursionDay() {
        _class.takeClassToExcursion()
    }
}