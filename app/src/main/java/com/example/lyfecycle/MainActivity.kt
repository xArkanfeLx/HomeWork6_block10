package com.example.lyfecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var sizeTextET:EditText
    private lateinit var massTextET:EditText
    private lateinit var resultBTN:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sizeTextET=findViewById(R.id.sizeTextET)
        massTextET=findViewById(R.id.massTextET)
        resultBTN=findViewById(R.id.resultBTN)

        resultBTN.setOnClickListener(){
            if(sizeTextET.text.isEmpty() || massTextET.text.isEmpty()) return@setOnClickListener
            val intent = Intent(this,SecondActivity::class.java)
            val size = sizeTextET.text.toString().toFloat()/100
            val mass = massTextET.text.toString().toFloat()
            if(size<=0.0 || mass<=0.0) return@setOnClickListener
            intent.putExtra("indexMass",getIndexMass(size,mass))
            startActivity(intent)
        }
    }

    private fun getIndexMass(size:Float,mass:Float):String {
        return (Math.round((mass/(size*size))*100.0)/100.0).toString()
    }
}