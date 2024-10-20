package com.example.lyfecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var resultTV: TextView
    private lateinit var imageIV: ImageView
    private lateinit var revomendationsTV: TextView
    private lateinit var returnBTN: Button
    private lateinit var images: List<Int>
    private var RecommendationText = RecommendationText()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultTV = findViewById(R.id.resultTV)
        imageIV = findViewById(R.id.imageIV)
        revomendationsTV = findViewById(R.id.revomendationsTV)
        returnBTN = findViewById(R.id.returnBTN)

        returnBTN.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        images = listOf(R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5)

        val result = intent.getStringExtra("indexMass")
        resultTV.text = result
        getInfoIM(result.toString().toFloat())

    }

    private fun getInfoIM(result: Float) {
        when (result) {
            in 0.0..18.5 -> changeImage(0)
            in 18.6..25.0 -> changeImage(1)
            in 25.0..30.0 -> changeImage(2)
            in 30.0..35.0 -> changeImage(3)
            else -> changeImage(4)
        }
    }

    private fun changeImage(num: Int) {
        //imageIV.setBackgroundResource(images[num])
        imageIV.setImageResource(images[num])
        changeTextRecomendation(num)
    }

    private fun changeTextRecomendation(value:Int) {
        revomendationsTV.text = RecommendationText.texts[value]
    }

}