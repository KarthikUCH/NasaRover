package com.raju.kvr.nasarover.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.raju.kvr.nasarover.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        observeViewModel()
    }

    private fun initView() {
        initSubmitButton()
    }

    private fun initSubmitButton() {
        binding.btnSubmit.setOnClickListener {

            binding.layoutPlateauWidth.error = null
            binding.layoutRoverPosition.error = null
            binding.layoutRoverNavigation.error = null

            val width = binding.edittextWidth.text?.trim().toString()
            val position = binding.edittextPosition.text?.trim().toString()
            val instruction = binding.edittextNavigation.text?.trim().toString()

            viewModel.navigate(width, position, instruction)
        }
    }

    private fun observeViewModel() {
        viewModel.validationUiStateData.observe(this) {
            if (!it.isValidWidth) {
                binding.layoutPlateauWidth.error = "Pls input valid width"
            }

            if (!it.isValidPosition) {
                binding.layoutRoverPosition.error = "Pls input valid landing position"
            }

            if (!it.isValidInstruction) {
                binding.layoutRoverNavigation.error = "Pls input valid navigation instruction"
            }
        }

        viewModel.resultPositionData.observe(this) {

        }
    }
}