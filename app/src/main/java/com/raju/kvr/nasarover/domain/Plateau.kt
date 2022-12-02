package com.raju.kvr.nasarover.domain

class Plateau(val width: Int) {

    private val eastFacingMovementRange = 0 until width - 1
    private val northFacingMovementRange = eastFacingMovementRange;
    private val westFacingMovementRange = 1 until width
    private val southFacingMovementRange = westFacingMovementRange;

    fun canMoveForward(facingDirection: Direction, xCoordinate: Int, yCoordinate: Int): Boolean {
        return when (facingDirection) {
            Direction.E -> {
                return xCoordinate in eastFacingMovementRange
            }

            Direction.W -> {
                return xCoordinate in westFacingMovementRange
            }

            Direction.N -> {
                return yCoordinate in northFacingMovementRange
            }

            Direction.S -> {
                return yCoordinate in southFacingMovementRange
            }
        }
    }
}