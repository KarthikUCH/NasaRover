package com.raju.kvr.nasarover.domain

class Plateau(val width: Int) {
    private val maxCoordinate: Int = width - 1;
    private val minCoordinate: Int = 0


    fun canMoveForward(facingDirection: Direction, xCoordinate: Int, yCoordinate: Int): Boolean {
        return when (facingDirection) {
            Direction.E -> {
                return xCoordinate < maxCoordinate
            }

            Direction.W -> {
                return xCoordinate > minCoordinate
            }

            Direction.N -> {
                return yCoordinate < maxCoordinate
            }

            Direction.S -> {
                return yCoordinate > minCoordinate
            }
        }
    }
}