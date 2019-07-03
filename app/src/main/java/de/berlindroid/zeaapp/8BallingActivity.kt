package de.berlindroid.zeaapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class BallingActivity : Activity() {
    val answers = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eightball_activity)

        answers.add("Hell no")
        answers.add("Fuck yeah")
        answers.add("I'm not picking you up from the hospital...")
        answers.add("What do you think I am, a mind reader?")
        answers.add("I don't know any German, sorry")
        answers.add("Yeah... sure, why not.")
        answers.add("Alex woz here")
        answers.add("I don't trust that question")
        answers.add("How did you get here?")
        answers.add("Pretzel first, answer later")
        answers.add("...?")

        val eightball_output = findViewById<TextView>(R.id.ball_output)
        val button = findViewById<Button>(R.id.get_answer)

        button.setOnClickListener {
            eightball_output.text = answers[Random.nextInt(answers.size)]
        }
    }


}