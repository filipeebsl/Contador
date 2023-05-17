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

    /***
     * Criar 2 onCreate. Um para tratar o outState (persistencia dos dados ao rotacionar a tela do app)
     * e outro onCreate para tratar o persistableBundle (persistencia dos dados ao reiniciar o aparelho)
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OnCreatedGeneral(savedInstanceState, null)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistableBundle: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        OnCreatedGeneral(savedInstanceState, persistableBundle)

    }

    private fun OnCreatedGeneral(savedInstanceState: Bundle?, persistableBundle: PersistableBundle?){
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("COUNTER", -1)
        }

        if(persistableBundle != null){
            count = persistableBundle.getInt("COUNTER", -1)
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
    override fun onSaveInstanceState(outState: Bundle, persistableBundle: PersistableBundle) {
        super.onSaveInstanceState(outState)
        //outState para persistir um dado somente quando o android mata, ex: rotação de tela
        outState.putInt("COUNTER", count)

        //persistableBundle para persistir um dado ao reiniciar o aparelho
        persistableBundle.putInt("COUNTER", count)
    }


}