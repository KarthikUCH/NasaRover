package com.raju.kvr.nasarover.domain

enum class Direction {
    E,
    W,
    N,
    S
}

fun Direction.turnRight(): Direction {
    return when (this) {
        Direction.E -> {
            Direction.S
        }

        Direction.W -> {
            Direction.N
        }

        Direction.N -> {
            Direction.E
        }

        Direction.S -> {
            Direction.W
        }
    }
}

fun Direction.turnLeft(): Direction {
    return when (this) {
        Direction.E -> {
            Direction.N
        }

        Direction.W -> {
            Direction.S
        }

        Direction.N -> {
            Direction.W
        }

        Direction.S -> {
            Direction.E
        }
    }
}