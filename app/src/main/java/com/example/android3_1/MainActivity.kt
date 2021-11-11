package com.example.android3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operaciones = arrayListOf<String>()
        operaciones.add("Operaciones")
        operaciones.add("Sumar")
        operaciones.add("Restar")
        operaciones.add("Multiplicar")
        operaciones.add("Dividir")
        val spinner: Spinner = findViewById(R.id.spinner)
        val button: Button = findViewById(R.id.button)
        val num1: EditText = findViewById(R.id.editTextNumber)
        val num2: EditText = findViewById(R.id.editTextNumber2)
        val resultado: EditText = findViewById(R.id.editTextNumber3)

        spinner.adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,operaciones)

        spinner.setOnItemClickListener { adapterView, view, i, l ->
            if (operaciones[spinner.selectedItemPosition]!=operaciones[0]) {
                if (num1.text.toString() != "" && num2.text.toString()!="") {
                    button.isClickable = true
                    button.setBackgroundColor(resources.getColor(R.color.purple_500))
                }else {
                    button.isClickable = false
                    button.setBackgroundColor(resources.getColor(R.color.purple_500_faded))
                }
            }else{
                button.isClickable = false
                button.setBackgroundColor(resources.getColor(R.color.purple_500_faded))
            }
        }
    }
}