package com.raju.kvr.nasarover.domain

import org.junit.Test
import org.junit.Assert.assertEquals


internal class DirectionKtTest {

    @Test
    fun testTurnRight() {
        assertEquals( Direction.S, Direction.E.turnRight())
        assertEquals( Direction.N, Direction.W.turnRight())
        assertEquals( Direction.E, Direction.N.turnRight())
        assertEquals( Direction.W, Direction.S.turnRight())
    }

    @Test
    fun testTurnLeft() {
        assertEquals( Direction.N, Direction.E.turnLeft())
        assertEquals( Direction.S, Direction.W.turnLeft())
        assertEquals( Direction.W, Direction.N.turnLeft())
        assertEquals( Direction.E, Direction.S.turnLeft())
    }
}