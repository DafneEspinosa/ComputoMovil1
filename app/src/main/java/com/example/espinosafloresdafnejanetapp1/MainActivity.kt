package com.example.espinosafloresdafnejanetapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.example.espinosafloresdafnejanetapp1.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    fun click(view: View) {
        var i = 0
        if (binding.EdtCUENTA.text.isNotEmpty()) {
            i+=1
        } else {
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.ParaErrorValor),
                Toast.LENGTH_SHORT
            )
            binding.EdtCUENTA.error = getString(R.string.ParaErrorValor)
        }
        if (binding.EdtEMAIL.text.isNotEmpty()) {
            i+=1
        } else {
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.ParaErrorValor),
                Toast.LENGTH_SHORT
            )
            binding.EdtEMAIL.error = getString(R.string.ParaErrorValor)
        }
        if (binding.edtNEWFECHA.text.isNotEmpty()) {
            i+=1
        } else {
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.ParaErrorValor),
                Toast.LENGTH_SHORT
            )
            binding.edtNEWFECHA.error = getString(R.string.ParaErrorValor)
        }
        if (binding.EdtNOMBRE.text.isNotEmpty()) {

        } else {
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.ParaErrorValor),
                Toast.LENGTH_SHORT
            )
            binding.EdtNOMBRE.error = getString(R.string.ParaErrorValor)
        }




        if(binding.EdtNOMBRE.text.isNotEmpty() && binding.edtNEWFECHA.text.isNotEmpty() && binding.EdtEMAIL.text.isNotEmpty() && binding.EdtCUENTA.text.isNotEmpty()){
            val CuantosAnios = binding.edtNEWFECHA.text.toString()
            val FechaNac = binding.edtNEWFECHA.text.toString()
            val NumCuent = binding.EdtCUENTA.text.toString().toInt()
            val nombreper = binding.EdtNOMBRE.text.toString()
            val correoElec = binding.EdtEMAIL.text.toString()

            val edad = cumpleanios(CuantosAnios)
            val cuent = cuenta(NumCuent)
            val Fnac = FNACIMIENTO(FechaNac)
            val NamPer = NamePer(nombreper)
            val CoElect = CElec(correoElec)
            val intent = Intent(this, MainActivity2::class.java)
            val parametros = Bundle()
            parametros.putString("edad", edad)
            parametros.putInt("NumCuenta", cuent)
            parametros.putString("Fecha", Fnac)
            parametros.putString("nombre", NamPer)
            parametros.putString("correoE", CoElect)

            intent.putExtras(parametros)

            startActivity(intent)
        } else{}
    }


    fun cumpleanios(CuantosAnios: String): String {
        var fechaCumDate: Date = SimpleDateFormat("dd/MM/yyyy").parse(CuantosAnios)
        var fechaActualDate = Date(System.currentTimeMillis())
        var diferenciaFechasMili = fechaActualDate.getTime() - fechaCumDate.getTime()
        var segundos = diferenciaFechasMili / 1000
        var minutos = segundos / 60
        var horas = minutos / 60
        var dias = horas / 24
        var anios = dias / 365
        var EDAD = anios.toString()
        return EDAD
    }

    fun cuenta(NumCuent: Int): Int {
        return NumCuent
    }

    fun FNACIMIENTO(FechaNac: String): String {
        return FechaNac
    }

   fun NamePer(nombreper: String): String {
        return nombreper
    }

    fun CElec(correoElec: String): String {
        return correoElec
    }


}