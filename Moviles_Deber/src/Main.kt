import java.io.BufferedReader
import java.lang.Exception

import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.time.LocalDate
import kotlin.system.exitProcess


fun main (args:Array<String>){

  do {

      print("\n***********Bienvenido al sistema del Concesionario ingrese un número entero para escojer una opción del menú******* \n\n")
      print("1. Ingresar Marcas \n")
      print("2. Ingresar Autos \n")
      print("3. Mostrar Marcas \n")
      print("4. Mostrar Autos \n")
      print("5. Modificar Marcas \n")
      print("6. Modificar Autos \n")
      print("7. Eliminar Marcas \n")
      print("8. Eliminar Autos \n")
      print("9. Salir \n")

      print("\nIngrese un número:  ")
      var opc: Int = readLine()?.toInt() as Int
      menu(opc)

      print("\nDesea regresar al menú principal (s para si o cualquier tecla para no ) : ")
      var resp: String = readLine().toString()

  }while (resp == "s")



}

var datosMarcas = arrayListOf<Any>()
var datosAutos = arrayListOf<Any>()
var datosMarcasEspecial : ArrayList<Marcas> = arrayListOf()
var datosAutosEspecial : ArrayList<Autos> = arrayListOf()
var id_mar: Int = 0
var mar : String = ""
var anio : Int = 0
var mes : Int = 0
var dia : Int = 0
var feci : LocalDate = LocalDate.of(1,1,1)
var estado : String = ""
var valor : Double = 0.0
var respuesta : String = ""





fun menu(entrada: Int) {



    when (entrada) {
        1 -> ingresarDatosMarcas()
        2 -> ingresarDatosAutos()
        3 -> mostrarDatosMarcas()
        4 -> mostrarDatosAutos()
        5 -> modificacionMarca()
        6 -> modificacionAuto()
        7 -> eliminacionMarca()
        8 -> eliminacionAuto()
        else -> exitProcess(0)
    }
}




fun modificacionMarca(){

    print("\n Asegurese de ingresar un indice de una marca existente para modificar\n\n")
    mostrarDatosMarcas()
    print("\nIngrese el indice de la marca para actualizar\n\n")
    var idx: Int = readLine()?.toInt() as Int

    var id_marn : Int = 0
    do {


        print("\nIngresar el nuevo identificador de la marca como un número entero\n\n")
        id_marn = readLine()?.toInt() as Int
        if(validarMarcaID(id_mar) == true){

            print("\nEste identificador ya pertenece a otra marca, por favor ingrese otro identificador\n")
            mostrarDatosMarcas()
        }

    } while (validarMarcaID(id_mar) == true)



    print("\nIngrese la nueva marca del auto\n\n")
   var marn: String = readLine().toString()
    print("\nIngrese la nueva fecha de ingreso\n")
    print("\nIngrese el nuevo Año como un número entero\n")
    var anion: Int= readLine()?.toInt() as Int
    print("\nIngrese el nuevo mes como un numero entero\n")
    var mesn: Int = readLine()?.toInt() as Int
    print("\nIngrese el nuevo dia como un numero entero\n")
    var dian: Int = readLine()?.toInt() as Int
   var fecin = LocalDate.of(anion,mesn,dian)

    print("\nLa marca es nacional(escriba si o no)\n")
    var estadon: String = readLine().toString()

    print("\nIngrese la nueva valoración de la marca en el pais (Separar decimales con . ) \n")
    var valorn : Double = readLine()?.toDouble() as Double

    modificarMarcas(idx, id_marn, marn, fecin, validarBooleano(estadon), valorn)



}

