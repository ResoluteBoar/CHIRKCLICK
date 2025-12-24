package ru.vipuzis.chirkovaclick

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.shop)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val achiveButton = findViewById<ImageView>(R.id.achiveButton)
        val achive = Intent(this, AchiveActivity::class.java)
        achiveButton.setOnClickListener {
            startActivity(achive)
        }
        val homeButton = findViewById<ImageView>(R.id.homeButton)
        val home = Intent(this, MainActivity2::class.java)
        homeButton.setOnClickListener {
            startActivity(home)
        }
    }
}