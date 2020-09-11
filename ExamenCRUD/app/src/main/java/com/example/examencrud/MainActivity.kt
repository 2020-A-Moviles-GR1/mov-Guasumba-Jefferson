package com.example.examencrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.core.os.HandlerCompat.postDelayed
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val urlPrincipal = "http://192.168.0.105:1337"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OperacionesMarcaAuto.datosMarcas.clear()
        OperacionesMarcaAuto.datosAutos.clear()
        obtenerMarcas()
        obtenerAutos()




        btn_ingresarMarca.setOnClickListener {

            irRegistrarMarca()
        }

        btn_mostrarMarcas.setOnClickListener {
        //TimeUnit.SECONDS.sleep(1L)

            irMostrarMarcas()
        }

        btn_mostrarAutos.setOnClickListener{

            irMostrarAutos()
        }

        btn_ingresarAuto.setOnClickListener {

            irRegistrarAuto()
        }

        btn_modificarMarca.setOnClickListener  {

            irModificarMarcas()
        }

        btn_modificarAuto.setOnClickListener {

            irModificarAutos()
        }

        btn_eliminarMarcaM.setOnClickListener {
            irEliminarMarcas()
        }

        btn_eliminarAuto.setOnClickListener {
            irEliminarAutos()
        }

    }


    fun irRegistrarMarca(){

        val intentExplicito= Intent(
            this,
            IngresarMarca::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }

    fun irRegistrarAuto(){

        val intentExplicito= Intent(
            this,
            IngresarAuto::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }



    fun irMostrarMarcas(){

        val intentExplicito= Intent(
            this,
            ListaMarcas::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)


    }

    fun irMostrarAutos(){

        val intentExplicito= Intent(
            this,
            ListaAutos::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)


    }

    fun irModificarMarcas(){


        val intentExplicito= Intent(
            this,
            ModifcarMarca::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)



    }

    fun irModificarAutos(){


        val intentExplicito= Intent(
            this,
            ModificarAutos::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)



    }

    fun irEliminarMarcas(){


        val intentExplicito= Intent(
            this,
            EliminarMarca::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)



    }

    fun irEliminarAutos(){


        val intentExplicito= Intent(
            this,
            EliminarAuto::class.java

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



    fun obtenerMarcas() {

        // var listaM: ArrayList<Marca> = arrayListOf()
        val url = urlPrincipal + "/marca"
        url

            .httpGet()
            .responseString { request, response, result ->

                when (result) {

                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-klaxon", "Data: ${data}")

                        val marcas = Klaxon()
                            .parseArray<Marca>(data)


                        if (marcas != null) {
                            marcas.forEach {
                                Log.i("http-klaxon", "\nNombre de la marca: ${it.marcas}\n")


                                OperacionesMarcaAuto.salvarMarca(
                                    it.id,
                                    it.createdAt,
                                    it.updatedAt,
                                    it.marcas,
                                    it.autos
                                )



                                if (it.autos is List<*>) {

                                    if (it.autos!!.size > 0) {


                                        it.autos!!.forEach {


                                            Log.i(
                                                "http-klaxon",
                                                "Identificador de marca: ${it.marca}      tipo de auto: ${it.tipo_auto}\n"
                                            )

                                        }
                                    }

                                }

                            }

                        }


                    }

                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")


                    }

                }
            }

        //Log.i("http-klaxon", "holaAhi: ${listaM}")
        //  return listaM


    }

    fun obtenerAutos(){

        val url = urlPrincipal + "/auto"

        url
            .httpGet()
            .responseString{

                    request, response, result ->

                when(result){

                    is Result.Success ->{

                        val data = result.get()

                        val autos = Klaxon().converter(Auto.convertidor).parseArray<Auto>(data)

                        if(autos != null){

                            autos.forEach{



                                Log.i("http-klaxon", "Nombre del auto: ${it.tipo_auto}      Marca-Auto: ${it.marca}\n")

                                OperacionesMarcaAuto.salvarAutos(it.id, it.createdAt, it.updatedAt, it.tipo_auto, it.isDisponible, it.costo_auto, it.marca)
                                
                            }

                        }



                    }

                    is Result.Failure ->{

                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                    }
                }

            }


    }

}