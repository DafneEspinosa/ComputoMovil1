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
        var CuantosAnios = binding.EdtFecha.text.toString()
        var FechaNac = binding.EdtFecha.text.toString()
        var NumCuent = binding.EdtCUENTA.text.toString().toInt()
        var nombreper = binding.EdtNOMBRE.text.toString()
        var correoElec = binding.EdtEMAIL.text.toString()

        val intent = Intent(this, MainActivity2::class.java)
        val parametros = Bundle()
        var edad = cumpleanios(CuantosAnios)
        var cuent = cuenta(NumCuent)
        var Fnac = FNACIMIENTO(FechaNac)
        var NamPer = NamePer(nombreper)
        var CoElect = CElec(correoElec)
        parametros.putString("edad", edad)
        parametros.putInt("NumCuenta", cuent)
        parametros.putString("Fecha", Fnac)
        parametros.putString("nombre", NamPer)
        parametros.putString("correoE", CoElect)

        intent.putExtras(parametros)




        if (binding.EdtNOMBRE.text.isNotEmpty()) {

        } else {
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.ParaErrorValor),
                Toast.LENGTH_SHORT
            )
            binding.EdtNOMBRE.error = getString(R.string.ParaErrorValor)
        }

        if (binding.EdtFecha.text.isNotEmpty()) {

            //var edad = cumpleanios(CuantosAnios)
            //binding.tvRESULTADO.text = edad
        } else {
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.ParaErrorValor),
                Toast.LENGTH_SHORT
            )
            binding.EdtFecha.error = getString(R.string.ParaErrorValor)
        }


        if (binding.EdtCUENTA.text.isNotEmpty()) {

        } else {
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.ParaErrorValor),
                Toast.LENGTH_SHORT
            )
            binding.EdtCUENTA.error = getString(R.string.ParaErrorValor)
        }

        if (binding.EdtEMAIL.text.isNotEmpty()) {

        } else {
            Toast.makeText(
                this@MainActivity,
                resources.getString(R.string.ParaErrorValor),
                Toast.LENGTH_SHORT
            )
            binding.EdtEMAIL.error = getString(R.string.ParaErrorValor)
        }
        startActivity(intent)

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