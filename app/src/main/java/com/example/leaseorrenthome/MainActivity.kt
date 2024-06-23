package com.example.leaseorrenthome


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterButton: Button = findViewById(R.id.enterButton)
        enterButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, HomeTypeActivity::class.java))
        }
    }
}