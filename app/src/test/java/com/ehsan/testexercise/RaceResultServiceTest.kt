package com.ehsan.testexercise

import com.ehsan.testexercise.subtest.Client
import com.ehsan.testexercise.subtest.Messenger
import com.ehsan.testexercise.subtest.RaceResultService
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by Ehsan Joon for TestExercise at 4/29/19
 */
class RaceResultServiceTest{

    @Test
    fun subscribedClientShouldReceiveMessage(){

        val raceResultService  = RaceResultService() //The SUB
        val mClient = mock(Client::class.java)//Spie
        val mMessage = mock(Messenger::class.java)//Double it doesn't do any thing and using just for passing between SUB and DOC.

        raceResultService.addSubscriber(mClient)
        raceResultService.send(mMessage)

        verify(mClient).receive(mMessage) //making sure that the subscribed client has received the message.
    }

}