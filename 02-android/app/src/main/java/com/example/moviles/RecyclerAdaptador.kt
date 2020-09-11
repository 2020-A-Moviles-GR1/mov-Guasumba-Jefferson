package com.example.moviles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//Para usar el recycler view necesitamos migrar a android x y colocal una dependencia
class RecyclerAdaptador(
    private val listaUsuarios: List<UsuarioHttp>,
    private val contexto: RecyclerVIewActivity,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerAdaptador.MyViewHolder>() {
    inner class MyViewHolder(view: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView
        val cedulaTextView: TextView
        val accionButton: Button
        val likesTextView: TextView
        var numeroLikes = 0

        init {
            nombreTextView = view.findViewById(R.id.tv_nombre)
            cedulaTextView = view.findViewById(R.id.tv_cedula)
            accionButton = view.findViewById(R.id.btn_accion)
            likesTextView = view.findViewById(R.id.tv_likes)
            accionButton.setOnClickListener {
                this.aniadirLikes()
            }

        }

        fun aniadirLikes() {
            this.numeroLikes = this.numeroLikes +1
            likesTextView.text = this.numeroLikes.toString()
            contexto.aniadirLikesenActividad(1)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecyclerAdaptador.MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.adaptador_persona,
                parent,
                false

            )
        return MyViewHolder(itemView)
    }

    //#de items que tenemos
    override fun getItemCount(): Int {

        return listaUsuarios.size

    }

    //Es una funcion que se va a ejecutar por cada uno de los items(iterable)
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {//posicion

        val usuario = listaUsuarios[position]
        holder.nombreTextView.text = usuario.nombre
        holder.cedulaTextView.text = usuario.cedula
        holder.accionButton.text = "like ${usuario.nombre}"

        holder.likesTextView.text = "0"
    }
}