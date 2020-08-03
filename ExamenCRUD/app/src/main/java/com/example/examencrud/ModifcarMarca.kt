package com.example.examencrud

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_lista_marcas.*
import kotlinx.android.synthetic.main.activity_modifcar_marca.*
import java.time.LocalDate

class ModifcarMarca : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modifcar_marca)

        val listaM = OperacionesMarcaAuto.datosMarcas

        val adapter: ArrayAdapter<Marca> =
            ArrayAdapter<Marca>(this, android.R.layout.simple_list_item_1, listaM)

        lv_modificarM.setAdapter(adapter);

        btn_actualizarMarca.setOnClickListener {

            OperacionesMarcaAuto.modificarMarcas(txt_marcaModificar.text.toString(),
            txt_nuevoIdM.text.toString().toInt(),
            txt_nuevoMarca.text.toString(),
            LocalDate.of(txt_nuevoAnioM.text.toString().toInt(), txt_nuevoMesM.text.toString().toInt(), txt_nuevoDiaM.text.toString().toInt())
            )

            guardarMarca()

        }

        btn_menuMod.setOnClickListener {
            irMenu()
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