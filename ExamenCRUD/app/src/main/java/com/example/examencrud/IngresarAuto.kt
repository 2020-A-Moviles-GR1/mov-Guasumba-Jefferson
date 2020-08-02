package com.example.examencrud

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_ingresar_auto.*
import java.time.LocalDate

class IngresarAuto : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_auto)



        btn_guardarAuto.setOnClickListener {
            OperacionesMarcaAuto.ingresarAuto(txt_idMarcaA.text.toString().toInt(),
            txt_idAuto.text.toString().toInt(),
            txt_modelo.text.toString(),
            LocalDate.of(txt_anioA.text.toString().toInt(),txt_mesA.text.toString().toInt(), txt_diaA.text.toString().toInt()),
            validarBooleano(txt_disponible.text.toString()),
             txt_precio.text.toString().toDouble()

            )


            guardarAuto()

        }


    }



    override fun onStart() {
        super.onStart()
        Log.i("Activity", "OnStart")

    }


    override fun onResume() {
        super.onResume()
        Log.i("Activity", "OnResume")

    }

    override fun onPause() {
        super.onPause()
        Log.i("Activity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Activity",  "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity", "OnDestroy")
    }

    fun guardarAuto(){


        val intentExplicito= Intent(
            this,
            ListaAutos::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }


    fun validarBooleano(respuesta: String) : Boolean{

        return respuesta.equals("si")


    }

}