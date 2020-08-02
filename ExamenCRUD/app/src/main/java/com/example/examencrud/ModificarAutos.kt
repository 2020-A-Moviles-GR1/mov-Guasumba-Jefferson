package com.example.examencrud

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_modifcar_marca.*
import kotlinx.android.synthetic.main.activity_modificar_autos.*
import java.time.LocalDate

class ModificarAutos : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_autos)


        val listaA = OperacionesMarcaAuto.datosAutos

        val adapter: ArrayAdapter<Auto> =
            ArrayAdapter<Auto>(this, android.R.layout.simple_list_item_1, listaA)

        lv_modificarAutos.setAdapter(adapter);


        btn_actualizarAuto.setOnClickListener {


            OperacionesMarcaAuto.modificarAutos(txt_modeloModificar.text.toString(),
            txt_nuevoIDMarcaAuto.text.toString().toInt(),
            txt_nuevoIdAuto.text.toString().toInt(),
            txt_nuevoModeloA.text.toString(),
            LocalDate.of(txt_nuevoAnioA.text.toString().toInt(), txt_nuevoMesA.text.toString().toInt(), txt_nuevoDiaA.text.toString().toInt()),
            validarBooleano(txt_nuevoDisponible.text.toString()),
            txt_nuevoPrecioA.text.toString().toDouble())
            guardarAuto()
        }

        btn_menuPrincipalModAuto.setOnClickListener {
            irMenu()
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