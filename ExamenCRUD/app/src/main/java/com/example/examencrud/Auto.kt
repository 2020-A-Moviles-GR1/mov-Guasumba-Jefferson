package com.example.examencrud

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import java.lang.Error
import java.sql.Date
import java.time.LocalDate

class Auto(
            var id: Int,
            var createdAt:Long,
            var updatedAt:Long,
           var tipo_auto: String,
           var isDisponible: Boolean,
           var costo_auto: Number,
            var marca:Any?

            ) {


    var fechaCreacion: java.util.Date
    var fechaActualizacion: java.util.Date

    init {
        fechaCreacion= java.util.Date(createdAt)
        fechaActualizacion= java.util.Date(updatedAt)
    }





    companion object{
        val convertidor = object : Converter {

            override fun canConvert(cls: Class<*>) = cls == Auto::class.java

            override fun toJson(value: Any): String {
                val auto = value as Auto

                val marca: Any?

                if (auto.marca is Marca){

                    marca = Klaxon().toJsonString(auto.marca as Marca)

                }else if(auto.marca is Int){

                    marca= auto.marca


                }else{

                    throw Error("No se puede convertir")

                }

                return """
                    {
                    "id": ${auto.id}
                    "createdAt": ${auto.createdAt}
                    "updatedAt": ${auto.updatedAt}
                    "tipo_auto": ${auto.tipo_auto}
                    "isDisponible": ${auto.isDisponible}
                    "costo_auto": ${auto.costo_auto}
                    "marca": ${marca}
                    }


                """.trimMargin()
            }

            override fun fromJson(jv: JsonValue): Auto {

                if(jv.obj?.get("marca") is JsonObject){

                    return Auto(
                        jv.objInt("id"),
                        jv.obj?.get("createdAt") as Long,
                        jv.obj?.get("updatedAt") as Long,
                        jv.objString("tipo_auto"),
                        jv.obj?.get("isDisponible") as Boolean,
                        jv.obj?.get("costo_auto") as Number,

                        Klaxon().parseFromJsonObject<Marca>(jv.obj?.get("marca") as JsonObject)


                    )
                }else if(jv.obj?.get("marca") is Int){

                    return Auto(
                        jv.objInt("id"),
                        jv.obj?.get("createdAt") as Long,
                        jv.obj?.get("updatedAt") as Long,
                        jv.objString("tipo_auto"),
                        jv.obj?.get("isDisponible") as Boolean,
                        jv.obj?.get("costo_auto") as Number,
                        jv.objInt("marca")


                    )
                }else{

                    throw Error ("No se puede Convertir")
                }

            }

        }



    }

    override fun toString(): String {

        return "${id},${createdAt},${updatedAt},${tipo_auto},${isDisponible},${costo_auto},${marca}"


    }

}