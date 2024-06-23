package com.example.leaseorrenthome

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class HomeTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_type)

        val homeTypes = listOf("Apartment", "Detached Home", "Semi-Detached Home", "Condominium Apartment", "Townhouse")
        val homeTypeListView: ListView = findViewById(R.id.homeTypeListView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, homeTypes)
        homeTypeListView.adapter = adapter

        homeTypeListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedType = homeTypes[position]
            val intent = Intent(this@HomeTypeActivity, AvailableHomesActivity::class.java)
            intent.putExtra("HOME_TYPE", selectedType)
            startActivity(intent)
        }
    }
}