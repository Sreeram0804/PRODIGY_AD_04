package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.tictactoe.databinding.ActivityTimerBinding
import java.util.Locale

class timeractivity : AppCompatActivity() {
    var user=0
    var over=false
    private lateinit var binding: ActivityTimerBinding
    private var time=5
    private var sec=5
    private var array = Array(3) { Array<Int>(3) { -1 } }
    private val handler= Handler(Looper.getMainLooper())
    private val runnable=object:Runnable{
        override fun run(){
            sec--
            val timing=String.format(Locale.getDefault(),"%2d",sec)
            binding.timertext.text=timing
            if(sec==0){
                over=true
                display(0)
                binding.playertext.text="Player         wins"
            }
            handler.postDelayed(this,1000)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        handler.postDelayed(runnable,1000)
//        var t=binding.edit.text.toString()
//        time=t.toInt()
//        if(time>30){
//            time=30
//            sec=time
//        }
//        else if(time<1){
//            time=1
//            sec=time
//        }
//        else{
//            time=5
//            sec=time
//        }
        binding.timertext.text=sec.toString()
//        handler.removeCallbacks(runnable)
//        binding.edit.isEnabled=false
//        binding.edit.isVisible=false
        binding.timertext.isVisible=true
//        handler.postDelayed(runnable,1000)

        val intent=getIntent()
        var temp=intent.getStringExtra( "value").toString()
        user=temp.toInt()
        handler.postDelayed(runnable,1000)//new addition for testing
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
            val select= Intent(this,homepage::class.java)
            startActivity(select)
        }
        binding.replay.setOnClickListener{
            val select= Intent(this,selectpage::class.java)
            select.putExtra("mode",1)
            startActivity(select)
        }
    }

    private fun display(num: Int) {
        if (user == 0) {
            user=user+1
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
            user=user-1
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
            handler.removeCallbacks(runnable)
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
            handler.removeCallbacks(runnable)
        }
        sec=time
    }
}