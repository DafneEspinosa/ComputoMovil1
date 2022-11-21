package com.example.espinosafloresdafnejanetapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

public class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bundle = intent.extras

        val edad = bundle?.getString("edad", "")
        val NumCuenta = bundle?.getInt("NumCuenta", 0)
        val Fecha = bundle?.getString("Fecha", "")
        val nombre = bundle?.getString("nombre", "")
        val correoE = bundle?.getString("correoE", "")
        Toast.makeText(this, "El nombre es: $nombre", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "La fecha de nacimiento es: $Fecha", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "El número de cuenta es: $NumCuenta", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "El correo es: $correoE", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "La edad es: $edad", Toast.LENGTH_LONG).show()
    }

    fun click(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

}