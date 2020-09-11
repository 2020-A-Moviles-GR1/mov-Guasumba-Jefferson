package com.example.examencrud

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_ingresar_marca.*
import java.sql.Date
import java.time.LocalDate
import java.util.concurrent.TimeUnit

class IngresarMarca : AppCompatActivity() {

    val urlPrincipal = "http://192.168.0.105:1337"

    var nombreM: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_marca)



        btn_guardarMarca.setOnClickListener {




            nombreM = txt_nombreMarca.text.toString()




            ingresarMarca(nombreM)

            irMenu()

            TimeUnit.SECONDS.sleep(3L)
            irListaMarca()
        }

    }

    fun ingresarMarca(nombreM: String){

        val url= urlPrincipal + "/marca"
        val parametrosMarca = listOf(

            "marcas" to nombreM

        )

        url.httpPost(parametrosMarca)
            .responseString{

                    request, response, result ->
                when(result) {
                    is Result.Failure -> {

                        val error = result.getException()
                        Log.i("http-klaxon","Error: ${error}")
                    }
                    is Result.Success ->{
                        val marcaString = result.get()
                        Log.i("http-klaxon", "${marcaString}")
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


    fun irListaMarca(){

        val intentExplicito= Intent(
            this,
            ListaMarcas::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
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


