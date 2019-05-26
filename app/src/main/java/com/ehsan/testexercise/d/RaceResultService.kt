package com.ehsan.testexercise.d

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/30/19
 *
 */
class RaceResultService {

    private lateinit var client : Client

    fun addSubscriber(mClient: Client) {
        this.client = mClient
    }

    fun send(mMessage: Message) {
        client.receive(mMessage)
    }

}