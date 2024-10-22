package com.example.sitask3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HeroDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hero_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val heroName = intent.getStringExtra("heroName")
        val heroImage = intent.getIntExtra("heroImage", R.drawable.img13)
        val heroDetails = intent.getStringExtra("heroDetails")

        val TVheroName = findViewById<TextView>(R.id.heroTitle)
        val TVheroDetails = findViewById<TextView>(R.id.heroDetails)
        val IVheroImage = findViewById<ImageView>(R.id.heroImage)

        TVheroName.text = heroName
        TVheroDetails.text = heroDetails
        IVheroImage.setImageResource(heroImage)

    }
}