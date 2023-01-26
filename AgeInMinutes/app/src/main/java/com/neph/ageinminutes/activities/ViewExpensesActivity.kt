package com.neph.ageinminutes.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.neph.ageinminutes.adapters.ExpensesAdapter
import com.neph.ageinminutes.R
import com.neph.ageinminutes.models.Expense


class ViewExpensesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_expenses)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set up the recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val expenses = getExpenses()

        recyclerView.adapter = ExpensesAdapter(expenses)
    }

    private fun getExpenses(): List<Expense>{
        // TODO: create api to retrieve items from db

        return listOf(
            Expense(1,"Groceries", 50.0, "2023-01-20"),
            Expense(2, "Gas", 30.0, "2023-01-22"),
            Expense(3,"Rent", 800.0, "2022-01-26")
        )
    }
}