package com.example.examencrud

import java.sql.Date
import java.time.LocalDate

class Marca(var id_marcas:Int, var marcas: String, var fechaIngreso: LocalDate) {

    override fun toString(): String {

      return "${id_marcas},${marcas},${fechaIngreso}"


    }

}