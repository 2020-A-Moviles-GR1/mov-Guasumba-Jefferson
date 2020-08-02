package com.example.examencrud

import java.sql.Date
import java.time.LocalDate

class Auto(var id_marca:Int, var id_auto:Int, var tipo_auto: String, var fecha_lanzamiento: LocalDate, var isDisponible: Boolean, var costo_auto: Double) {


    override fun toString(): String {

        return  "${id_marca},${id_auto},${tipo_auto},${fecha_lanzamiento},${isDisponible}, ${costo_auto}"


    }

}