fun modificacionAuto() {

    var id_marca_auto: Int = 0
    var id_auto: Int = 0

    print("\n Asegurese de ingresar un indice de un auto existente para modificar\n\n")
    mostrarDatosAutos()
    print("\nIngrese el indice del auto para actualizar\n\n")
    var idxn: Int = readLine()?.toInt() as Int

        print("\n Asegurese de ingresar el nuevo identificador de la marca para estas marcas existentes  \n")
        mostrarDatosMarcas()

        do {
            print("\nIngresar el nuevo identificador de la marca para este auto\n\n")
            id_marca_auto = readLine()?.toInt() as Int

            if (validarMarcaAutoID(id_marca_auto) == false) {

                print("\nEl identificador para esta marca no existe por favor ingrese un identificador para una marca existente\n\n")
                mostrarDatosMarcas()

            }

        } while (validarMarcaAutoID(id_marca_auto) == false)


        do {
            print("\nIngresar el nuevo identificador del auto\n\n")
            id_auto = readLine()?.toInt() as Int
            if (validarAutoID(id_auto) == true) {

                print("\nEste identificador ya pertenece a otro auto, por favor ingrese otro identificador\n\n")
                mostrarDatosAutos()

            }
        } while (validarAutoID(id_auto) == true)




        print("\nIngrese el nuevo tipo de auto\n\n")
        var tipo_auto: String = readLine().toString()
        print("\nIngrese la nueva fecha de lanzamiento\n")
        print("\nIngrese el nuevo Año\n")
        var anio_lanzamiento: Int = readLine()?.toInt() as Int
        print("\nIngrese el nuevo mes\n")
        var mes_lanzamiento: Int = readLine()?.toInt() as Int
        print("\nIngrese el nuevo dia\n")
        var dia_lanzamiento: Int = readLine()?.toInt() as Int
        var fecl = LocalDate.of(anio_lanzamiento, mes_lanzamiento, dia_lanzamiento)
        print("\nExisten ejemplares? (escribir si o no)\n")
        val ex_ejem = readLine().toString()

        print("\nIngrese el nuevo precio del auto (Separar decimales con . ) \n")
        val precio_auto = readLine()?.toDouble() as Double

        modificarAutos(idxn, id_marca_auto, id_auto, tipo_auto, fecl, validarBooleano(ex_ejem), precio_auto)

}


fun eliminacionMarca(){
do {


    var marcaid: Int = 0
    do {

        print("\nAsegurese de ingresar el id de una marca existente para eliminar \n\n")
        mostrarDatosMarcas()

        print("\n Ingrese el id de la marca apara eliminar:")
        marcaid = readLine()?.toInt() as Int


    } while (validarMarcaID(marcaid) == false)
    eliminarMarca(marcaid)
    eliminarMarcaAuto(marcaid)
    print("\nMarca eliminada exitosamente!!! \n\n")

    mostrarDatosMarcas()

    print("\nDesea eliminar otra marca (s para si o cualquier tecla para no)\n\n")
    var resp: String = readLine().toString()

}while (resp == "s")

}



fun eliminacionAuto(){
    do {


        var autoid: Int = 0
        do {

            print("\nAsegurese de ingresar el id de un auto existente para eliminar \n\n")
            mostrarDatosAutos()
            print("\n Ingrese el id del auto para eliminar:")
            autoid = readLine()?.toInt() as Int


        } while (validarAutoID(autoid) == false)
        eliminarAuto(autoid)
        print("\nAuto eliminado exitosamente!!! \n\n")
        mostrarDatosAutos()
        print("\nDesea eliminar otro auto (s para si o cualquier tecla para no)\n\n")
        var resp: String = readLine().toString()

    }while (resp == "s")



}




fun ingresarDatosMarcas(){
    do {


        do {


            print("\nIngresar el identificador de la marca como un número entero\n\n")
            id_mar = readLine()?.toInt() as Int
            if(validarMarcaID(id_mar) == true){

                print("\nEste identificador ya pertenece a otra marca, por favor ingrese otro identificador\n")
                mostrarDatosMarcas()
            }

        } while (validarMarcaID(id_mar) == true)



            print("\nIngrese la marca del auto\n\n")
            mar = readLine().toString()
            print("\nIngrese la fecha de ingreso\n")
            print("\nIngrese el Año como un número entero\n")
            anio= readLine()?.toInt() as Int
            print("\nIngrese el mes como un numero entero\n")
            mes = readLine()?.toInt() as Int
            print("\nIngrese el dia como un numero entero\n")
            dia = readLine()?.toInt() as Int
            feci = LocalDate.of(anio,mes,dia)
            print("\nLa marca es nacional(escriba si o no)\n")
            estado = readLine().toString()

            print("\nIngrese la valoración de la marca en el pais (Separar decimales con . ) \n")
            valor = readLine()?.toDouble() as Double
            datosMarcasEspecial.clear()
            datosMarcasEspecial.add(Marcas(id_mar, mar, feci, validarBooleano(estado),valor))
        guardarDatosMarcas()
        mostrarDatosMarcas()

        print("\nQuieres agregar autos a esta marca u alguna otra?(escribir si o no)\n")
        var respuesta1: String = readLine().toString()

        if (respuesta1 == "si") {

                ingresarDatosAutos()

        }


        print("\nQuieres agregar  otra marca (si o no?)\n")
        respuesta = readLine().toString()




    } while ( respuesta == "si")



}


