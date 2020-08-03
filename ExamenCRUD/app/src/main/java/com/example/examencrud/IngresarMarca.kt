package com.example.examencrud

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ingresar_marca.*
import java.sql.Date
import java.time.LocalDate

class IngresarMarca : AppCompatActivity() {

    var idMarca: Int = 0
    var nombreM: String = ""
    @RequiresApi(Build.VERSION_CODES.O)
    var fechaM: LocalDate = LocalDate.of(1,1,1)
    var diaM: Int = 0
    var mesM : Int = 0
    var anioM : Int = 0
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_marca)



        btn_guardarMarca.setOnClickListener {

            idMarca = txt_identificadorM.text.toString().toInt()


            nombreM = txt_nombreMarca.text.toString()


            diaM = txt_diaM.text.toString().toInt()



            mesM = txt_mesM.text.toString().toInt()


            anioM = txt_anioM.text.toString().toInt()



            fechaM = LocalDate.of(anioM, mesM, diaM)

            ingresarMarca()
        }

    }

    fun ingresarMarca(){

    OperacionesMarcaAuto.ingresarMarca(idMarca, nombreM, fechaM)
    irListaMarca()



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


    fun irListaMarca(){

        val intentExplicito= Intent(
            this,
            ListaMarcas::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }


}


