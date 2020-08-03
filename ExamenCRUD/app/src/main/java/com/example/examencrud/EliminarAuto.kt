package com.example.examencrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_eliminar_auto.*
import kotlinx.android.synthetic.main.activity_lista_marcas.*

class EliminarAuto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_auto)

        val listaA = OperacionesMarcaAuto.datosAutos

        val adapter: ArrayAdapter<Auto> =
            ArrayAdapter<Auto>(this, android.R.layout.simple_list_item_1, listaA)

        lv_eliminarAutos.setAdapter(adapter);

        btn_eliminarAutoV.setOnClickListener {

            OperacionesMarcaAuto.eliminarAuto(txt_identificadorAutoParaEliminar.text.toString().toInt())

            eliminarAuto()
        }

        btn_menuPrincipalEliminarAuto.setOnClickListener {

            irMenu()
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