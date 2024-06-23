package com.example.leaseorrenthome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val selectedHomesRadioGroup: RadioGroup = findViewById(R.id.selectedHomesRadioGroup)

        val selectedHomes = intent.getStringArrayListExtra("SELECTED_HOMES")

        selectedHomes?.forEach { home ->
            val radioButton = RadioButton(this)
            radioButton.text = home
            selectedHomesRadioGroup.addView(radioButton)
        }

        val proceedToPaymentButton: Button = findViewById(R.id.proceedToPaymentButton)
        proceedToPaymentButton.setOnClickListener {
            val selectedRadioButtonId = selectedHomesRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedHome = findViewById<RadioButton>(selectedRadioButtonId).text.toString()
                val intent = Intent(this@CheckoutActivity, PaymentOptionActivity::class.java)
                intent.putExtra("SELECTED_HOME", selectedHome)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a home", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
