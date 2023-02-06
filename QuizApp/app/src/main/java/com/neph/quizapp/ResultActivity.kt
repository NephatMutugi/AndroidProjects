package com.neph.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.neph.quizapp.models.Constants

class ResultActivity : AppCompatActivity() {

    private var tvName: TextView?= null
    private var tvScore: TextView?= null
    private var btnFinish: Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvName = findViewById(R.id.tvName)
        tvScore = findViewById(R.id.tvScore)
        btnFinish = findViewById(R.id.btnFinish)

        val useName = intent.getStringExtra(Constants.USER_NAME)
        tvName?.text = useName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvScore?.text = buildString {
        append("Your Score is ")
        append(correctAnswers)
        append(" out of ")
        append(totalQuestions)
        append(".")
    }
        btnFinish?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}