package com.app.ykc.roboletric

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button = findViewById(R.id.login)

        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

    }
}
