package ru.vipuzis.chirkovaclick

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    val mainVM: MainViewModel by viewModels()
    @SuppressLint("MissingInflatedId", "WrongViewCast", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button2 = findViewById<ImageView>(R.id.achiveButton)
        val texCount = findViewById<TextView>(R.id.count)

        mainVM.count.observe(this) {count ->
            texCount.text = count.toString()

        }
        button2.setOnClickListener {
            mainVM.plus()
        }
        val shopButton = findViewById<ImageView>(R.id.shopButton)
        val intent = Intent(this, MainActivity3::class.java)
        shopButton.setOnClickListener {
            startActivity(intent)
        }
        val achiveButton = findViewById<ImageView>(R.id.achiveButton)
        val achive = Intent(this, AchiveActivity::class.java)
        achiveButton.setOnClickListener {
            startActivity(achive)
        }
    }
}