package com.ehsan.testexercise

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/6/19
 *
 */
class FootballTeam(private val gamesWon: Int) : Comparable<FootballTeam> {

    /**
     * Compares this object with the specified object for order. Returns zero if this object is equal
     * to the specified [otherTeam] object, a negative number if it's less than [otherTeam], or a positive number
     * if it's greater than [otherTeam].
     */
    override fun compareTo(otherTeam: FootballTeam): Int {

        return when {
            gamesWon > otherTeam.gamesWon -> 1
            gamesWon < otherTeam.getGamesWon() -> -1
            else -> 0
        }
    }

    fun getGamesWon(): Int {
        return gamesWon
    }
}
