package com.example.examencrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_eliminar_auto.*
import kotlinx.android.synthetic.main.activity_lista_marcas.*
import java.util.concurrent.TimeUnit

class EliminarAuto : AppCompatActivity() {

    val urlPrincipal = "http://192.168.0.105:1337"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_auto)

        val listaA = OperacionesMarcaAuto.datosAutos

        val adapter: ArrayAdapter<Auto> =
            ArrayAdapter<Auto>(this, android.R.layout.simple_list_item_1, listaA)

        lv_eliminarAutos.setAdapter(adapter);

        btn_eliminarAutoV.setOnClickListener {


            quitarAuto(txt_identificadorAutoParaEliminar.text.toString())


            irMenu()
            TimeUnit.SECONDS.sleep(3L)

            eliminarAuto()
        }

        btn_menuPrincipalEliminarAuto.setOnClickListener {

            irMenu()
        }




    }


    fun quitarAuto(idA: String){

        val url= urlPrincipal + "/auto/"+idA
        val parametrosAuto = null

        url.httpDelete(parametrosAuto)
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

    fun eliminarAuto(){


        val intentExplicito= Intent(
            this,
            EliminarAuto::class.java

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