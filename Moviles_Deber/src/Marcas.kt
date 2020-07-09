import java.time.LocalDate

class Marcas(var id_marcas:Int, var marcas: String, var fechaIngreso: LocalDate, var isNacional: Boolean, var valoracion: Double) {

    companion object {
        fun insertarDatos(id_marcas:Int, marcas: String, fechaIngreso: LocalDate, isNacional: Boolean, valoracion: Double) {

            datosMarcas.add(arrayListOf(id_marcas,marcas, fechaIngreso, isNacional, valoracion))
        }
    }

    override fun toString(): String {

       val objetoArreglado = "${id_marcas},${marcas},${fechaIngreso},${isNacional},${valoracion}"

        return  objetoArreglado

    }

}






