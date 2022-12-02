package com.raju.kvr.nasarover.ui

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

internal class ValidationUiStateTest {

    @Test
    fun `valid input, validation success`() {
        val validationUiState = ValidationUiState(
            isValidWidth = true,
            isValidPosition = true,
            isValidInstruction = true
        )
        assertTrue(validationUiState.isValid())
    }

    @Test
    fun `invalid width, validation fail`() {
        val validationUiState = ValidationUiState(
            isValidWidth = false,
            isValidPosition = true,
            isValidInstruction = true
        )
        assertFalse(validationUiState.isValid())
    }

    @Test
    fun `invalid position, validation fail`() {
        val validationUiState = ValidationUiState(
            isValidWidth = true,
            isValidPosition = false,
            isValidInstruction = true
        )
        assertFalse(validationUiState.isValid())
    }

    @Test
    fun `invalid instruction, validation fail`() {
        val validationUiState = ValidationUiState(
            isValidWidth = true,
            isValidPosition = true,
            isValidInstruction = false
        )
        assertFalse(validationUiState.isValid())
    }
}