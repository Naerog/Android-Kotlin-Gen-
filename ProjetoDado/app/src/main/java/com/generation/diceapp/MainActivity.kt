package com.generation.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonD4 = findViewById<Button>(R.id.buttonD4)
        val buttonD6 = findViewById<Button>(R.id.buttonD6)
        val buttonD8 = findViewById<Button>(R.id.buttonD8)
        val buttonD12 = findViewById<Button>(R.id.buttonD12)
        val buttonD20 = findViewById<Button>(R.id.buttonD20)
        val buttonD100 = findViewById<Button>(R.id.buttonD100)

        buttonD4.setOnClickListener {
            rolarDados(4, 1)
        }
        buttonD6.setOnClickListener {
            rolarDados(6,2)
        }
        buttonD8.setOnClickListener {
            rolarDados(8, 3)
        }
        buttonD12.setOnClickListener {
            rolarDados(12, 4)
        }
        buttonD20.setOnClickListener {
            rolarDados(20, 5)
        }
        buttonD100.setOnClickListener {
            rolarDados(100, 6)
        }

    }
    private fun rolarDados(lados: Int, esco: Int) {
        when (esco) {
            1 -> {
                val rolagem = (1..lados).random()
                val textDado = findViewById<TextView>(R.id.textDadoD4)
                textDado.text = rolagem.toString()}

            2 -> {
                val rolagem = (1..lados).random()
                val textDado2 = findViewById<TextView>(R.id.textDadoD6)
                textDado2.text = rolagem.toString()}
            3 -> {
                val rolagem = (1..lados).random()
                val textDado3 = findViewById<TextView>(R.id.textDadoD8)
                textDado3.text = rolagem.toString()
            }
            4 -> {
                val rolagem = (1..lados).random()
                val textDado4 = findViewById<TextView>(R.id.textDadoD12)
                textDado4.text = rolagem.toString()
            }
            5 -> {
                val rolagem = (1..lados).random()
                val textDado5 = findViewById<TextView>(R.id.textDadoD20)
                textDado5.text = rolagem.toString()
            }
            6 -> {
                val rolagem = (1..lados).random()
                val textDado6 = findViewById<TextView>(R.id.textDadoD100)
                textDado6.text = rolagem.toString()
            }
        }
    }
}