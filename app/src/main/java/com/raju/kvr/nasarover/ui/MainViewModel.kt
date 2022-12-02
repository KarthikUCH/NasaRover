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

    /**
     *  Handle Rover setup and navigation
     */
    fun navigate(width: Int, position: String, instruction: String) {

        val nasaUseCase = NasaUseCase()
        val plateau = nasaUseCase.findPlateau(width)
        val rover = nasaUseCase.landRoverInPlateau(position, plateau)
        val result = nasaUseCase.navigateRover(rover, instruction)
        _resultPositionData.value = result
    }

    /**
     *  Handle Validation
     */

    fun validateInput(
        width: String,
        position: String,
        instruction: String
    ): Boolean {
        val isValidWidth = validateWidth(width)
        val isValidPosition = validatePosition(width.toIntOrNull() ?: 0, position)
        val isValidInstruction = validateInstruction(instruction)

        val validationUiState = ValidationUiState(isValidWidth, isValidPosition, isValidInstruction)
        if (!validationUiState.isValid()) {
            _validationUiStateData.value = validationUiState
        }
        return validationUiState.isValid()
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