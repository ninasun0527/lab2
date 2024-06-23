package com.example.leaseorrenthome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AvailableHomesActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_homes)

        val homeType = intent.getStringExtra("HOME_TYPE")

        val availableHomesList: ListView = findViewById(R.id.availableHomesList)

        // Mock data for available homes based on home type
        val availableHomes = when (homeType) {
            "Apartment" -> listOf("123 Main St - $200,000", "456 Elm St - $150,000")
            "Detached Home" -> listOf("789 Oak St - $300,000", "101 Pine St - $350,000")
            "Semi-Detached Home" -> listOf("202 Maple St - $250,000", "303 Cedar St - $275,000")
            "Condominium Apartment" -> listOf("404 Birch St - $220,000", "505 Walnut St - $230,000")
            "Townhouse" -> listOf("606 Ash St - $240,000", "707 Fir St - $260,000")
            else -> listOf()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, availableHomes)
        availableHomesList.adapter = adapter
        availableHomesList.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        // Assuming a button to proceed to checkout
        val checkoutButton: Button = findViewById(R.id.checkoutButton)
        checkoutButton.setOnClickListener {
            val selectedHomes = mutableListOf<String>()
            for (i in 0 until availableHomesList.count) {
                if (availableHomesList.isItemChecked(i)) {
                    selectedHomes.add(availableHomesList.getItemAtPosition(i) as String)
                }
            }

            if (selectedHomes.isEmpty()) {
                Toast.makeText(this, "No homes selected", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this@AvailableHomesActivity, CheckoutActivity::class.java)
            intent.putStringArrayListExtra("SELECTED_HOMES", ArrayList(selectedHomes))
            startActivity(intent)
        }
    }
}
