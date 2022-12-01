package com.raju.kvr.nasarover.domain

sealed class Instruction
object MoveForward : Instruction()
object TurnRight : Instruction()
object TurnLeft : Instruction()