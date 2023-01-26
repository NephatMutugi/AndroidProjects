package com.neph.ageinminutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create a list of options for the main menu
        val options = listOf("Add Expense", "View Expenses", "View Savings", "Settings")

        // use the list view to display the options
        val listView = findViewById<ListView>(R.id.main_menu_list)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, options)

        // Set an OnItemClickListener to handle when an option is selected
        listView.onItemClickListener = AdapterView.OnItemClickListener{_,_,position, _->
            when(position){
                0 -> {
                    // Add expense option Selected
                    val intent = Intent(this, AddExpenseActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    // View Expenses option selected
                    val intent = Intent(this, ViewExpensesActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    // View Savings option selected
                    val intent = Intent(this, ViewSavingsActivity::class.java)
                    startActivity(intent)
                }
                3 -> {
                    // Settings option selected
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}