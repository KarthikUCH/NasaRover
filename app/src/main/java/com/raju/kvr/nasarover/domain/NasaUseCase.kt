package com.raju.kvr.nasarover.domain

class NasaUseCase {

    fun findPlateau(width: Int): Plateau {
        return Plateau(width)
    }

    fun landRoverInPlateau(position: String, plateau: Plateau): Rover {
        val coordinates = getCoordinatesFromPosition(position)
        val facingDirection = Rover.directions[position.getOrNull(2)] ?: Direction.E
        return Rover(coordinates.first, coordinates.second, facingDirection, plateau)
    }

    fun navigateRover(rover: Rover, instruction: String): String {
        rover.navigateTo(instruction)
        return rover.getCurrentPosition()
    }

    private fun getCoordinatesFromPosition(position: String): Pair<Int, Int> {
        val x = position.getOrNull(0)?.digitToIntOrNull() ?: 0
        val y = position.getOrNull(1)?.digitToIntOrNull() ?: 0
        return x to y
    }
}