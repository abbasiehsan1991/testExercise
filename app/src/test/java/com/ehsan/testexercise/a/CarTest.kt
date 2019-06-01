package com.ehsan.testexercise.a

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/17/19
 *
 */
class CarTest {

    private val EXPECTED_ENGIN_TEMPERATURE_AT_BEGINNING = 0.0
    private val myFerrari = mock(Car::class.java)

    @Test
    fun mockedCarIsACar() {
        assertTrue("mocked Car [$myFerrari] must be an instance of [${Car::class}]", myFerrari is Car)
    }

    @Test
    fun testDefaultBehaviorOfTestDouble() {

        assertFalse(myFerrari.needFuel())

        assertEquals(
            "$myFerrari 's engineTemperature should be $EXPECTED_ENGIN_TEMPERATURE_AT_BEGINNING at the beginning",
            EXPECTED_ENGIN_TEMPERATURE_AT_BEGINNING,
            myFerrari.getEngineTemperature(), 0.0
        )
    }

    /**
     * Let's say to our myFerrari to do what we say!!!
     */
    @Test
    fun textStubbingWithMyException() {

        assertFalse("need fuel should return false as default value", myFerrari.needFuel())

        /**
         * We are saying to mockito to return true if we ask you needFuel() from now
         */
        Mockito.`when`(myFerrari.needFuel()).thenReturn(true)

        assertTrue("need fuel should return true after telling mockito to set it's value as true", myFerrari.needFuel())
    }

 /*   @Test
    fun textStubbingMustThrowException() {

        Mockito.`when`(myFerrari.needFuel()).then(throw RuntimeException())
    }
*/
    /**
     * Checking has occurred of whether myFerrari has really been asked to drive to Alabama
     */
    @Test
    fun testVerifyDrive() {
        val currentDestination = "Go to Yara Or Google Now"
        myFerrari.driveTo(currentDestination)
        verify(myFerrari).driveTo(currentDestination)
    }

    @Test
    fun testVerifyNeedFuel() {
        myFerrari.needFuel()
        verify(myFerrari).needFuel()
    }

    @Test
    fun verifyMustFail(){

        myFerrari.needFuel()

        verify(myFerrari).getEngineTemperature()
    }

    @Test
    fun failedVerificationDifferentArgumentsTest(){

        myFerrari.driveTo("pls go to the city")

        verify(myFerrari).driveTo("pls go abroad")

    }

    @Test
    fun testDriveTo() {
        myFerrari.driveTo("")
        verify(myFerrari).driveTo("")
    }


}
