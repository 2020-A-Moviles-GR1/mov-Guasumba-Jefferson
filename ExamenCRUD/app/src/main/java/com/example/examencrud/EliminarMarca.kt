package com.example.examencrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_eliminar_marca.*
import kotlinx.android.synthetic.main.activity_lista_marcas.*
import java.util.concurrent.TimeUnit

class EliminarMarca : AppCompatActivity() {

    val urlPrincipal = "http://192.168.0.105:1337"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_marca)

        val listaM = OperacionesMarcaAuto.datosMarcas

        val adapter: ArrayAdapter<Marca> =
            ArrayAdapter<Marca>(this, android.R.layout.simple_list_item_1, listaM)

        lv_eliminarMarcas.setAdapter(adapter);


        val listaA = OperacionesMarcaAuto.datosAutos

        val adapter1: ArrayAdapter<Auto> =
            ArrayAdapter<Auto>(this, android.R.layout.simple_list_item_1, listaA)

        lv_eliminarMarcasAutos.setAdapter(adapter1);


        btn_eliminarMarcaM.setOnClickListener {

            quitarMarca(txt_identificadorMarcaParaEliminar.text.toString())


            irMenu()
            TimeUnit.SECONDS.sleep(3L)

            eliminarMarca()

        }

        btn_menuEliminarMarca.setOnClickListener {

            irMenu()
        }


    }

    fun quitarMarca(idM: String){

        val url= urlPrincipal + "/marca/"+idM
        val parametrosMarca = null

        url.httpDelete(parametrosMarca)
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

    fun eliminarMarca(){

        val intentExplicito= Intent(
            this,
            EliminarMarca::class.java

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