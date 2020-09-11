package com.example.examencrud

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_marcas.*


class ListaMarcas : AppCompatActivity() {

    //val urlPrincipal = "http://192.168.0.105:1337"
    //var listaMar: ArrayList<Marca> = arrayListOf()


        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_lista_marcas)
         //   obtenerMarcas()


                val listaMar = OperacionesMarcaAuto.datosMarcas


                Log.i("http-klaxon", "hola4: ${listaMar}")

                val adapter: ArrayAdapter<Marca> =
                    ArrayAdapter<Marca>(this, android.R.layout.simple_list_item_1, listaMar)

                lv_Marcas.setAdapter(adapter);

                btn_menu.setOnClickListener {

                    irMenu()


                }
            }



        fun irMenu() {
            val intentExplicito = Intent(
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
            Log.i("Activity", "OnStop")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.i("Activity", "OnDestroy")
        }

    }

