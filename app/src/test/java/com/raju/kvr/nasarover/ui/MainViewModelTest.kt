package com.raju.kvr.nasarover.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.raju.kvr.nasarover.getOrAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


internal class MainViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `valid input, navigate, success`() {

        viewModel.navigate(6, "12N", "LMLMLMLMM")
        assertEquals("13N", viewModel.resultPositionData.getOrAwaitValue())

        viewModel.navigate(6, "33E", "MMRMMRMRRM")
        assertEquals("51E", viewModel.resultPositionData.getOrAwaitValue())

        viewModel.navigate(6, "55N", "MMRMMLLMRMLLM")
        assertEquals("44S", viewModel.resultPositionData.getOrAwaitValue())
    }

    @Test
    fun `valid input, validate, success`() {
        var result = viewModel.validateInput("6", "12N", "LMLMLMLMM")
        assertTrue(result)
    }

    @Test
    fun `Invalid input, validate, failure`() {
        viewModel.validateInput("", "", "")
        val validationUiState = viewModel.validationUiStateData.getOrAwaitValue()

        assertFalse(validationUiState.isValid())
        assertFalse(validationUiState.isValidWidth)
        assertFalse(validationUiState.isValidPosition)
        assertFalse(validationUiState.isValidInstruction)
    }

    @Test
    fun `Invalid width, validate, failure`() {
        viewModel.validateInput("", "12N", "LMLMLMLMM")
        val validationUiState = viewModel.validationUiStateData.getOrAwaitValue()

        assertFalse(validationUiState.isValid())
        assertFalse(validationUiState.isValidWidth)
        assertFalse(validationUiState.isValidPosition)
        assertTrue(validationUiState.isValidInstruction)
    }

    @Test
    fun `Invalid coordinates in position, validate, failure`() {
        viewModel.validateInput("6", "NNN", "LMLMLMLMM")
        val validationUiState = viewModel.validationUiStateData.getOrAwaitValue()

        assertFalse(validationUiState.isValid())
        assertTrue(validationUiState.isValidWidth)
        assertFalse(validationUiState.isValidPosition)
        assertTrue(validationUiState.isValidInstruction)
    }

    @Test
    fun `Invalid Direstion in position, validate, failure`() {
        viewModel.validateInput("6", "22A", "LMLMLMLMM")
        val validationUiState = viewModel.validationUiStateData.getOrAwaitValue()

        assertFalse(validationUiState.isValid())
        assertTrue(validationUiState.isValidWidth)
        assertFalse(validationUiState.isValidPosition)
        assertTrue(validationUiState.isValidInstruction)
    }

    @Test
    fun `Invalid instruction, validate, failure`() {
        viewModel.validateInput("6", "12N", "")
        val validationUiState = viewModel.validationUiStateData.getOrAwaitValue()

        assertFalse(validationUiState.isValid())
        assertTrue(validationUiState.isValidWidth)
        assertTrue(validationUiState.isValidPosition)
        assertFalse(validationUiState.isValidInstruction)
    }

}