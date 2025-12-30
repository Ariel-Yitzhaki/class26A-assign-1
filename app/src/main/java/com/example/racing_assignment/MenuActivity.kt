package com.example.racing_assignment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playButtons = findViewById<Button>(R.id.buttons)
        val playSensors = findViewById<Button>(R.id.sensors)
        val playRecords = findViewById<Button>(R.id.records)

        playButtons.setOnClickListener {
            val fragment = GameFragment().apply {
                arguments = Bundle().apply {
                    putBoolean("useButtons", true)
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        playSensors.setOnClickListener {
            val fragment = GameFragment().apply {
                arguments = Bundle().apply {
                    putBoolean("useButtons", false)
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        playRecords.setOnClickListener {
            val fragment = RecordsFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}