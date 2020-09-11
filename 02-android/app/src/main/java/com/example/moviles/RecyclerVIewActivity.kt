package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recycler_v_iew.*

class RecyclerVIewActivity : AppCompatActivity() {
    var numeroLikes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_v_iew)

        val listaUsuarios = arrayListOf<UsuarioHttp>()
        listaUsuarios.add(
            UsuarioHttp(

            1,
            123123123,
            123123123,
            "1724294127",
            "jefferson",
        "jeff@hotmail.com",
            "Soltero",
            "jeff1234",
            arrayListOf<PokemonHttp>()

        )
        )


        listaUsuarios.add(
            UsuarioHttp(

                2,
                987123123,
                567123123,
                "1724784127",
                "guadalupe",
                "guada@hotmail.com",
                "Soltera",
                "guada1234",
                arrayListOf<PokemonHttp>()

            )
        )


        listaUsuarios.add(
            UsuarioHttp(

                3,
                123678123,
                123123345,
                "1724209872",
                "juan",
                "juan@hotmail.com",
                "Soltero",
                "juan1234",
                arrayListOf<PokemonHttp>()

            )
        )

        iniciarRecyclerView(
            listaUsuarios,
            this,
            rv_usuarios
        )



    }

    fun iniciarRecyclerView(
      lista: List<UsuarioHttp>,
      actividad: RecyclerVIewActivity,
      recycler_view: androidx.recyclerview.widget.RecyclerView

    ){
        val adaptadorUsuario = RecyclerAdaptador(
            lista,
            actividad,
            recycler_view
        )
        rv_usuarios.adapter = adaptadorUsuario
        rv_usuarios.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_usuarios.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        adaptadorUsuario.notifyDataSetChanged()
    }

    fun aniadirLikesenActividad(numero: Int){
        this.numeroLikes = this.numeroLikes + numero
        tv_titulo_rv.text = numeroLikes.toString()

    }
}