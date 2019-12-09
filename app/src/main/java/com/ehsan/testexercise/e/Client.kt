package com.ehsan.testexercise.e

/**
 *
 *Created by Ehsan Abbasi for TestExercise at 6/9/19
 *
 */
class Client {

    private var phones = ArrayList<Phone>()

    fun addPhone(phone: Phone){

        phones.add(phone)

    }

    fun hasMobile():Boolean{

        phones.find { phone -> phone.isMobile() }.apply {

            this?.let { return true }
        }

        return false
    }

}