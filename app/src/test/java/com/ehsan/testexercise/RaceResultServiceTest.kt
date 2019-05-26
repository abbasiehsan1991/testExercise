package com.ehsan.testexercise

import com.ehsan.testexercise.d.Client
import com.ehsan.testexercise.d.Message
import com.ehsan.testexercise.d.RaceResultService
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

/**
 * Created by Ehsan Joon for TestExercise at 4/29/19
 */
class RaceResultServiceTest{

    @Test
    fun subscribedClientShouldReceiveMessage(){

        /**
         * This is our System Under Test (SUT)
         * We don't create Mock of it, Ok?!!!!
         */
        val raceResultService  = RaceResultService()


        val mClient = mock(Client::class.java)//Spy

        /**
         * message object - is a dummy.
         * Its behaviour is not verified, and the SUT does not require message to return any information.
         * It is only being passed between other objects.
         */
        val mMessage = mock(Message::class.java)//Dummy

        raceResultService.addSubscriber(mClient)

        raceResultService.send(mMessage)


        /**
         * The verification part below clearly indicates that the client test double is a test spy.
         * Its behaviour is verified after the execution of the tested code.
         */
        Mockito.verify(mClient).receive(mMessage)
    }

    @Test
    fun messageShouldSendToAllSubscribers(){

        val raceResultService = RaceResultService()

        val clientA = Mockito.mock(Client::class.java)
        val clientB = Mockito.mock(Client::class.java)
        val message = Mockito.mock(Message::class.java)

        raceResultService.addSubscriber(clientA)
        raceResultService.addSubscriber(clientB)


        raceResultService.send(message)

        Mockito.verify(clientA).receive(message)
        Mockito.verify(clientB).receive(message)
    }

}