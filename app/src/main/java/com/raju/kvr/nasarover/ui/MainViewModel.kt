package com.raju.kvr.nasarover.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
    }

    private fun validateInput(
        width: String,
        position: String,
        instruction: String
    ): ValidationUiState {
        val isValidWidth = validateWidth(width)
        val isValidPosition = validatePosition(position)
        val isValidInstruction = validateInstruction(instruction)

        return ValidationUiState(isValidWidth, isValidPosition, isValidInstruction)
    }

    private fun validateWidth(width: String): Boolean {
        return width.toIntOrNull() != null
    }

    private fun validatePosition(position: String): Boolean {

        if (position.isEmpty() || position.length != 3) {
            return false
        }

        if (!position[0].isDigit() || !position[1].isDigit() || Rover.directions[position[2]] == null) {
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