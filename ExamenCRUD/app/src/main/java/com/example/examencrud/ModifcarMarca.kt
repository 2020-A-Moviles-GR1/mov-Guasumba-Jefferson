package com.example.examencrud

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_marcas.*
import kotlinx.android.synthetic.main.activity_modifcar_marca.*
import java.time.LocalDate
import java.util.concurrent.TimeUnit

class ModifcarMarca : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.105:1337"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modifcar_marca)

        val listaM = OperacionesMarcaAuto.datosMarcas

        val adapter: ArrayAdapter<Marca> =
            ArrayAdapter<Marca>(this, android.R.layout.simple_list_item_1, listaM)

        lv_modificarM.setAdapter(adapter);

        btn_actualizarMarca.setOnClickListener {



            modificarMarca(txt_idMparaMod.text.toString(),txt_nuevoMarca.text.toString())

            irMenu()
            TimeUnit.SECONDS.sleep(3L)
            guardarMarca()

        }

        btn_menuMod.setOnClickListener {
            irMenu()
        }


    }


    fun modificarMarca(idM: String, marca: String){

        val url= urlPrincipal + "/marca/"+idM
        val parametrosMarca = listOf(

            "marcas" to marca

        )

        url.httpPut(parametrosMarca)
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




    fun guardarMarca(){

        val intentExplicito= Intent(
            this,
            ModifcarMarca::class.java

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


}