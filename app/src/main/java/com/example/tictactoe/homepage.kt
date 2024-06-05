package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class homepage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val normal=findViewById<AppCompatButton>(R.id.normal)
        normal.setOnClickListener{
            val intent=Intent(this,selectpage::class.java)
            intent.putExtra("mode","0")
            startActivity(intent)
        }
        val timer=findViewById<AppCompatButton>(R.id.timer)
        timer.setOnClickListener{
            val intent= Intent(this,selectpage::class.java)
            intent.putExtra("mode","1")
            startActivity(intent)
        }
    }
}