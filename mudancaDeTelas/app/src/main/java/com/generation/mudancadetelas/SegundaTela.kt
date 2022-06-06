package com.generation.mudancadetelas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        val buttonBack = findViewById<Button>(R.id.Back)

        buttonBack.setOnClickListener{
                finish()
        }
    }
}