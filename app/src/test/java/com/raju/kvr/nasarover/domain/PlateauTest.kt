package com.raju.kvr.nasarover.domain

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


internal class PlateauTest {


    lateinit var plateau: Plateau

    @Before
    fun setUp() {
        plateau = Plateau(6)

    }

    /**
     * Test for Facing East
     */

    @Test
    fun `facing east, canMoveForward, success`() {
        val y = 0;
        for (x in 0 until plateau.width-1) {
            assertEquals(true, plateau.canMoveForward(Direction.E, x, y))
        }
    }

    @Test
    fun `facing east, canMoveForward, failure`() {
        assertEquals(false, plateau.canMoveForward(Direction.E, plateau.width-1, 0))
    }

    /**
     * Test for Facing West
     */

    @Test
    fun `facing west, canMoveForward, success`() {
        val y = 0;
        for (x in plateau.width-1 downTo 1 ) {
            assertEquals(true, plateau.canMoveForward(Direction.W, x, y))
        }
    }

    @Test
    fun `facing west, canMoveForward, failure`() {
        assertEquals(false, plateau.canMoveForward(Direction.W, 0, 0))
    }

    /**
     * Test for Facing North
     */

    @Test
    fun `facing north, canMoveForward, success`() {
        val x = 0;
        for (y in 0 until plateau.width-1) {
            assertEquals(true, plateau.canMoveForward(Direction.N, x, y))
        }
    }

    @Test
    fun `facing north, canMoveForward, failure`() {
        assertEquals(false, plateau.canMoveForward(Direction.N, 0, plateau.width-1))
    }

    /**
     * Test for Facing South
     */

    @Test
    fun `facing south, canMoveForward, success`() {
        val x = 0;
        for (y in plateau.width-1 downTo 1 ) {
            assertEquals(true, plateau.canMoveForward(Direction.S, x, y))
        }
    }

    @Test
    fun `facing south, canMoveForward, failure`() {
        assertEquals(false, plateau.canMoveForward(Direction.S, 0, 0))
    }

}