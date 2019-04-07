package com.ehsan.testexercise

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Test
import org.junit.runner.RunWith


/**
 *
 *Created by Ehsan Joon for TestExercise at 4/6/19
 *
 */
@RunWith(JUnitParamsRunner::class)
class FootballTeamTest {

    companion object {

        private const val ANY_NUMBER = 123

    }

    fun nbOfGamesWon(): Array<Any> {
        return arrayOf(0, 1, 2)
    }

    @Test
    @Parameters(method = "nbOfGamesWon")
    fun constructorShouldSetGameWon(nbOfGameWon: Int) {

        val team = FootballTeam(nbOfGameWon)
        assertEquals(
            "$nbOfGameWon games passed to the constructor but ${team.getGamesWon()} is returned",
            nbOfGameWon, team.getGamesWon()
        )
    }

    fun illegalNbOfGamesWon(): Array<Any> {
        return arrayOf(-1, -10)
    }

    @Test(expected = IllegalArgumentException::class)
    @Parameters(method = "illegalNbOfGamesWon")
    fun constructorShouldThrowExceptionsForIllegalGameNb(illegalNumber: Int) {
        FootballTeam(illegalNumber)
    }

    @Test
    fun teamWithMoreMatchWonShouldBeGreater() {
        val team_1 = FootballTeam(50)
        val team_2 = FootballTeam(20)

        assertTrue(
            "team with ${team_1.getGamesWon()} won number must be greater than with a team with ${team_2.getGamesWon()} won in a compare",
            team_1 > team_2
        )
    }

    @Test
    fun teamsWithSameNumberOfWonGamesShouldBeEqual() {
        val teamA = FootballTeam(2)
        val teamB = FootballTeam(2)

        assertTrue("Team A with ${teamA.getGamesWon()} number of won games should be equal with Team B with ${teamB.getGamesWon()} number of won games",
            teamA.compareTo(teamB) == -1)
    }


}