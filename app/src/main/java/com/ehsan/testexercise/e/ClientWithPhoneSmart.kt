package com.ehsan.testexercise.e

/**
 *
 *Created by Ehsan Abbasi for TestExercise at 6/9/19
 *
 */
class ClientWithPhoneSmart {

    private var phones = ArrayList<PhoneSmart>()

    fun addPhone(phone: PhoneSmart){

        phones.add(phone)

    }

    fun hasMobile():Boolean{

        phones.find { phone -> phone.isMobile() }.apply {

            this?.let { return true }
        }

        return false
    }

}