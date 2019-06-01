package com.ehsan.testexercise.c

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/30/19
 *
 */
interface Client {

    fun receive(message: Messenger){
        //Do anything that you want :)
    }

    fun getEmail ():String{
        return "sample@Email.com"
    }
}