package com.raju.kvr.nasarover.domain

import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals


internal class NasaUseCaseTest {

    lateinit var nasaUseCase: NasaUseCase

    @Before
    fun setUp() {
        nasaUseCase = NasaUseCase()
    }

    @Test
    fun findPlateau() {
        val width = 6
        val plateau = nasaUseCase.findPlateau(width)
        assertEquals(6, plateau.width)
    }

    @Test
    fun landRoverInPlateau_withValidData() {
        val width = 6
        val plateau = nasaUseCase.findPlateau(width)
        val rover = nasaUseCase.landRoverInPlateau("22S", plateau)
        assertEquals("22S", rover.getCurrentPosition())
    }

    @Test
    fun landRoverInPlateau_withInValidData() {
        val width = 6
        val plateau = nasaUseCase.findPlateau(width)
        val rover = nasaUseCase.landRoverInPlateau("", plateau)
        assertEquals("00E", rover.getCurrentPosition())
    }

    @Test
    fun landRoverInPlateau_withInvalidCoordinate() {
        val width = 6
        val plateau = nasaUseCase.findPlateau(width)
        val rover = nasaUseCase.landRoverInPlateau("  S", plateau)
        assertEquals("00S", rover.getCurrentPosition())
    }

    @Test
    fun landRoverInPlateau_withInvalidDirection() {
        val width = 6
        val plateau = nasaUseCase.findPlateau(width)
        val rover = nasaUseCase.landRoverInPlateau("22", plateau)
        assertEquals("22E", rover.getCurrentPosition())
    }

    @Test
    fun navigateRover() {
        val width = 6
        val plateau = nasaUseCase.findPlateau(width)
        val rover = nasaUseCase.landRoverInPlateau("12N", plateau)
        val result = nasaUseCase.navigateRover(rover, "LMLMLMLMM")
        assertEquals("13N", result)
    }
}