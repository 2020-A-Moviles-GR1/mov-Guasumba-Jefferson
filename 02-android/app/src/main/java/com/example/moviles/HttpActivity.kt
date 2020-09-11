package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import kotlinx.android.synthetic.main.activity_http.*
//import javax.xml.transform.Result
import com.github.kittinunf.result.Result
class HttpActivity : AppCompatActivity() {

    val urlPrincipal = "http://192.168.0.105:1337"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        btn_obtener.setOnClickListener {

            obtenerUsuarios()
            Log.i("http-klaxon", "GET Pokemons")
            obtenerPokemons()
        }

        btn_crear.setOnClickListener {
            crearUsuario()
        }

    }

    fun crearUsuario(){

        val url= urlPrincipal + "/Usuario"
        val parametrosUsuario = listOf(
            "cedula" to "33242774127",
            "nombre" to "Jefferson",
            "correo" to "jeff@hotmail.com",
            "estadoCivil" to "Casado",
            "password" to "PASSword1"
        )

        url.httpPost(parametrosUsuario)
            .responseString{

                request, response, result ->
                when(result) {
                    is Result.Failure -> {

                        val error = result.getException()
                        Log.i("http-klaxon","Error: ${error}")
                    }
                    is Result.Success ->{
                    val usuarioString = result.get()
                    Log.i("http-klaxon", "${usuarioString}")
                }
                }
            }



    }

    fun obtenerUsuarios(){
        val pokemonString = """
        {
        "createdAt": 1597671444841,
        "updatedAt": 1597672206086,
        "id": 1,
        "nombre": "Pikachu",
        "usuario": 1
      }
    """.trimIndent()

        val pokemonInstancia = Klaxon()
            .parse<PokemonHttp>(pokemonString)

        if(pokemonInstancia != null) {
            Log.i("http-klaxon ","Nombre: ${pokemonInstancia.nombre}")
            Log.i("http-klaxon ","Nombre: ${pokemonInstancia.fechaCreacion}")
        }

        val url= urlPrincipal + "/Usuario"
        url

            .httpGet()
            .responseString { request, response, result ->

                when(result){

                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-klaxon","Data: ${data}")

                        val usuarios = Klaxon()
                            .parseArray<UsuarioHttp>(data)
                    

                        if(usuarios != null){
                            usuarios.forEach{
                                Log.i("http-klaxon", "\nNombre del usuario: ${it.nombre}\n")


                                if(it.pokemons is List<*>){

                                    if(it.pokemons!!.size > 0){


                                        it.pokemons!!.forEach{



                                            Log.i("http-klaxon", "Identificador de usuario: ${it.usuario}      Pokemon de Usuario: ${it.nombre}\n")

                                        }
                                    }

                                }

                            }

                        }


                    }

                    is Result.Failure ->{
                        val ex =  result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")


                    }

                }
            }



    }

    fun obtenerPokemons(){

        val url = urlPrincipal + "/pokemon"

        url
            .httpGet()
            .responseString{

                request, response, result ->

                when(result){

                    is Result.Success ->{

                        val data = result.get()

                        val pokemons = Klaxon().converter(PokemonHttp.convertidor).parseArray<PokemonHttp>(data)

                        if(pokemons != null){

                            pokemons.forEach{

                                Log.i("http-klaxon", "Nombre del Pokemon: ${it.nombre}      Usuario-Pokemon: ${it.usuario}\n")
                            }

                        }



                }

                    is Result.Failure ->{

                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                    }
                }

            }


    }


}