package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class selectpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selectpage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var mode = getIntent().getStringExtra("mode").toString()
        var ch = mode.toInt()
        val x = findViewById<AppCompatButton>(R.id.x)
        x.setOnClickListener {
            val nextpage: Intent
            if (ch == 1) {
                nextpage = Intent(this, timeractivity::class.java)
            } else {

                nextpage = Intent(this, MainActivity::class.java)
            }
            nextpage.putExtra("value", "0")
            startActivity(nextpage)
        }
        val o = findViewById<AppCompatButton>(R.id.o)
        o.setOnClickListener {
            val nextpage: Intent
            if (ch == 1) {
                nextpage = Intent(this, timeractivity::class.java)
            } else {

                nextpage = Intent(this, MainActivity::class.java)
            }
            nextpage.putExtra("value", "1")
            startActivity(nextpage)
        }
    }
}