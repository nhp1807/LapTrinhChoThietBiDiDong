package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create rollButton and find it by id
        val rollButton: Button = findViewById(R.id.button)
        // Set action to the button when click on it
        rollButton.setOnClickListener {
            rollDice()
        }

        // Roll a dice when the app starts
        rollDice()
    }

    private fun rollDice() {
        // Create a dice has 6 sides
        val dice = Dice(6)
        // Get randomize value when click the button
        val diceRoll = dice.roll()
        // Get image by id
        val diceImage: ImageView = findViewById(R.id.imageView)
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}