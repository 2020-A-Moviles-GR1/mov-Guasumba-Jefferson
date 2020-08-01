package com.example.moviles

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
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

        btn_intent_implicito.setOnClickListener { boton->
            enviarIntentConRespuesta()
        }


        btn_resp_propia.setOnClickListener { boton ->

            enviarConRespuestaPropia()

        }
    }

    fun enviarConRespuestaPropia(){
        val intentExplicito = Intent(
            this,
            IntentEnviaParametros::class.java
        )
        startActivityForResult(intentExplicito, 305)
    }

    fun enviarIntentConRespuesta(){
        val intentConRespuesta = Intent(

            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )

        //this.startActivityForResult(intent, codigo)
        //304 lo pusimos nosotros, no es un codigo en especial
        startActivityForResult(intentConRespuesta, 304)
    }

    override fun onActivityResult(
        requestCode: Int, //numero que envamos 304
        resultCode: Int,
        data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

         when (resultCode){
             RESULT_OK ->{

                 Log.i("resultado", "ok")
                 when (requestCode){

                     304 -> {//contactos

                         val uri = data?.data
                         if (uri != null) {
                             val cursor = contentResolver.query(
                                 uri,
                                 null,
                                 null,
                                 null,
                                 null,
                                 null
                             )
                             cursor?.moveToFirst()
                             val indiceTelefono = cursor?.getColumnIndex(
                                 ContactsContract.CommonDataKinds.Phone.NUMBER
                             )
                             val telefono = cursor?.getString(indiceTelefono!!)
                             cursor?.close()
                             Log.i("resultado", "Telefono: ${telefono}")
                         }





                     }
                     305 -> {
                         if(data != null){
                             val nombre = data.getStringExtra("nombre")
                             val edad = data.getIntExtra("edad", 0)
                             Log.i("resultado", "Nombre: ${nombre} Edad: ${edad}")


                         }

                         
                     }
                 }

             }

             RESULT_CANCELED ->{

                 Log.i("resultado", "canceled")

             }

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