package com.raju.kvr.nasarover.domain

import org.junit.Test
import org.junit.Assert.assertEquals

internal class RoverTest {

    @Test
    fun testAllowedInstructions(){
        val instruction = Rover.instructions
        assertEquals(3, instruction.size)
        assertEquals(true, instruction.contains('M'))
        assertEquals(true, instruction.contains('L'))
        assertEquals(true, instruction.contains('R'))
    }

    @Test
    fun testAllowedDirections(){
        val directions = Rover.directions
        assertEquals(4, directions.size)
        assertEquals(true, directions.contains('E'))
        assertEquals(true, directions.contains('W'))
        assertEquals(true, directions.contains('N'))
        assertEquals(true, directions.contains('S'))
    }

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

    @Test
    fun `test navigation case 4`(){
        val plateau = Plateau(1)
        val rover = Rover(0, 0, Direction.N, plateau)
        rover.navigateTo("LMLMLMLMML");
        assertEquals("00W", rover.getCurrentPosition())
    }
}