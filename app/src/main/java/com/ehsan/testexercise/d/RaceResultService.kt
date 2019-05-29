package com.ehsan.testexercise.d

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/30/19
 *
 */
class RaceResultService {

    private val clients = ArrayList<Client>()

    fun addSubscriber(mClient: Client) {
        clients.add(mClient)
    }

    fun send(mMessage: Message) {

        for ( client in clients){

            client.receive(mMessage)

        }

    }
}