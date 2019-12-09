package com.ehsan.testexercise.e

/**
 *
 *Created by Ehsan Abbasi for TestExercise at 6/10/19
 *
 * A More Complicated Example of [Phone]
 * Now we want to see is that ok to create real [Phone] to test [Client] like before or not?!
 * Let's find it out .....
 */
class PhoneSmart(private val number: String) {

    private var mobile: Boolean = false

    init {

        /**
         * Do not do this at home! This is surely not a valid way to recognize mobile phone numbers!
         */
        mobile = number.startsWith("+") && number.endsWith("9")

    }

    fun isMobile(): Boolean {
        return mobile
    }

}

