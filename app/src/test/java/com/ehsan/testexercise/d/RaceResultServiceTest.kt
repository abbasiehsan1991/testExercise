package com.ehsan.testexercise.d

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import kotlin.concurrent.timer
import kotlin.text.Typography.times

/**
 * Created by Ehsan Joon for TestExercise at 4/29/19
 */
class RaceResultServiceTest {

    /**
     * This is our System Under Test (SUT)
     * We don't create Mock of it, Ok?!!!!
     */
    private val raceResultService = RaceResultService()

    private val clientA = Mockito.mock(Client::class.java)//Spy
    private val clientB = Mockito.mock(Client::class.java)//Spy

    /**
     * message object - is a dummy.
     * Its behaviour is not verified, and the SUT does not require message to return any information.
     * It is only being passed between other objects.
     */
    val message = Mockito.mock(Message::class.java)//Dummy

    @Test
    fun notSubscribedClientShouldNotReceiveAnyMessage() {

        raceResultService.send(message)

        /**
         * We did not subscribe [clientA] and [clientB]
         * So
         * They have not receive any message.
         */
        Mockito.verify(clientA, Mockito.never()).receive(message)
        Mockito.verify(clientB, Mockito.never()).receive(message)
    }


    @Test
    fun subscribedClientShouldReceiveMessage() {

        raceResultService.addSubscriber(clientA)
        raceResultService.send(message)

        /**
         * The verification part below clearly indicates that the client test double is a test spy.
         * Its behaviour is verified after the execution of the tested code.
         */
        Mockito.verify(clientA).receive(message)
    }

    @Test
    fun allSubscribedClientsShouldReceiveMessage() {

        raceResultService.addSubscriber(clientA)
        raceResultService.addSubscriber(clientB)

        raceResultService.send(message)

        Mockito.verify(clientA).receive(message)
        Mockito.verify(clientB).receive(message)
    }


    @Test
    fun shouldSendOnlyOneMessageToMultiSubscriber() {

        raceResultService.addSubscriber(clientA)
        raceResultService.addSubscriber(clientA)

        raceResultService.send(message)

        Mockito.verify(clientA, Mockito.times(1)).receive(message)
    }

    @Test
    fun unsubscribedClientShouldNotReceiveAnyMessage() {

        raceResultService.addSubscriber(clientA)

        raceResultService.removeSubscriber(clientA)

        raceResultService.send(message)

        Mockito.verify(clientA, Mockito.never()).receive(message)
    }


}
