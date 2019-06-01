package com.ehsan.testexercise.b

import com.ehsan.testexercise.b.FootballTeam
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
    private val ANY_NUMBER = 125


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
    fun constructorShouldThrowExceptionForIllegalNbOfGamesWon(illegalNbOfGameWon: Int) {

        val team = FootballTeam(illegalNbOfGameWon)
    }

    @Test
    fun shouldBePossibleToCompareTeams() {

        val team = FootballTeam(ANY_NUMBER)
        assertTrue("FootballTeam should implement Comparable" , team is Comparable<*>)
    }


    @Test
    fun teamWithMoreMatchWonShouldBeGreater() {
        val team1 = FootballTeam(50)
        val team2 = FootballTeam(20)

        assertTrue(
            "team with ${team1.getGamesWon()} won number must be greater than with a team with ${team2.getGamesWon()} won in a compare",
            team1 > team2
        )
    }

    @Test
    fun teamsWithSameNumberOfWonGamesShouldBeEqual() {
        val teamA = FootballTeam(2)
        val teamB = FootballTeam(2)

        assertTrue(
            "Team A with ${teamA.getGamesWon()} number of won games should be equal with Team B with ${teamB.getGamesWon()} number of won games",
            teamA.compareTo(teamB) == 0
        )
    }

}