package com.raju.kvr.nasarover.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raju.kvr.nasarover.domain.NasaUseCase
import com.raju.kvr.nasarover.domain.Rover

class MainViewModel : ViewModel() {

    private val _validationUiStateData = MutableLiveData<ValidationUiState>()
    val validationUiStateData: LiveData<ValidationUiState> = _validationUiStateData

    private val _resultPositionData = MutableLiveData<String>()
    val resultPositionData: LiveData<String> = _resultPositionData

    fun navigate(width: String, position: String, instruction: String) {
        val validationState = validateInput(width, position, instruction)

        if (!validationState.isValid()) {
            _validationUiStateData.value = validationState
            return
        }

        val nasaUseCase = NasaUseCase()
        val plateau = nasaUseCase.findPlateau(width.toInt())
        val rover = nasaUseCase.landRoverInPlateau(position, plateau)
        val result = nasaUseCase.navigateRover(rover, instruction)
        _resultPositionData.value = result
    }

    private fun validateInput(
        width: String,
        position: String,
        instruction: String
    ): ValidationUiState {
        val isValidWidth = validateWidth(width)
        val isValidPosition = validatePosition(width.toIntOrNull() ?: 0, position)
        val isValidInstruction = validateInstruction(instruction)

        return ValidationUiState(isValidWidth, isValidPosition, isValidInstruction)
    }

    private fun validateWidth(width: String): Boolean {
        return width.toIntOrNull() != null
    }

    private fun validatePosition(width: Int, position: String): Boolean {

        if (position.isEmpty() || position.length != 3) {
            return false
        }

        val xCoordinate = position[0]
        val yCoordinate = position[1]
        if (!xCoordinate.isDigit() || !yCoordinate.isDigit() || Rover.directions[position[2]] == null) {
            return false
        }

        if (xCoordinate.digitToInt() >= width || yCoordinate.digitToInt() >= width) {
            return false
        }

        return true
    }

    private fun validateInstruction(instruction: String): Boolean {
        return instruction.isNotEmpty()
    }
}

data class ValidationUiState(
    val isValidWidth: Boolean = true,
    val isValidPosition: Boolean = true,
    val isValidInstruction: Boolean = true
) {
    fun isValid(): Boolean {
        return isValidWidth && isValidPosition && isValidInstruction
    }
}