package com.ehsan.testexercise.subtest

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/30/19
 *
 * our class is a manager, as it tells others what to do rather than getting its own hands dirty.
 *
 */
public class Messenger(val templateEngine: TemplateEngine, val mailServer: MailServer) {

    /**
     * This method returns void, and does not change the state of the Messenger object,
     * which means there is no way we can test it using the state-testing approach.
     */
    fun sendMessage(client: Client, template: Template) {

        val msgContent = templateEngine.prepareMessage(template, client)

        mailServer.send(client.getEmail(), msgContent)

    }

}