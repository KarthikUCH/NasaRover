package com.raju.kvr.nasarover.domain

class Rover(
    private var xCoordinate: Int,
    private var yCoordinate: Int,
    private var facing: Direction,
    private val plateau: Plateau
) {

    companion object {
        val instructions = mapOf(
            'M' to MoveForward,
            'R' to TurnRight,
            'L' to TurnLeft
        )

        val directions = mapOf(
            'E' to Direction.E,
            'W' to Direction.W,
            'N' to Direction.N,
            'S' to Direction.S
        )
    }

    fun navigateTo(movement: String) {
        for (ch: Char in movement) {
            when (instructions[ch]) {
                is MoveForward -> {
                    if (plateau.canMoveForward(facing, xCoordinate, yCoordinate)) {
                        moveForward()
                    }
                }

                is TurnRight -> {
                    facing = facing.turnRight()
                }

                is TurnLeft -> {
                    facing = facing.turnLeft()
                }

                null -> {
                    // Do Nothing
                }
            }
        }
    }

    fun getCurrentPosition(): String {
        return "$xCoordinate$yCoordinate${facing.name}"
    }

    private fun moveForward() {
        when (facing) {
            Direction.E -> {
                xCoordinate++
            }

            Direction.W -> {
                xCoordinate--
            }

            Direction.N -> {
                yCoordinate++
            }

            Direction.S -> {
                yCoordinate--
            }
        }
    }


}