package com.example.moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //llamada a la funcion
        setContentView(R.layout.activity_main)
       Log.i("Activity", "OnCreate")


        btn_ciclo_vida.setOnClickListener { boton ->

            irCicloDeVida()

       }

        btn_list_view.setOnClickListener { boton ->

            irListView()

        }

        btn_intent_respuesta.setOnClickListener { boton ->

            irAIntentConRespuesta()
        }

    }

    fun irAIntentConRespuesta(){
        val intentExplicito = Intent(
            this,
            IntentEnviaParametros::class.java
        )
        intentExplicito.putExtra("numero", 2)
        startActivity(intentExplicito)

    }


    fun irCicloDeVida(){

        val intentExplicito= Intent(
            this,
            CicloVida::class.java

        )

       // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }

    fun irListView(){

        val intentExplicito= Intent(
            this,
            BListViewActivity::class.java

        )

        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }








}