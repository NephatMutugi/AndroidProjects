package com.neph.quizapp.models

import com.neph.quizapp.R

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What country does this flag belong to?", R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Finland", "Brazil", 1
        )

        val question2 = Question(
            2,
            "What country does this flag belong to?", R.drawable.ic_flag_of_australia,
            "New Zealand", "United Kingdom",
            "Australia", "China", 3
        )

        val question3 = Question(
            3,
            "What country does this flag belong to?", R.drawable.ic_flag_of_belgium,
            "Germany", "Netherlands",
            "Turkey", "Belgium", 4
        )

        val question4 = Question(
            4,
            "What country does this flag belong to?", R.drawable.ic_flag_of_brazil,
            "Brazil", "Chile",
            "Chad", "Gabon", 1
        )

        val question5 = Question(
            5,
            "What country does this flag belong to?", R.drawable.ic_flag_of_denmark,
            "Norway", "Denmark",
            "Austria", "Hungary", 2
        )

        val question6 = Question(
            6,
            "What country does this flag belong to?", R.drawable.ic_flag_of_fiji,
            "Kenya", "Sao Tome and Principe",
            "Fiji", "Comoros", 3
        )

        val question7 = Question(
            7,
            "What country does this flag belong to?", R.drawable.ic_flag_of_germany,
            "Russia", "Germany",
            "England", "Egypt", 2
        )

        val question8 = Question(
            8,
            "What country does this flag belong to?", R.drawable.ic_flag_of_india,
            "India", "Pakistan",
            "Iran", "Qatar", 1
        )

        val question9 = Question(
            9,
            "What country does this flag belong to?", R.drawable.ic_flag_of_kuwait,
            "Kazakhstan", "Kuwait",
            "Afghanistan", "UAE", 2
        )

        val question10 = Question(
            10,
            "What country does this flag belong to?", R.drawable.ic_flag_of_new_zealand,
            "South Korea", "North Korea",
            "Japan", "New Zealand", 4
        )

        questionsList.add(question1)
        questionsList.add(question2)
        questionsList.add(question3)
        questionsList.add(question4)
        questionsList.add(question5)
        questionsList.add(question6)
        questionsList.add(question7)
        questionsList.add(question8)
        questionsList.add(question9)
        questionsList.add(question10)
        return questionsList
    }
}