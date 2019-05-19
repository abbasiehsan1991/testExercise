package com.ehsan.testexercise

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/17/19
 *
 * Let us imagine that our SUT uses a DOC of type Car
 */
interface Car {

    fun needFuel(): Boolean
    fun getEngineTemperature(): Double
    fun driveTo(destination: String)

}