fun ingresarDatosAutos(){
         var id_marca_auto: Int = 0
        var id_auto: Int = 0

    do {
        print("\n Asegurese de ingresar el identificador de la marca para estas marcas existentes  \n")
        mostrarDatosMarcas()

        do {
            print("\nIngresar el identificador de la marca para este auto\n\n")
            id_marca_auto = readLine()?.toInt() as Int

            if (validarMarcaAutoID(id_marca_auto) == false) {

                print("\nEl identificador para esta marca no existe por favor ingrese un identificador para una marca existente\n\n")
                mostrarDatosMarcas()

            }

        } while (validarMarcaAutoID(id_marca_auto) == false)


        do {
            print("\nIngresar el identificador del auto\n\n")
            id_auto = readLine()?.toInt() as Int
            if (validarAutoID(id_auto) == true) {

                print("\nEste identificador ya pertenece a otro auto, por favor ingrese otro identificador\n\n")
                mostrarDatosAutos()

            }
        } while (validarAutoID(id_auto) == true)




        print("\nIngrese el tipo de auto\n\n")
        var tipo_auto: String = readLine().toString()
        print("\nIngrese la fecha de lanzamiento\n")
        print("\nIngrese el Año\n")
        var anio_lanzamiento: Int = readLine()?.toInt() as Int
        print("\nIngrese el mes\n")
        var mes_lanzamiento: Int = readLine()?.toInt() as Int
        print("\nIngrese el dia\n")
        var dia_lanzamiento: Int = readLine()?.toInt() as Int
        var fecl = LocalDate.of(anio_lanzamiento, mes_lanzamiento, dia_lanzamiento)
        print("\nExisten ejemplares? (escribir si o no)\n")
        val ex_ejem = readLine().toString()

        print("\nIngrese el precio del auto (Separar decimales con . ) \n")
        val precio_auto = readLine()?.toDouble() as Double
        datosAutosEspecial.clear()
        datosAutosEspecial.add(Autos(id_marca_auto, id_auto, tipo_auto, fecl, validarBooleano(ex_ejem), precio_auto))
        guardarDatosAutos()
        mostrarDatosAutos()
        print("\nQuieres agregar mas autos a esta marca o alguna otra (escribir si o no)\n")
        var respuesta2: String = readLine().toString()
    } while (respuesta2 == "si")

}




fun mostrarDatosMarcas(){

    val file = File("Archivo_Marcas.txt")
    file.forEachLine { println(it) }


}

fun mostrarDatosAutos(){

    val file = File("Archivo_Autos.txt")
    file.forEachLine { println(it) }


}

fun guardarDatosMarcas() : Unit {

    try {


        val fo =  FileOutputStream("Archivo_Marcas.txt", true)

        var datosMarcas : List<Any> = datosMarcasEspecial


        fo.bufferedWriter()
                .use { salida ->

                    datosMarcas.forEach {

                        lineas ->

                        salida.write(lineas.toString() + "\n")
                    }

                }

        println("La marca ha sido guardada exitosamente")
    } catch(ex:Exception){
        print(ex.message)

    }

}


fun guardarDatosMarcasActualización(listaM: List<Any>) : Unit {

    try {

        val fo =  FileOutputStream("Archivo_Marcas.txt", false)

        var datosMarcas : List<Any> = listaM


        fo.bufferedWriter()
                .use { salida ->

                    datosMarcas.forEach {

                        lineas ->

                        salida.write(lineas.toString() + "\n")
                    }

                }


    } catch(ex:Exception){
        print(ex.message)

    }

}

