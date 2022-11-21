package com.example.tictactoefixed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var Player1: EditText
    private lateinit var Player2: EditText
    private lateinit var Start: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Player1 = findViewById(R.id.editTextTextPersonName3)
        Player2 = findViewById(R.id.editTextTextPersonName2)
        Start = findViewById(R.id.button12)


        Start.setOnClickListener(){
            val ffirst = Player1.text.toString()
            val ssecond = Player2.text.toString()
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("NAME",ffirst)
            intent.putExtra("name",ssecond)
            startActivity(intent)
        }
    }
}