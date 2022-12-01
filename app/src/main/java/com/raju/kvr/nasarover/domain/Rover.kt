package com.raju.kvr.nasarover.domain

class Rover(
    private var xCoordinate: Int,
    private var yCoordinate: Int,
    private var facing: Direction,
    private val plateau: Plateau
) {

    private val instructions = mapOf(
        'M' to MoveForward,
        'R' to TurnRight,
        'L' to TurnLeft
    )

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

    fun getCurrentPosition(): String{
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