fun guardarDatosAutos() {


    try {


        val fo =  FileOutputStream("Archivo_Autos.txt", true)

        var datosAutos : List<Any> = datosAutosEspecial


        fo.bufferedWriter()
                .use { salida ->

                    datosAutos.forEach {

                        lineas ->

                        salida.write(lineas.toString() + "\n")
                    }

                }

        println("El auto ha sido guardado exitosamente")
    } catch(ex:Exception){
        print(ex.message)

    }


}

fun guardarDatosAutosActualización(listaA: List<Any>) {


    try {


        val fo =  FileOutputStream("Archivo_Autos.txt", false)

        var datosAutos : List<Any> = listaA


        fo.bufferedWriter()
                .use { salida ->

                    datosAutos.forEach {

                        lineas ->

                        salida.write(lineas.toString() + "\n")
                    }

                }

        println("El auto ha sido guardado exitosamente")
    } catch(ex:Exception){
        print(ex.message)

    }


}















fun validarBooleano(entrada: String): Boolean {

    if (entrada == "si") {

        return true
    }else{

        return false
    }

}


fun validarMarcaID(id_marca:Int): Boolean {


    var esta : Boolean = false
    val file = File("Archivo_Marcas.txt")
    file.forEachLine {

        if(it[0].toString().toInt() == id_marca ){

            esta = true

        }

    }

    if(esta == true){

        return  true



    } else{

        return false
    }


}


fun validarMarcaAutoID(id_marca_Auto:Int): Boolean {


    var esta : Boolean = false
    val file = File("Archivo_Marcas.txt")
    file.forEachLine {

        if(it[0].toString().toInt() == id_marca_Auto ){

            esta = true

        }

    }

    if(esta == true){

        return  true



    } else{

        return false
    }


}

fun validarAutoID(id_Auto:Int): Boolean {


    var esta : Boolean = false
    val file = File("Archivo_Autos.txt")
    file.forEachLine {

        if(it[2].toString().toInt() == id_Auto ){

            esta = true

        }

    }

    if(esta == true){

        return  true



    } else{

        return false
    }


}


fun eliminarMarca(idm: Int){
    var listaMarcasEliminadas : ArrayList<Marcas> = arrayListOf()
    var ubicacionArchivo = "Archivo_Marcas.txt"
    var indiceMarca: Int = 0
    indiceMarca = buscarIDMarca(idm)

    if(indiceMarca != -1){
        listaMarcasEliminadas= identificarElementosArchivoMarcas(extraerDatos(ubicacionArchivo))
        listaMarcasEliminadas.removeAt(indiceMarca)
        guardarDatosMarcasActualización(listaMarcasEliminadas)

    }else{
       // print("El id para esta marca no existe")
    }




}

fun eliminarAuto(ida: Int){
    var listaAutosEliminados : ArrayList<Autos> = arrayListOf()
    var ubicacionArchivo = "Archivo_Autos.txt"
    var indiceAuto: Int = 0
    indiceAuto = buscarIDAuto(ida)

    if(indiceAuto != -1){
        listaAutosEliminados= identificarElementosArchivoAutos(extraerDatos(ubicacionArchivo))
        listaAutosEliminados.removeAt(indiceAuto)
        guardarDatosAutosActualización(listaAutosEliminados)

    }else{
      //  print("El id para esta marca no existe")
    }



}


fun eliminarMarcaAuto(ida: Int){
    var listaAutosEliminados : ArrayList<Autos> = arrayListOf()
    var ubicacionArchivo = "Archivo_Autos.txt"
    var indiceAuto: Int = 0
    indiceAuto = buscarIDMarcaAuto(ida)

    if(indiceAuto != -1){
        listaAutosEliminados= identificarElementosArchivoAutos(extraerDatos(ubicacionArchivo))
        listaAutosEliminados.removeAt(indiceAuto)
        guardarDatosAutosActualización(listaAutosEliminados)

    }else{
     //    print("El id para esta marca no existe")
    }



}

fun buscarIDMarcaAuto( ida: Int): Int{
    val ubicacion= "Archivo_Autos.txt"
    var listaAutos: ArrayList<Autos> = identificarElementosArchivoAutos(extraerDatos(ubicacion))
    var elementoLista: List<Autos> = listaAutos.filter { auto ->
        return@filter auto.id_marca == ida
    }
    try {
        var index: Int = listaAutos.indexOf(elementoLista[0])
        return index
    }catch (e: IndexOutOfBoundsException){
        return -1
    }


}







