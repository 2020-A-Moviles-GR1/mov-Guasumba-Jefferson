import java.time.LocalDate


class Autos(var id_marca:Int, var id_auto:Int, var tipo_auto: String, var fecha_lanzamiento: LocalDate, var isDisponible: Boolean, var costo_auto: Double) {

    companion object {
        fun insertarDatos(id_marca:Int,id_auto:Int, tipo_auto: String, fecha_lanzamiento: LocalDate, isDisponible: Boolean, costo_auto: Double) {

            datosAutos.add(arrayListOf(id_marca,id_auto,tipo_auto, fecha_lanzamiento, isDisponible, costo_auto))
        }
    }

    override fun toString(): String {

        val objetoArreglado = "${id_marca},${id_auto},${tipo_auto},${fecha_lanzamiento},${isDisponible}, ${costo_auto}"

        return  objetoArreglado

    }
}




