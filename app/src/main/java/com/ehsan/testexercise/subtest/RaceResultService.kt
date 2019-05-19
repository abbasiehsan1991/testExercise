package com.ehsan.testexercise.subtest

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/30/19
 *
 */
class RaceResultService {

    lateinit var client:Client

    fun addSubscriber(client: Client){
        this.client = client
    }

    fun send(message: Messenger){
        client.receive(message)
    }

}