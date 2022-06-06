package com.generation.mudancadetelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttoNext = findViewById<Button>(R.id.next)
        val intentEntrar = Intent(this, SegundaTela::class.java)

        buttoNext.setOnClickListener{
            startActivity(intentEntrar)
        }

    }
}