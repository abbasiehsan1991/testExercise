package com.ehsan.testexercise

/**
 *
 *Created by Ehsan Joon for TestExercise at 4/6/19
 *
 */
class FootballTeam(private val gamesWon: Int) : Comparable<FootballTeam> {
    init {
        if(gamesWon<0)
            throw IllegalArgumentException("Oops Don't do that to me !!!!!")
    }

    /**
     * Compares this object with the specified object for order. Returns zero if this object is equal
     * to the specified [otherTeam] object, a negative number if it's less than [otherTeam], or a positive number
     * if it's greater than [otherTeam].
     */
    override fun compareTo(otherTeam: FootballTeam): Int {

        return when {
            gamesWon > otherTeam.gamesWon -> 1 //Winner :)
            gamesWon < otherTeam.getGamesWon() -> -1 //Looser :(
            else -> 0 //Equal :|
        }
    }

    fun getGamesWon(): Int {
        return gamesWon
    }
}
