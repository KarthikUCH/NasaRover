package com.raju.kvr.nasarover.domain

class NasaUseCase {

    fun findPlateau(width: Int): Plateau {
        return Plateau(width)
    }

    fun landRoverInPlateau(position: String, plateau: Plateau): Rover {
        val x = position[0].digitToIntOrNull() ?: 0
        val y = position[1].digitToIntOrNull() ?: 0
        val facingDirection = Rover.directions[position[2]] ?: Direction.E
        return Rover(x, y, facingDirection, plateau)
    }

    fun navigateRover(rover: Rover, instruction: String): String {
        rover.navigateTo(instruction)
        return rover.getCurrentPosition()
    }
}