package com.example.examencrud

import android.util.Log
import android.widget.ArrayAdapter
import java.sql.Date
import java.time.LocalDate
import com.example.examencrud.ListaMarcas as ListaMarcas1

class OperacionesMarcaAuto {
    companion object{
    var datosAutos: ArrayList<Auto> = arrayListOf()
    var datosMarcas: ArrayList<Marca> = arrayListOf()







        fun salvarMarca(idM: Int, up: Long, up2: Long, marcas: String, auto:ArrayList<Auto>?) {

            datosMarcas.add(Marca(idM, up, up2, marcas, auto))
            Log.i("http-klaxon", "holadefinitivo: ${datosMarcas}")


        }
        fun salvarAutos(  id: Int,
                          createdAt:Long,
                          updatedAt:Long,
                          tipo_auto: String,
                          isDisponible: Boolean,
                          costo_auto: Number,
                          marca:Any?){

            datosAutos.add(Auto(id, createdAt,updatedAt ,tipo_auto, isDisponible, costo_auto, marca))


        }


    }




}