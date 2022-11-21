package com.example.tictactoefixed

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var butt: Button
    private lateinit var butt1: Button
    private lateinit var butt2: Button
    private lateinit var butt3: Button
    private lateinit var butt4: Button
    private lateinit var butt5: Button
    private lateinit var butt6: Button
    private lateinit var butt7: Button
    private lateinit var butt8: Button
    private lateinit var butt9: Button
    private lateinit var first: TextView
    private lateinit var second: TextView
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var butt10:Button

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var score1st = ArrayList<String>()
    private var score2nd = ArrayList<String>()
    private var firstPlayerScore = ArrayList<Int>()
    private var secondPlayerScore = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val ffirst = intent.extras?.getString("NAME")
        val ssecond = intent.extras?.getString("name")
        first = findViewById(R.id.textView)
        second = findViewById(R.id.textView2)
        first.text = ffirst
        second.text = ssecond
        if (first.text.isEmpty()){
            first.text = "Player1"
        }
        if (second.text.isEmpty()){
            second.text = "Player2"
        }

        init()
    }

    private fun init() {
        butt = findViewById(R.id.button)
        butt1 = findViewById(R.id.button2)
        butt2 = findViewById(R.id.button3)
        butt3 = findViewById(R.id.button4)
        butt4 = findViewById(R.id.button5)
        butt5 = findViewById(R.id.button6)
        butt6 = findViewById(R.id.button7)
        butt7 = findViewById(R.id.button8)
        butt8 = findViewById(R.id.button9)
        butt9 = findViewById(R.id.button10)
        score1 = findViewById(R.id.textView3)
        score2 = findViewById(R.id.textView4)
        butt10 = findViewById(R.id.button11)


        butt.setOnClickListener(this)
        butt1.setOnClickListener(this)
        butt2.setOnClickListener(this)
        butt3.setOnClickListener(this)
        butt4.setOnClickListener(this)
        butt5.setOnClickListener(this)
        butt6.setOnClickListener(this)
        butt7.setOnClickListener(this)
        butt8.setOnClickListener(this)
        butt9.setOnClickListener(this)
        butt10.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.button10 -> buttonNumber = 0
                R.id.button11 -> buttonNumber = -1
            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
            if (buttonNumber == 0){
                butt.text = ""
                butt1.text = ""
                butt2.text = ""
                butt3.text = ""
                butt4.text = ""
                butt5.text = ""
                butt6.text = ""
                butt7.text = ""
                butt8.text = ""
                butt.isEnabled = true
                butt1.isEnabled = true
                butt2.isEnabled = true
                butt3.isEnabled = true
                butt4.isEnabled = true
                butt5.isEnabled = true
                butt6.isEnabled = true
                butt7.isEnabled = true
                butt8.isEnabled = true
                butt9.isEnabled = true
                butt.setBackgroundColor(Color.CYAN)
                butt1.setBackgroundColor(Color.CYAN)
                butt2.setBackgroundColor(Color.CYAN)
                butt3.setBackgroundColor(Color.CYAN)
                butt4.setBackgroundColor(Color.CYAN)
                butt5.setBackgroundColor(Color.CYAN)
                butt6.setBackgroundColor(Color.CYAN)
                butt7.setBackgroundColor(Color.CYAN)
                butt8.setBackgroundColor(Color.CYAN)
                firstPlayer.clear()
                secondPlayer.clear()
                activePlayer = 1
            }
            if (buttonNumber == -1){
                butt.text = ""
                butt1.text = ""
                butt2.text = ""
                butt3.text = ""
                butt4.text = ""
                butt5.text = ""
                butt6.text = ""
                butt7.text = ""
                butt8.text = ""
                butt.isEnabled = true
                butt1.isEnabled = true
                butt2.isEnabled = true
                butt3.isEnabled = true
                butt4.isEnabled = true
                butt5.isEnabled = true
                butt6.isEnabled = true
                butt7.isEnabled = true
                butt8.isEnabled = true
                butt9.isEnabled = true
                butt.setBackgroundColor(Color.CYAN)
                butt1.setBackgroundColor(Color.CYAN)
                butt2.setBackgroundColor(Color.CYAN)
                butt3.setBackgroundColor(Color.CYAN)
                butt4.setBackgroundColor(Color.CYAN)
                butt5.setBackgroundColor(Color.CYAN)
                butt6.setBackgroundColor(Color.CYAN)
                butt7.setBackgroundColor(Color.CYAN)
                butt8.setBackgroundColor(Color.CYAN)
                firstPlayer.clear()
                secondPlayer.clear()
                firstPlayerScore.clear()
                secondPlayerScore.clear()
                score1.text = "0"
                score2.text = "0"
                activePlayer = 1
            }
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            activePlayer = 2
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.TRANSPARENT)
            clickedView.setTextColor(Color.WHITE)
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2) {
            activePlayer = 1
            clickedView.text = "o"
            clickedView.setBackgroundColor(Color.TRANSPARENT)
            clickedView.setTextColor(Color.WHITE)
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check(){
        firstPlayerScore.add(0)
        secondPlayerScore.add(0)
        var Score = firstPlayerScore
        var Sscore = secondPlayerScore


        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (winnerPlayer == 1){
            Toast.makeText(this,"1st won",Toast.LENGTH_LONG).show()
            Score[0]+=1
            score1.text = Score[0].toString()
        }
        if (winnerPlayer == 2){
            Sscore[0]+=1
            score2.text = Sscore[0].toString()
            Toast.makeText(this,"2nd won",Toast.LENGTH_LONG).show()
        }
        if (firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0){
            Toast.makeText(this,"tie",Toast.LENGTH_SHORT).show()
        }
        if(winnerPlayer != 0){
            butt.isEnabled = false
            butt1.isEnabled = false
            butt2.isEnabled = false
            butt3.isEnabled = false
            butt4.isEnabled = false
            butt5.isEnabled = false
            butt6.isEnabled = false
            butt7.isEnabled = false
            butt8.isEnabled = false
        }
    }
}

private operator fun <E> ArrayList<E>.set(i: Int, value: Int) {

}
