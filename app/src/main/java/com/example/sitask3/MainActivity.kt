package com.example.sitask3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var heroArrayList : ArrayList<Hero>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myRecyclerView = findViewById(R.id.recyclerView)

        val heroImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img13,
            R.drawable.img14,
            R.drawable.img15,
            R.drawable.img16,

        )

        val heroNameArray = arrayOf(
            "Ant Man",
            "Black Panther",
            "Black Widow",
            "Captian America",
            "Captian Marvel",
            "Doctor Strange",
            "Groot",
            "Hawkeye",
            "Hulk",
            "Iron Man",
            "Rocket Racoon",
            "Scarlett Witch",
            "Spider Man",
            "Star Lord",
            "Thor",
            "Vision",
        )

        val heroDataArray = arrayOf()

        myRecyclerView.layoutManager = LinearLayoutManager(this)

        heroArrayList = arrayListOf()

        for (index in heroImageArray.indices){
            val hero = Hero(heroNameArray[index], heroImageArray[index])
            heroArrayList.add(hero)
        }

        val myAdapter = MyAdapter(heroArrayList, this)
        myRecyclerView.adapter = myAdapter

    }
}