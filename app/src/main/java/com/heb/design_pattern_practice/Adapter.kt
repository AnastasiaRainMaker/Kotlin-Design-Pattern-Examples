package com.heb.design_pattern_practice

class TimeAdapter {

    fun convertToSec(timeInMls: Long) = timeInMls / 1000
}

typealias TimeInSeconds = Long
typealias TimeInMillisec = Long

class Watch(private val adapter: TimeAdapter) {

    fun showTimeInSeconds(timeInSec: TimeInSeconds? = null, timeInMls: TimeInMillisec? = null) {
        timeInMls?.let { println("Showing time in sec -> ${adapter.convertToSec(timeInMls)}") }
        timeInMls?.let { println("Showing time in sec -> $timeInSec") }
    }

}