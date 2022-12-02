package com.raju.kvr.nasarover.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.raju.kvr.nasarover.R
import com.raju.kvr.nasarover.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
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
            onSubmit()
        }
    }

    private fun onSubmit() {
        binding.layoutPlateauWidth.error = null
        binding.layoutRoverPosition.error = null
        binding.layoutRoverNavigation.error = null

        val width = binding.edittextWidth.text?.trim().toString()
        val position = binding.edittextPosition.text?.trim().toString()
        val instruction = binding.edittextNavigation.text?.trim().toString()

        val valid = viewModel.validateInput(width, position, instruction)
        if (valid) {
            viewModel.navigate(width.trim().toInt(), position, instruction)
        }
    }

    private fun observeViewModel() {
        viewModel.validationUiStateData.observe(this) {
            if (!it.isValidWidth) {
                binding.layoutPlateauWidth.error =
                    resources.getString(R.string.err_msg_invalid_width)
            }

            if (!it.isValidPosition) {
                binding.layoutRoverPosition.error =
                    resources.getString(R.string.err_msg_invalid_landing_position)
            }

            if (!it.isValidInstruction) {
                binding.layoutRoverNavigation.error =
                    resources.getString(R.string.err_msg_invalid_navigation_instruction)
            }
        }

        viewModel.resultPositionData.observe(this) {
            displayResultDialog(it)
        }
    }

    private fun displayResultDialog(result: String) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Rover Navigated to")
            .setMessage(result)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }.show()
        val textView = dialog.findViewById(android.R.id.message) as TextView?
        textView?.textSize = 40f
    }
}