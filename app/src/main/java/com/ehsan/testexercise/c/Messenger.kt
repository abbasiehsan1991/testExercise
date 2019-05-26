package com.ehsan.testexercise.c

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/30/19
 *
 * our class is a manager, as it tells others what to do rather than getting its own hands dirty.
 *
 */
class Messenger(private val templateEngine: TemplateEngine,private val mailServer: MailServer) {

    /**
     * This method returns void, and does not change the state of the Messenger object,
     * which means there is no way we can test it using the state-testing approach.
     * It does not return anything, so the results of its work cannot be directly observed.
     *                      -----------------------------------------
     * Solution:
     *   we can verify only one thing:
     *   whether the send() method of mailServer is invoked
     *   with the same argument value as that provided by the client parameter and by the templateEngine collaborator.
     *
     * @param template : DUMMY
     *                   This is  an Dummy object in our test
     *                   We can create it with:
     *
     *                          ```Template template = mock(Template.class);```
     *
     * templateEngine: STUB (This is an indirect input to the method)
     *                 With Mockito’s when() method We will tell to the STUB what we will want to return
     *                 to us.
     *
     */
    fun sendMessage(client: Client, template: Template):Unit {

        val msgContent = templateEngine.prepareMessage(template, client)

        mailServer.send(client.getEmail(), msgContent)
    }

}