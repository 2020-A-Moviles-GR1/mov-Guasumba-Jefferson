package com.example.examencrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_ingresarMarca.setOnClickListener {

            irRegistrarMarca()
        }

        btn_mostrarMarcas.setOnClickListener {
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



}