fun buscarIDMarca( idm: Int): Int{
    val ubicacion= "Archivo_Marcas.txt"
    var listaMarcas: ArrayList<Marcas> = identificarElementosArchivoMarcas(extraerDatos(ubicacion))
    var elementoLista: List<Marcas> = listaMarcas.filter { marca ->
        return@filter marca.id_marcas == idm
    }
    try {
        var index: Int = listaMarcas.indexOf(elementoLista[0])
        return index
    }catch (e: IndexOutOfBoundsException){
        return -1
    }


}


fun buscarIDAuto( ida: Int): Int{
    val ubicacion= "Archivo_Autos.txt"
    var listaAutos: ArrayList<Autos> = identificarElementosArchivoAutos(extraerDatos(ubicacion))
    var elementoLista: List<Autos> = listaAutos.filter { auto ->
        return@filter auto.id_auto == ida
    }
    try {
        var index: Int = listaAutos.indexOf(elementoLista[0])
        return index
    }catch (e: IndexOutOfBoundsException){
        return -1
    }


}







fun identificarElementosArchivoMarcas(elementos: List<String>) :ArrayList<Marcas>{
    var elementosMarcas: ArrayList<Marcas> = arrayListOf();
    elementos.forEach { elemento ->
        var arregloMarcas: Array<String> = elemento.split(",").toTypedArray();
        elementosMarcas.add(Marcas(arregloMarcas[0].toInt(), arregloMarcas[1], LocalDate.parse(arregloMarcas[2]), arregloMarcas[3].toBoolean(),
                arregloMarcas[4].toDouble()

        )
        )
    }
    return elementosMarcas
}

fun identificarElementosArchivoAutos(elementos: List<String>) :ArrayList<Autos>{
    var elementosAutos: ArrayList<Autos> = arrayListOf();
    elementos.forEach { elemento ->
        var arregloAutos: Array<String> = elemento.split(",").toTypedArray();
        elementosAutos.add(Autos(arregloAutos[0].toInt(), arregloAutos[1].toInt(), arregloAutos[2],LocalDate.parse(arregloAutos[3]), arregloAutos[4].toBoolean(),
                arregloAutos[5].toDouble()

        )
        )
    }
    return elementosAutos
}




fun extraerDatos(nombreArchivo: String):ArrayList<String> {
    val ubicacionArchivo = File(nombreArchivo)
    val lectura: BufferedReader = ubicacionArchivo.bufferedReader()
    val linea: String = lectura.use { it.readText() }
    var arreglo:ArrayList<String> = linea.split("\n").toTypedArray().toCollection(ArrayList());
    arreglo.removeAt(arreglo.size - 1)
    return  arreglo
}



fun modificarMarcas(index: Int,idm:Int,  marcasn: String,  fechaIngreson: LocalDate, isNacionaln: Boolean,  valoracionn: Double){

        var ubicacion = "Archivo_Marcas.txt"
        var listaMarcas: ArrayList<Marcas> = identificarElementosArchivoMarcas(extraerDatos(ubicacion))
        listaMarcas[index].id_marcas = idm
        listaMarcas[index].marcas = marcasn
        listaMarcas[index].fechaIngreso = fechaIngreson
        listaMarcas[index].isNacional = isNacionaln
        listaMarcas[index].valoracion = valoracionn
        guardarDatosMarcasActualización(listaMarcas)


}

fun modificarAutos(index: Int,idamn:Int, idan:Int  ,tipoauton: String,  fechan: LocalDate, isDisponiblen: Boolean,  precion: Double){

        var ubicacion = "Archivo_Autos.txt"
        var listaAutos: ArrayList<Autos> = identificarElementosArchivoAutos(extraerDatos(ubicacion))
        listaAutos[index].id_marca = idamn
        listaAutos[index].id_auto = idan
    listaAutos[index].tipo_auto = tipoauton
    listaAutos[index].fecha_lanzamiento = fechan
    listaAutos[index].isDisponible = isDisponiblen
    listaAutos[index].costo_auto = precion

        guardarDatosAutosActualización(listaAutos)



}



















