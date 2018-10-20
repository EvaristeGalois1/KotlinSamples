package com.georgcantor.kotlinsamples.riddles.utils

import com.georgcantor.kotlinsamples.riddles.model.Player

class UtilRx {

    fun footballPLayers(): ArrayList<Player> {

        val list = ArrayList<Player>()

        val playerOne = Player()
        playerOne.firstName = "Tom"
        playerOne.lastName = "Dwain"
        list.add(playerOne)

        val playerTwo = Player()
        playerTwo.firstName = "Danny"
        playerTwo.lastName = "Lawrence"
        list.add(playerTwo)

        return list
    }

    fun hockeyPlayers(): ArrayList<Player> {

        val list = ArrayList<Player>()

        val playerOne = Player()
        playerOne.firstName = "Anthony"
        playerOne.lastName = "Dwain"
        list.add(playerOne)

        val playerTwo = Player()
        playerTwo.firstName = "Sean"
        playerTwo.lastName = "Smith"
        list.add(playerTwo)

        return list
    }

    fun filterNamesakes(footballPlayers: ArrayList<Player>, hockeyPlayers: ArrayList<Player>) {
        val namesakes = ArrayList<Player>()

        for (footballPlayer in footballPlayers) {
            for (hockeyPlayer in hockeyPlayers) {
                if (footballPlayer.lastName === hockeyPlayer.lastName) {
                    namesakes.add(footballPlayer)
                }
            }
        }
    }
}