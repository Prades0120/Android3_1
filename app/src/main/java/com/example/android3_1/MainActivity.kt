package com.example.android3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

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
        val editText1: EditText = findViewById(R.id.editTextNumber)
        val editText2: EditText = findViewById(R.id.editTextNumber2)

        button.isClickable = false

        spinner.adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,operaciones)

        editText1.setOnClickListener {
            if (spinner.selectedItem!=operaciones[0]) {
                if (editText1.text.toString() != "" && editText2.text.toString()!="") {
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

        editText2.setOnClickListener {
            if (spinner.selectedItem!=operaciones[0]) {
                if (editText1.text.toString() != "" && editText2.text.toString()!="") {
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

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                button.isClickable = false
                button.setBackgroundColor(resources.getColor(R.color.purple_500_faded))
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (spinner.selectedItem != operaciones[0]) {
                    if (editText1.text.toString() != "" && editText2.text.toString() != "") {
                        button.isClickable = true
                        button.setBackgroundColor(resources.getColor(R.color.purple_500))
                    } else {
                        button.isClickable = false
                        button.setBackgroundColor(resources.getColor(R.color.purple_500_faded))
                    }
                } else {
                    button.isClickable = false
                    button.setBackgroundColor(resources.getColor(R.color.purple_500_faded))
                }
            }
        }
        button.setOnClickListener {
            val num1 = editText1.text.toString().toInt()
            val num2 = editText2.text.toString().toInt()
            var res= -1
            if (spinner.selectedItem == operaciones[1])
                res = num1+num2
            else if (spinner.selectedItem == operaciones[2])
                res = num1-num2
            else if (spinner.selectedItem == operaciones[3])
                res = num1*num2
            else if (spinner.selectedItem == operaciones[4] && num2 != 0)
                res = num1/num2
            startResult(res)
        }
    }
    fun startResult(extra: Int) {
    val i = Intent(this, Result::class.java)
        i.putExtra("result",extra)
        startActivity(i)
    }
}