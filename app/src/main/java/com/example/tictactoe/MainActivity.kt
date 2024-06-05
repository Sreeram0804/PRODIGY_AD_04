package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var user: Int = 0
    var array = Array(3) { Array<Int>(3) { -1 } }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent=getIntent()
        var temp=intent.getStringExtra( "value")
        user=temp!!.toInt()
        if(user==1){
            binding.image.setImageResource(R.drawable.image_o)
        }

        binding.one.setOnClickListener {
            display(1)
            binding.one.isClickable = false
        }
        binding.two.setOnClickListener {
            display(2)
            binding.two.isClickable = false
        }
        binding.three.setOnClickListener {
            display(3)
            binding.three.isClickable = false
        }
        binding.four.setOnClickListener {
            display(4)
            binding.four.isClickable = false
        }
        binding.five.setOnClickListener {
            display(5)
            binding.five.isClickable = false
        }
        binding.six.setOnClickListener {
            display(6)
            binding.six.isClickable = false
        }
        binding.seven.setOnClickListener {
            display(7)
            binding.seven.isClickable = false
        }
        binding.eight.setOnClickListener {
            display(8)
            binding.eight.isClickable = false
        }
        binding.nine.setOnClickListener {
            display(9)
            binding.nine.isClickable = false
        }
        binding.home.setOnClickListener{
            val select=Intent(this,homepage::class.java)
            startActivity(select)
        }
        binding.replay.setOnClickListener{
            val select=Intent(this,selectpage::class.java)
            select.putExtra("mode",0)
            startActivity(select)
        }
    }

    private fun display(num: Int) {
        if (user == 0) {
            user=user!!+1
            binding.image.setImageResource(R.drawable.image_o)
            when (num) {
                1 -> {
                    binding.one.setImageResource(R.drawable.image_x)
                    array[0][0] = 0
                }

                2 -> {
                    binding.two.setImageResource(R.drawable.image_x)
                    array[0][1] = 0
                }

                3 -> {
                    binding.three.setImageResource(R.drawable.image_x)
                    array[0][2] = 0
                }

                4 -> {
                    binding.four.setImageResource(R.drawable.image_x)
                    array[1][0] = 0
                }

                5 -> {
                    binding.five.setImageResource(R.drawable.image_x)
                    array[1][1] = 0
                }

                6 -> {
                    binding.six.setImageResource(R.drawable.image_x)
                    array[1][2] = 0
                }

                7 -> {
                    binding.seven.setImageResource(R.drawable.image_x)
                    array[2][0] = 0
                }

                8 -> {
                    binding.eight.setImageResource(R.drawable.image_x)
                    array[2][1] = 0
                }

                9 -> {
                    binding.nine.setImageResource(R.drawable.image_x)
                    array[2][2] = 0
                }
            }
        } else {
            user=user!!-1
            binding.image.setImageResource(R.drawable.image_x)
            when (num) {
                1 -> {
                    binding.one.setImageResource(R.drawable.image_o)
                    array[0][0] = 1
                }

                2 -> {
                    binding.two.setImageResource(R.drawable.image_o)
                    array[0][1] = 1
                }

                3 -> {
                    binding.three.setImageResource(R.drawable.image_o)
                    array[0][2] = 1
                }

                4 -> {
                    binding.four.setImageResource(R.drawable.image_o)
                    array[1][0] = 1
                }

                5 -> {
                    binding.five.setImageResource(R.drawable.image_o)
                    array[1][1] = 1
                }

                6 -> {
                    binding.six.setImageResource(R.drawable.image_o)
                    array[1][2] = 1
                }

                7 -> {
                    binding.seven.setImageResource(R.drawable.image_o)
                    array[2][0] = 1
                }

                8 -> {
                    binding.eight.setImageResource(R.drawable.image_o)
                    array[2][1] = 1
                }

                9 -> {
                    binding.nine.setImageResource(R.drawable.image_o)
                    array[2][2] = 1
                }
            }
        }
        var over=false
        for (i in 0..2) {
            if ((array[i][0] == 0&&array[i][1]==0&&array[i][2]==0)||(array[0][i] == 0&&array[1][i]==0&&array[2][i]==0)) {
                over=true
                binding.image.setImageResource(R.drawable.image_x)
                binding.playertext.text="Player         wins"
            }
            if ((array[i][0] == 1&&array[i][1]==1&&array[i][2]==1)||(array[0][i] == 1&&array[1][i]==1&&array[2][i]==1)) {
                over=true
                binding.image.setImageResource(R.drawable.image_o)
                binding.playertext.text="Player         wins"
            }
        }
        if((array[0][0]==0&&array[1][1]==0&&array[2][2]==0)||(array[0][2]==0&&array[1][1]==0&&array[2][0]==0)){
            over=true
            binding.image.setImageResource(R.drawable.image_x)
            binding.playertext.text="Player         wins"
        }
        if((array[0][0]==1&&array[1][1]==1&&array[2][2]==1)||(array[0][2]==1&&array[1][1]==1&&array[2][0]==1)){
            over=true
            binding.image.setImageResource(R.drawable.image_o)
            binding.playertext.text="Player         wins"
        }
        if(over){
            binding.one.isClickable=false
            binding.two.isClickable=false
            binding.three.isClickable=false
            binding.four.isClickable=false
            binding.five.isClickable=false
            binding.six.isClickable=false
            binding.seven.isClickable=false
            binding.eight.isClickable=false
            binding.nine.isClickable=false
        }
        var count=0
        for(i in 0..2){
            for(j in 0..2){
                if(array[i][j]!=-1){
                    count++
                }
            }
        }
        if(count==9&&over==false){
            binding.playertext.text="Draw"
            binding.image.isVisible=false
        }
    }
}