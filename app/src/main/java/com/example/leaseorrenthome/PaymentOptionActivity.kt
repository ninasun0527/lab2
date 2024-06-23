package com.example.leaseorrenthome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentOptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_option)

        val paymentOptionsRadioGroup: RadioGroup = findViewById(R.id.paymentOptionsRadioGroup)

        val paymentOptions = listOf("Bank Draft or Check","Credit Card", "Debit Card")
        paymentOptions.forEach { option ->
            val radioButton = RadioButton(this)
            radioButton.text = option
            paymentOptionsRadioGroup.addView(radioButton)
        }

        val submitPaymentOptionButton: Button = findViewById(R.id.submitPaymentOptionButton)
        submitPaymentOptionButton.setOnClickListener {
            val selectedRadioButtonId = paymentOptionsRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedOption = findViewById<RadioButton>(selectedRadioButtonId).text.toString()
                if (selectedOption == "Credit Card" || selectedOption == "Debit Card") {
                    val intent = Intent(this@PaymentOptionActivity, PaymentInfoActivity::class.java)
                    intent.putExtra("PAYMENT_OPTION", selectedOption)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Please Make Payment to TorontoHouseAgent Inc.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please select a payment option", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
