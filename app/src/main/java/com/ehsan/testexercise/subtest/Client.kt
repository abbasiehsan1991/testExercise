package com.ehsan.testexercise.subtest

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/30/19
 *
 */
public interface Client {

    fun receive(message:Messenger)

    fun getEmail ():String{
        return ""
    }
}