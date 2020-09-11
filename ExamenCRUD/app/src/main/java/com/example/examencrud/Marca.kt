package com.example.examencrud

import java.sql.Date
import java.time.LocalDate

class Marca(var id:Int,
            var createdAt:Long,
            var updatedAt:Long,
            var marcas: String,
            var autos: ArrayList<Auto>? = null
) {


    var fechaCreacion: java.util.Date
    var fechaActualizacion: java.util.Date

    init {
        fechaCreacion= java.util.Date(createdAt)
        fechaActualizacion= java.util.Date(updatedAt)
    }


    override fun toString(): String {

      return "${id},${createdAt},${updatedAt},${marcas},${autos}"


    }

}