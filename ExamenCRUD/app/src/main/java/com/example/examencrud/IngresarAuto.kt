package com.example.examencrud

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_ingresar_auto.*
import java.time.LocalDate
import java.util.concurrent.TimeUnit

class IngresarAuto : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.105:1337"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_auto)



        btn_guardarAuto.setOnClickListener {


            ingresarAuto(txt_idMarcaA.text.toString().toInt(), txt_modelo.text.toString(), validarBooleano(txt_disponible.text.toString()),
                txt_precio.text.toString().toDouble())


            irMenu()
            TimeUnit.SECONDS.sleep(3L)

            guardarAuto()

        }


    }



    fun ingresarAuto(idMarca: Int, tipoA: String, isDisponible: Boolean, costo: Number){

        val url= urlPrincipal + "/auto"
        val parametrosAuto = listOf(

            "marca" to idMarca,
            "tipo_auto" to tipoA,
            "isDisponible" to isDisponible,
            "costo_auto" to costo

        )

        url.httpPost(parametrosAuto)
            .responseString{

                    request, response, result ->
                when(result) {
                    is Result.Failure -> {

                        val error = result.getException()
                        Log.i("http-klaxon","Error: ${error}")
                    }
                    is Result.Success ->{
                        val autoString = result.get()
                        Log.i("http-klaxon", "${autoString}")
                    }
                }
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

    fun irMenu(){

        val intentExplicito= Intent(
            this,
            MainActivity::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)

    }

}