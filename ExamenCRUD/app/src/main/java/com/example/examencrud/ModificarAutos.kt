package com.example.examencrud

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_modificar_autos.*
import java.time.LocalDate
import java.util.concurrent.TimeUnit

class ModificarAutos : AppCompatActivity() {
    val urlPrincipal = "http://192.168.0.105:1337"
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_autos)


        val listaA = OperacionesMarcaAuto.datosAutos

        val adapter: ArrayAdapter<Auto> =
            ArrayAdapter<Auto>(this, android.R.layout.simple_list_item_1, listaA)

        lv_modificarAutos.setAdapter(adapter);


        btn_actualizarAuto.setOnClickListener {


            modificarAuto(txt_idAutoMod.text.toString(), txt_nuevoIdMarca.text.toString().toInt(),
            txt_nuevoModeloA.text.toString(), validarBooleano(txt_nuevoDisponible.text.toString()), txt_nuevoPrecioA.text.toString().toDouble())

            irMenu()

            TimeUnit.SECONDS.sleep(4L)
            guardarAuto()

        }

        btn_menuPrincipalModAuto.setOnClickListener {
            irMenu()
        }

    }

    fun modificarAuto(idA: String, idMarca: Int,  tipoA: String, isDisponible: Boolean, costo: Number){

        val url= urlPrincipal + "/auto/"+idA
        val parametrosAuto = listOf(

            "marca" to idMarca,
            "tipo_auto" to tipoA,
            "isDisponible" to isDisponible,
            "costo_auto" to costo

        )

        url.httpPut(parametrosAuto)
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

    fun validarBooleano (respuesta: String) :Boolean{

        return respuesta.equals("si")

    }

    fun guardarAuto(){

        val intentExplicito= Intent(
            this,
            ModificarAutos::class.java

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