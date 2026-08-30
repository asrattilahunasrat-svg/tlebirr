package com.tlebirr.app

import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showLoginScreen()
    }

    private fun showLoginScreen() {

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.gravity = Gravity.CENTER
        root.setPadding(40, 40, 40, 40)
        root.setBackgroundColor(Color.WHITE)

        val logo = TextView(this)
        logo.text = "TleBirr"
        logo.textSize = 34f
        logo.setTextColor(Color.rgb(8, 127, 91))
        logo.gravity = Gravity.CENTER

        val subtitle = TextView(this)
        subtitle.text = "Digital Wallet"
        subtitle.textSize = 16f
        subtitle.gravity = Gravity.CENTER
        subtitle.setPadding(0, 10, 0, 40)

        val loginButton = Button(this)
        loginButton.text = "LOGIN"

        val registerButton = Button(this)
        registerButton.text = "REGISTER"

        root.addView(
            logo,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        root.addView(
            subtitle,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        root.addView(
            loginButton,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        root.addView(
            registerButton,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        setContentView(root)

        loginButton.setOnClickListener {
            showLoginForm()
        }

        registerButton.setOnClickListener {
            showRegisterForm()
        }
    }

    private fun showLoginForm() {

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(40, 60, 40, 40)

        val title = TextView(this)
        title.text = "TleBirr Login"
        title.textSize = 28f
        title.setTextColor(Color.rgb(8, 127, 91))

        val phone = android.widget.EditText(this)
        phone.hint = "Phone Number"
        phone.inputType = 3

        val password = android.widget.EditText(this)
        password.hint = "Password"
        password.inputType = 129

        val login = Button(this)
        login.text = "LOGIN"

        root.addView(title)
        root.addView(phone)
        root.addView(password)
        root.addView(login)

        setContentView(root)

        login.setOnClickListener {
            showWallet()
        }
    }

    private fun showRegisterForm() {

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(40, 60, 40, 40)

        val title = TextView(this)
        title.text = "Create TleBirr Account"
        title.textSize = 28f
        title.setTextColor(Color.rgb(8, 127, 91))

        val name = android.widget.EditText(this)
        name.hint = "Full Name"

        val phone = android.widget.EditText(this)
        phone.hint = "Phone Number"
        phone.inputType = 3

        val password = android.widget.EditText(this)
        password.hint = "Password"
        password.inputType = 129

        val confirm = android.widget.EditText(this)
        confirm.hint = "Confirm Password"
        confirm.inputType = 129

        val register = Button(this)
        register.text = "CREATE ACCOUNT"

        root.addView(title)
        root.addView(name)
        root.addView(phone)
        root.addView(password)
        root.addView(confirm)
        root.addView(register)

        setContentView(root)

        register.setOnClickListener {
            showWallet()
        }
    }

    private fun showWallet() {

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(30, 50, 30, 30)

        val title = TextView(this)
        title.text = "TleBirr"
        title.textSize = 32f
        title.setTextColor(Color.rgb(8, 127, 91))

        val balance = TextView(this)
        balance.text = "Wallet Balance\n\n10,000.00 Birr"
        balance.textSize = 25f
        balance.setPadding(0, 30, 0, 40)

        val send = Button(this)
        send.text = "SEND MONEY"

        val bank = Button(this)
        bank.text = "BANK TRANSFER"

        val history = Button(this)
        history.text = "TRANSACTION HISTORY"

        root.addView(title)
        root.addView(balance)
        root.addView(send)
        root.addView(bank)
        root.addView(history)

        setContentView(root)

        send.setOnClickListener {
            showMessage("Send Money")
        }

        bank.setOnClickListener {
            showMessage("Bank Transfer")
        }

        history.setOnClickListener {
            showMessage("Transaction History")
        }
    }

    private fun showMessage(message: String) {

        android.widget.Toast.makeText(
            this,
            "$message feature coming next",
            android.widget.Toast.LENGTH_SHORT
        ).show()
    }
}
