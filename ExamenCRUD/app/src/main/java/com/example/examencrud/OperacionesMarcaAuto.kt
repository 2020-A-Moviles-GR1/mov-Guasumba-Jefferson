package com.example.examencrud

import android.widget.ArrayAdapter
import java.sql.Date
import java.time.LocalDate

class OperacionesMarcaAuto {



    companion object{
        var datosMarcas : ArrayList<Marca> = arrayListOf()
        var datosAutos : ArrayList<Auto> = arrayListOf()

        fun ingresarMarca( idM: Int, marca: String, fecha: LocalDate ){

            datosMarcas.add(Marca(idM, marca, fecha))


        }

        fun ingresarAuto(idMA: Int, idA: Int,modelo: String ,fechaL : LocalDate, isDisp: Boolean, precio: Double){

            datosAutos.add(Auto(idMA, idA,modelo ,fechaL, isDisp, precio))


        }




        fun modificarMarcas(marcan: String,idm:Int,  marcasn: String,  fechaIngreson: LocalDate){
            var index = buscarNombreMarca(marcan)


            datosMarcas[index].id_marcas = idm
            datosMarcas[index].marcas = marcasn
            datosMarcas[index].fechaIngreso = fechaIngreson



        }


        fun buscarNombreMarca(marcaS: String): Int {

            var elementoLista: List<Marca> =datosMarcas.filter { marca ->
                return@filter marca.marcas == marcaS
            }
            try {
                var index: Int = datosMarcas.indexOf(elementoLista[0])
                return index
            }catch (e: IndexOutOfBoundsException){
                return -1
            }

        }


        fun buscarNombreAuto(autoS: String): Int {

            var elementoLista: List<Auto> = datosAutos.filter { auto ->
                return@filter auto.tipo_auto == autoS
            }
            try {
                var index: Int = datosAutos.indexOf(elementoLista[0])


                return index
            }catch (e: IndexOutOfBoundsException){
                return -1
            }

        }


        fun modificarAutos(modeloA: String,idamn:Int, idan:Int  ,tipoauton: String,  fechan: LocalDate, isDisponiblen: Boolean,  precion: Double){
            var index = buscarNombreAuto(modeloA)

            datosAutos[index].id_marca = idamn
            datosAutos[index].id_auto = idan
            datosAutos[index].tipo_auto = tipoauton
            datosAutos[index].fecha_lanzamiento = fechan
            datosAutos[index].isDisponible = isDisponiblen
            datosAutos[index].costo_auto = precion

        }

        fun eliminarMarca(idMarca: Int){

            val indiceMarca = buscarIdMarca(idMarca)


                datosMarcas.removeAt(indiceMarca)
            eliminarMarcaAuto(idMarca)



        }


        fun buscarIdMarca(idM: Int) : Int{
            var elementoLista: List<Marca> = datosMarcas.filter { marca ->
                return@filter marca.id_marcas == idM
            }
            try {
                var index: Int = datosMarcas.indexOf(elementoLista[0])


                return index
            }catch (e: IndexOutOfBoundsException){
                return -1
            }



        }

        fun eliminarMarcaAuto(idMA: Int){

            var listaAutosEliminados: List<Auto> = datosAutos.filter {

                    auto ->
                return@filter auto.id_marca != idMA
            }

            datosAutos = listaAutosEliminados as ArrayList<Auto>



        }




        fun eliminarAuto(identificadorAuto: Int){

            var index  = buscarIdAuto(identificadorAuto)

            datosAutos.removeAt(index)


        }

        fun buscarIdAuto(idA: Int) : Int{
            var elementoLista: List<Auto> = datosAutos.filter { auto ->
                return@filter auto.id_auto == idA
            }
            try {
                var index: Int = datosAutos.indexOf(elementoLista[0])


                return index
            }catch (e: IndexOutOfBoundsException){
                return -1
            }



        }




    }













}