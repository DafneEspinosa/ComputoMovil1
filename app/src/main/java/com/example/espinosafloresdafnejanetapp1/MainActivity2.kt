package com.example.espinosafloresdafnejanetapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

public class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bundle = intent.extras

        val edad = bundle?.getString("edad", "")
        val NumCuenta = bundle?.getInt("NumCuenta", 0).toString()
        val Fecha = bundle?.getString("Fecha", "")
        val nombre = bundle?.getString("nombre", "")
        val correoE = bundle?.getString("correoE", "")


        val PARANOM = findViewById<TextView>(R.id.tvPARANOM)
        PARANOM.setText(nombre)
        val PARAFEC = findViewById<TextView>(R.id.tvPARAFEC)
        PARAFEC.setText(Fecha)
        val PARACUE = findViewById<TextView>(R.id.tvPARACUE)
        PARACUE.setText(NumCuenta)
        val PARCORR = findViewById<TextView>(R.id.tvPARACORR)
        PARCORR.setText(correoE)
        val PARAEDAD = findViewById<TextView>(R.id.tvPARAEDAD)
        PARAEDAD.setText(edad)



    }

    fun click(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }


}