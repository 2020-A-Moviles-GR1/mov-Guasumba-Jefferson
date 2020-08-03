package com.example.moviles

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_b_list_view.*

class BListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_list_view)
        val listaEntrenadores = arrayListOf<Entrenador>()

        listaEntrenadores.add(Entrenador("Jeff" , "Guasumba"))
        listaEntrenadores.add(Entrenador("Jairo" , "Chancusig"))
        listaEntrenadores.add(Entrenador("Alex" , "Vilatuña"))
        listaEntrenadores.add(Entrenador("Victor" , "Lopez"))
        listaEntrenadores.add(Entrenador("Jeff" , "Perez"))

        val adaptador = ArrayAdapter(
            this, //contexto
            android.R.layout.simple_list_item_1, //Nombre Layout
            listaEntrenadores //lista

        )


        lv_numeros.adapter = adaptador
                lv_numeros
            .onItemClickListener = AdapterView.OnItemClickListener{
            parent, view, position, id ->
            Log.i("list-view", "Posicion $position")

        }

        btn_aniadir_entrenador
            .setOnClickListener {
                aniadirEntrenador(adaptador, listaEntrenadores)

            }





    }

    fun aniadirEntrenador(adaptador:ArrayAdapter<Entrenador>,
                          listaEntrenadores: ArrayList<Entrenador>){

        listaEntrenadores.add(Entrenador("Jeff" , "Lucero"))
        adaptador.notifyDataSetChanged()

    }
}