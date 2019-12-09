package com.ehsan.testexercise.e

import org.junit.Assert
import org.junit.Test

/**
 * Created by Ehsan Abbasi for TestExercise at 6/9/19
 */
class ClientTest {

    companion object {

        private const val ANY_NUMBER = "912-2222-116"

        /**
         * Real objects are created to be used by the SUT. Both
         */
        private val MOBILE_PHONE = Phone(ANY_NUMBER, true)
        private val STATIONARY_PHONE = Phone(ANY_NUMBER, false)

    }

    private val client = Client() //SUT


    @Test
    fun shouldReturnTrueIfClientHasMobile() {

        client.addPhone(MOBILE_PHONE)

        Assert.assertTrue(
            "set a mobileNumber for client so hadMobile() must return [true] but it returned [false] !!!",
            client.hasMobile()
        )

    }

    @Test
    fun shouldReturnFalseIfClientHasNoMobile() {

        client.addPhone(STATIONARY_PHONE)

        Assert.assertFalse(
            "set a mobileNumber for client so hadMobile() must return [false] but it returned [true] !!!",
            client.hasMobile()
        )

    }

}
