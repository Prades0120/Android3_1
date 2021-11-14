package com.example.android3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textResult: TextView = findViewById(R.id.resultado)
        textResult.text = intent.getIntExtra("result",-1).toString()
    }
}