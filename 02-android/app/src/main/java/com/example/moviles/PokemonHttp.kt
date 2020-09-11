package com.example.moviles

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import java.lang.Error
import java.util.*

class PokemonHttp (

    val createdAt: Long,
    val updatedAt: Long,
    var id: Int,
    var nombre: String,
    var usuario:Any?

){
    var fechaCreacion:Date
    var fechaActualizacion: Date

    init {
        fechaCreacion=Date(createdAt)
        fechaActualizacion=Date(updatedAt)
    }



    companion object{
        val convertidor = object : Converter {

            override fun canConvert(cls: Class<*>) = cls == PokemonHttp::class.java

            override fun toJson(value: Any): String {
                val pokemon = value as PokemonHttp

                val usuario: Any?

                if (pokemon.usuario is UsuarioHttp){

                    usuario = Klaxon().toJsonString(pokemon.usuario as UsuarioHttp)

                }else if(pokemon.usuario is Int){

                    usuario= pokemon.usuario


                }else{

                    throw Error("No se puede convertir")

                }

                return """
                    {
                    "id": ${pokemon.id}
                    "createdAt": ${pokemon.createdAt}
                    "updatedAt": ${pokemon.updatedAt}
                    "nombre": ${pokemon.nombre}
                    "usuario": ${usuario}
                    }
                    
                    
                """.trimMargin()
            }

            override fun fromJson(jv: JsonValue): PokemonHttp {

                if(jv.obj?.get("usuario") is JsonObject){

                    return PokemonHttp(

                        jv.obj?.get("createdAt") as Long,
                        jv.obj?.get("updatedAt") as Long,
                        jv.objInt("id"),
                        jv.objString("nombre"),

                        Klaxon().parseFromJsonObject<UsuarioHttp>(jv.obj?.get("usuario") as JsonObject)


                    )
                }else if(jv.obj?.get("usuario") is Int){

                    return PokemonHttp(
                            jv.obj?.get("createdAt") as Long,
                            jv.obj?.get("updatedAt") as Long,
                            jv.objInt("id"),
                            jv.objString("nombre"),
                            jv.objInt("usuario")

                            )
                }else{

                    throw Error ("No se puede Convertir")
                }

            }

        }



    }
}