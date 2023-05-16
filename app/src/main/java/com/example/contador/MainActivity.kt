package com.example.contador

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("COUNTER", -1)
        }

        val tvNumber : TextView = findViewById(R.id.tvNumber)
        tvNumber.text=count.toString()
        val btnAdd : Button = findViewById(R.id.bntAdd)
        btnAdd.setOnClickListener {
            count++
            tvNumber.text = count.toString()
        }
        val btnToRemove : Button = findViewById(R.id.btnToRemove)
        btnToRemove.setOnClickListener {
            count --
            tvNumber.text = count.toString()
        }
        val btnClear : Button = findViewById(R.id.btnClear)
        btnClear.setOnClickListener {
            count = 0
            tvNumber.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNTER", count)
    }


}