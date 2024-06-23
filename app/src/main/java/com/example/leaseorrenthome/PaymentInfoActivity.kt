package com.example.leaseorrenthome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_info)

        val paymentOption = intent.getStringExtra("PAYMENT_OPTION")

        val fullName: EditText = findViewById(R.id.fullName)
        val cardNumber: EditText = findViewById(R.id.cardNumber)
        val expDate: EditText = findViewById(R.id.expDate)
        val address: EditText = findViewById(R.id.address)
        val postCode: EditText = findViewById(R.id.postCode)
        val submitPaymentButton: Button = findViewById(R.id.submitPaymentButton)
        val backToPaymentOptionButton: Button = findViewById(R.id.backToPaymentOptionButton)

        if (paymentOption == "Cash") {
            cardNumber.visibility = android.view.View.GONE
            expDate.visibility = android.view.View.GONE
            address.visibility = android.view.View.GONE
            postCode.visibility = android.view.View.GONE
        } else {
            cardNumber.visibility = android.view.View.VISIBLE
            expDate.visibility = android.view.View.VISIBLE
            address.visibility = android.view.View.VISIBLE
            postCode.visibility = android.view.View.VISIBLE
        }

        submitPaymentButton.setOnClickListener {
            val name = fullName.text.toString()
            val cardNum = cardNumber.text.toString()
            val exp = expDate.text.toString()
            val userAddress = address.text.toString()
            val postalCode = postCode.text.toString()

            if (paymentOption == "Cash" && name.isEmpty()) {
                Toast.makeText(this, "Please fill the name field", Toast.LENGTH_SHORT).show()
            } else if ((paymentOption == "Credit Card" || paymentOption == "Debit Card") && (name.isEmpty() || cardNum.isEmpty() || exp.isEmpty() || userAddress.isEmpty() || postalCode.isEmpty())) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {

                val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putString("full_name", name)
                    if (paymentOption != "Cash") {
                        putString("card_number", cardNum)
                        putString("exp_date", exp)
                        putString("address", userAddress)
                        putString("post_code", postalCode)
                    }
                    apply()
                }
                Toast.makeText(this, "Payment Submitted", Toast.LENGTH_SHORT).show()

            }
        }

        backToPaymentOptionButton.setOnClickListener {
            val intent = Intent(this@PaymentInfoActivity, PaymentOptionActivity::class.java)
            startActivity(intent)
        }
    }
}
