package com.ehsan.testexercise.c

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/30/19
 *
 */
interface Client {

    fun receive(message: Messenger)

    fun getEmail ():String{
        return ""
    }
}