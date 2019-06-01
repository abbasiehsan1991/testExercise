package com.ehsan.testexercise.c

/**
 *
 *Created by Ehsan Abbasi for TestExercise at 5/19/19
 *
 */
class TemplateEngine{

    fun prepareMessage(template: Template, client: Client) :String{
        return "This is a sample message that prepared fot Email [${client.getEmail()}]"
    }
}