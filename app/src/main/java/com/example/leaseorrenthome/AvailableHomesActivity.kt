package com.example.leaseorrenthome

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class AvailableHomesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_homes)

        val availableHomesList: ListView = findViewById(R.id.availableHomesList)

        // Mock data for available homes
        val availableHomes = arrayOf("123 Main St - $200,000", "456 Elm St - $150,000")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, availableHomes)
        availableHomesList.adapter = adapter
        availableHomesList.choiceMode = ListView.CHOICE_MODE_MULTIPLE
    }
}