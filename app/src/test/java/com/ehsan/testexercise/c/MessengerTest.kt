package com.ehsan.testexercise.c

import org.junit.Test
import org.mockito.Mockito


/**
 * Created by Ehsan Abbasi for TestExercise at 5/20/19
 */

class MessengerTest {

    private val MSG_SAMPLE = "THIS IS SAMPLE CONTENT"
    private val CLIENT_EMAIL = "SomeEmail@gmail.com"

    /**
     *
     */
    @Test
    fun sendMessageShouldInvokesSendFromMailServer() {


        val template = Mockito.mock(Template::class.java) // DUMMY

        val mailServer = Mockito.mock(MailServer::class.java)

        val client = Mockito.mock(Client::class.java) //STUB ->We need to get us an email

        val templateEngine =
            Mockito.mock(TemplateEngine::class.java) //STUB ->we need to get us an final message content

        /**
         *
         * Set behavior to our STUB with the power of mockito.
         *
         * "Whenever someone asks you to prepare a message with given template and client, please return the value of MSG_CONTENT"
         */
        Mockito.`when`(templateEngine.prepareMessage(template, client))
            .thenReturn(MSG_SAMPLE)

        val messenger = Messenger(templateEngine, mailServer)

    }

    /**
     *
     */
    @Test
    fun sendAndPrepareMessageShouldInvokeFromMailServerAndTemplateEngine() {


        val mailServer = Mockito.mock(MailServer::class.java)
        val templateEngine = Mockito.mock(TemplateEngine::class.java)
        val template = Mockito.mock(Template::class.java)
        val client = Mockito.mock(Client::class.java)

        val sut = Messenger(templateEngine, mailServer)

        /**
         * >>>>>> Stubbing of DOCs in order to satisfy the SUT!!!!! <<<<<<<<
         *
         *
         *
         * In our SUT [Messenger] class we gonna invoke
         * [TemplateEngine.prepareMessage] and [Client.getEmail] But ther is a problem here!!!!!
         * this two class are Mocked for us with Mockito.
         *
         * What they have to do when we execute them?
         *
         * We have to tell them the things that we want from them :)
         *
         * If we don't we will see some errors.
         */
        Mockito.`when`(client.getEmail()).thenReturn(CLIENT_EMAIL)
        Mockito.`when`(templateEngine.prepareMessage(template , client)).thenReturn(MSG_SAMPLE)

        /**
         *  >>>>>>> Execution of the SUT method. <<<<<<<<
         *
         *
         * Int the [Messenger.sendMessage] method
         * We are invoking two method that they are
         * [MailServer.send] and [TemplateEngine.prepareMessage]
         */
        sut.sendMessage(client, template)

        /**
         * >>>>>> Verification of the behaviour of the SUT <<<<<
         *
         * was the send() method invoked on mailServer DOC with the same CLIENT_EMAIL and MSG_CONTENT that were obtained from other collaborators?
         *
         *
         * we can use the test spy[MailServer.send] and [TemplateEngine] to actually verify the actions of the SUT that is [Messenger] class.
         * This is where real testing takes place: we check whether the SUT is behaving as we expect it to.
         */
        Mockito.verify(mailServer).send(CLIENT_EMAIL, MSG_SAMPLE)

        Mockito.verify(templateEngine).prepareMessage(template, client)
    }

}