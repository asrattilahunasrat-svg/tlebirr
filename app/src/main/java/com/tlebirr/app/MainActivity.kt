package com.tlebirr.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.text.InputType
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLoginScreen()
    }

    private fun createRoot(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(40, 50, 40, 40)
            setBackgroundColor(Color.WHITE)
        }
    }

    private fun createButton(text: String): Button {
        return Button(this).apply {
            this.text = text
            textSize = 16f

            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 10, 0, 10)
            }
        }
    }

    private fun createInput(hintText: String): EditText {
        return EditText(this).apply {
            hint = hintText
            textSize = 16f
            setSingleLine(true)

            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 8, 0, 8)
            }
        }
    }

    private fun createTitle(text: String): TextView {
        return TextView(this).apply {
            this.text = text
            textSize = 28f
            setTextColor(Color.rgb(8, 127, 91))
            setPadding(0, 0, 0, 25)
        }
    }

    private fun showLoginScreen() {

        val root = createRoot()
        root.gravity = Gravity.CENTER

        val logo = TextView(this).apply {
            text = "TleBirr"
            textSize = 34f
            setTextColor(Color.rgb(8, 127, 91))
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Digital Wallet"
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(0, 10, 0, 35)
        }

        val loginButton = createButton("LOGIN")
        val registerButton = createButton("REGISTER")

        root.addView(logo)
        root.addView(subtitle)
        root.addView(loginButton)
        root.addView(registerButton)

        setContentView(root)

        loginButton.setOnClickListener {
            showLoginForm()
        }

        registerButton.setOnClickListener {
            showRegisterForm()
        }
    }

    private fun showLoginForm() {

        val root = createRoot()

        val title = createTitle("TleBirr Login")

        val phone = createInput("Phone Number")
        phone.inputType = InputType.TYPE_CLASS_PHONE

        val password = createInput("Password")
        password.inputType =
            InputType.TYPE_CLASS_TEXT or
            InputType.TYPE_TEXT_VARIATION_PASSWORD

        val loginButton = createButton("LOGIN")
        val backButton = createButton("BACK")

        root.addView(title)
        root.addView(phone)
        root.addView(password)
        root.addView(loginButton)
        root.addView(backButton)

        setContentView(root)

        loginButton.setOnClickListener {

            val phoneText = phone.text.toString().trim()
            val passwordText = password.text.toString()

            if (phoneText.isEmpty() || passwordText.isEmpty()) {
                showMessage("Please enter phone number and password")
            } else {
                showWallet()
            }
        }

        backButton.setOnClickListener {
            showLoginScreen()
        }
    }

    private fun showRegisterForm() {

        val root = createRoot()

        val title = createTitle("Create TleBirr Account")

        val name = createInput("Full Name")

        val phone = createInput("Phone Number")
        phone.inputType = InputType.TYPE_CLASS_PHONE

        val password = createInput("Password")
        password.inputType =
            InputType.TYPE_CLASS_TEXT or
            InputType.TYPE_TEXT_VARIATION_PASSWORD

        val confirm = createInput("Confirm Password")
        confirm.inputType =
            InputType.TYPE_CLASS_TEXT or
            InputType.TYPE_TEXT_VARIATION_PASSWORD

        val registerButton = createButton("CREATE ACCOUNT")
        val backButton = createButton("BACK")

        root.addView(title)
        root.addView(name)
        root.addView(phone)
        root.addView(password)
        root.addView(confirm)
        root.addView(registerButton)
        root.addView(backButton)

        setContentView(root)

        registerButton.setOnClickListener {

            val nameText = name.text.toString().trim()
            val phoneText = phone.text.toString().trim()
            val passwordText = password.text.toString()
            val confirmText = confirm.text.toString()

            when {
                nameText.isEmpty() ||
                phoneText.isEmpty() ||
                passwordText.isEmpty() ||
                confirmText.isEmpty() -> {
                    showMessage("Please fill in all fields")
                }

                passwordText != confirmText -> {
                    showMessage("Passwords do not match")
                }

                else -> {
                    showMessage("Account created successfully")
                    showWallet()
                }
            }
        }

        backButton.setOnClickListener {
            showLoginScreen()
        }
    }

    private fun showWallet() {

        val root = createRoot()

        val title = TextView(this).apply {
            text = "TleBirr"
            textSize = 32f
            setTextColor(Color.rgb(8, 127, 91))
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 20)
        }

        val balance = TextView(this).apply {
            text = "Wallet Balance\n\n10,000.00 Birr"
            textSize = 25f
            gravity = Gravity.CENTER
            setPadding(0, 20, 0, 35)
        }

        val sendButton = createButton("SEND MONEY")
        val bankButton = createButton("BANK TRANSFER")
        val historyButton = createButton("TRANSACTION HISTORY")
        val logoutButton = createButton("LOGOUT")

        root.addView(title)
        root.addView(balance)
        root.addView(sendButton)
        root.addView(bankButton)
        root.addView(historyButton)
        root.addView(logoutButton)

        setContentView(root)

        sendButton.setOnClickListener {
            showMessage("Send Money feature coming next")
        }

        bankButton.setOnClickListener {
            showMessage("Bank Transfer feature coming next")
        }

        historyButton.setOnClickListener {
            showMessage("Transaction History feature coming next")
        }

        logoutButton.setOnClickListener {
            showLoginScreen()
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}
