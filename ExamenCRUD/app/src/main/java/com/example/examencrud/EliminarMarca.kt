package com.example.examencrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_eliminar_marca.*
import kotlinx.android.synthetic.main.activity_lista_marcas.*

class EliminarMarca : AppCompatActivity() {
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
            OperacionesMarcaAuto.eliminarMarca(txt_identificadorMarcaParaEliminar.text.toString().toInt())

            eliminarMarca()

        }

        btn_menuEliminarMarca.setOnClickListener {

            irMenu()
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