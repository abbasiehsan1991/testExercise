package com.ehsan.testexercise.e

import org.junit.Assert
import org.junit.Test

/**
 * Created by Ehsan Abbasi for TestExercise at 6/10/19
 *
 * This version of the [ClientTest] class is coupled with the implementation of the [PhoneSmart] class.
 * If the pattern matching mechanism used in the [PhoneSmart] constructor changes,
 * the test code will also need to change.
 * The SRP principle has clearly been breached,
 * because this test class is also coupled with the [ClientWithPhoneSmart] class implementation
 * (so [ClientWithPhoneSmartTest] has more than one reason to change).
 *
 */
class ClientWithPhoneSmartTest{

    private val MOBILE_PHONE = PhoneSmart("+123456789")
    private val STATIONARY_PHONE = PhoneSmart("12345678")

    private val client = ClientWithPhoneSmart() //SUT

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