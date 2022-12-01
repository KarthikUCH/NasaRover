package com.raju.kvr.nasarover.domain

import org.junit.Test
import org.junit.Assert.assertEquals

internal class RoverTest {

    @Test
    fun `facing east, testCurrentPosition`() {
        val plateau = Plateau(6)
        val rover = Rover(2, 3, Direction.E, plateau)
        val result = rover.getCurrentPosition()
        assertEquals("23E", result)
    }

    @Test
    fun `facing west, testCurrentPosition`() {
        val plateau = Plateau(6)
        val rover = Rover(2, 3, Direction.W, plateau)
        val result = rover.getCurrentPosition()
        assertEquals("23W", result)
    }

    @Test
    fun `facing north, testCurrentPosition`() {
        val plateau = Plateau(6)
        val rover = Rover(2, 3, Direction.N, plateau)
        val result = rover.getCurrentPosition()
        assertEquals("23N", result)
    }

    @Test
    fun `facing south, testCurrentPosition`() {
        val plateau = Plateau(6)
        val rover = Rover(2, 3, Direction.S, plateau)
        val result = rover.getCurrentPosition()
        assertEquals("23S", result)
    }

    @Test
    fun `test navigation case 1`(){
        val plateau = Plateau(6)
        val rover = Rover(1, 2, Direction.N, plateau)
        rover.navigateTo("LMLMLMLMM");
        assertEquals("13N", rover.getCurrentPosition())
    }

    @Test
    fun `test navigation case 2`(){
        val plateau = Plateau(6)
        val rover = Rover(3, 3, Direction.E, plateau)
        rover.navigateTo("MMRMMRMRRM");
        assertEquals("51E", rover.getCurrentPosition())
    }

    @Test
    fun `test navigation case 3`(){
        val plateau = Plateau(6)
        val rover = Rover(5, 5, Direction.N, plateau)
        rover.navigateTo("MMRMMLLMRMLLM");
        assertEquals("44S", rover.getCurrentPosition())
    }
}