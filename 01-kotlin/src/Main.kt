import java.util.*
import kotlin.collections.ArrayList

fun main(args:Array<String>){

    print ("Hola mundo")
    /*Declaracion de variables*/
    //Ejemplo de java:
    //Int edad = 31;
    //Variables mutables= reasignada
    var edadProfesor = 31//No especificamos el tipo de dato  //escribir variables que se entiendan
    //El ; no es necesario
    //Duck Typing (Predice el tipo de variable)
    //var edadCachorro; esta manera es incorrecta por que no se especifica el tipo de dato
    var edadCachorro:Int
    edadCachorro = 5
    edadCachorro = 35
    edadCachorro = 45
    edadCachorro = 3
    //Variables Immutables(SIEMPRE UTILIZAR ESTE TIPO DE VARIABLES Y NO SE PUEDEN REASIGNAR)
    val numeroCuenta = 123456
   // numeroCuenta = 123 error por que la variable ya no puede ser reasignada


    //Tipos de variables
    val nombreProfesor = "Vicente Adrian" //Con "" se entiende como String
    val sueldo: Double = 12.20
    val apellidosProfesor = 'a' //Con '' se entiende como Char
    val fechaNacimiento = Date() //new Date()


    //Comparaciones

    if (sueldo == 12.20){



    }else{

    }


    when   (sueldo){
        12.20 -> println("Sueldo normal") //los casos
        -12.20 -> println("Sueldo negativo")
        else -> println("No se reconoce el sueldo") //else para el resto de casos
    }                //Es como un switch en kotlin


    val esSueldoMayorAlEstablecido = if (sueldo == 12.20) true else false
    //Expresion ? X ; Y
    //calcularSueldo(1000.00, 14.00)

    calcularSueldo(1000.00, 13.00)
    calcularSueldo(
            tasa = 121.00,
            sueldo = 121.12     
    ) // Named Parameters
    calcularSueldo(123.00)
    calcularSueldo(sueldo= 123.00)

    val arregloConstante: Array<Int> = arrayOf(1,2,3)  //Arreglos(El Array no se va a poder modificar)
    val arregloCumpleanos: ArrayList<Int> = arrayListOf(22,31,33,34,35) //Este arreglo puede modificarse
    arregloCumpleanos.add(24)
    arregloCumpleanos.remove(element = 30)
    print(arregloCumpleanos)

    //3 formas de rrecorrer un arreglo

    arregloCumpleanos.forEach {  //Para rrecorrer el array

        println("Valor de la iteracion" + it)
    }

    arregloCumpleanos.forEach { valorIteracion: Int ->

    println("ValorIteracion" + valorIteracion)


    }

    //Operadores -> TODOS LOS LENGUAJES
    //El foreach no devuelve nada -> unit
    arregloCumpleanos.forEach( //Solo para iterar
            {valorIteracion: Int ->
                println("Valor iteracion" + valorIteracion)
                println("valor con -1 = ${valorIteracion * -1}")

            }

    )

    arregloCumpleanos.forEachIndexed { index:Int, it:Int -> //Para iterar con indice
            println("Valor de la iteracion" + it + "    " + "El indice es:" + index)

    }

    //MAP
    //1) Enviamos el nuevo valor de la iteracion
    //2)Nos Devulve un nuevo arreglo con los valores modificados
    //3) Nos devuelve un nuevo arreglo

    val respuestaMap = arregloCumpleanos.map {iterador: Int -> //para modificar el arreglo

        iterador * -1
    }

    val respuestaMapDos = arregloCumpleanos.map {iterador: Int -> //para modificar el arreglo

        val  nuevoValor: Int = iterador * -1
        val  otroValor: Int = nuevoValor * 2
        return@map otroValor.toString() //no solo modifica el arregla si no que devuelve culquier cosa
    }


    println(respuestaMap)
    println(respuestaMapDos)
    println(arregloCumpleanos)


    //Filter -> Filtra el arreglo, me devuelve un nuevo arreglo
    //1)Devolver una expresion
    //2)Nos devuleve un nuevo arreglo que cumpla esa expresion

   val respuestaFilter = arregloCumpleanos.filter { iteracion: Int ->

        val esMayorA23= iteracion > 23
        return@filter esMayorA23

    }

    println(respuestaFilter)
    println(arregloCumpleanos)


    // Any -> OR (Some)
    // All -> AND (Every)
    // AND -> TRUE, Todo lo demas falso
    // OR -> TODO es falso, lo demas era verdadero
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Devuelve un Booleano
    // (30, 31, 22, 23, 20)
    // ("a", "b", "c", "d")
    // "abcd"

    val respuestaAny = arregloCumpleanos
            .any { iterador: Int ->
                return@any iterador < 25
            }
    println(respuestaAny)

    val respuestaAll = arregloCumpleanos
            .all { iterador: Int ->
                return@all iterador > 65
            }
    println(respuestaAll)

    val respuestaReduce: Int = arregloCumpleanos.reduce{ //para promedio, acumulador empieza en o

        acumulador, iteracion ->
        return@reduce acumulador + iteracion

    }
    println(respuestaReduce)

    val respuestaFold: Int = arregloCumpleanos.fold( 100, { //acumulador empieza en o

        acumulador, iteracion ->
        return@fold acumulador - iteracion

    })
    println(respuestaFold)

    //arregloCumpleanos.reduceRight { i, acc ->  } comienza desde el final
    //arregloCumpleanos.foldRight() comienza desde el final


    //Devoluciones
    //forEach ->nada
    //map->arregloe
    //filter->Arreglo
    //all->Booleano
    //any->Booleano
    //reduce -> valor
    //fold->valor



    //Reducir el daño en 20%
    //18 <
    // (22,31,33,34,35)
    val vidaActual = arregloCumpleanos
            .map { it * 0.8 } // (24, 24.8, 17.7, 18.4, 16)
            .filter { it > 18 } // (24, 24.8, 18.4)
            .fold(
                    100.00,
                    { acc, d -> acc - d }
            )
    println(vidaActual)

}









//Funciones

  fun calcularSueldo (sueldo: Double,   //Requeridos!
                      tasa: Double = 12.00, //(Tiene valor defecto)
                      calculoEspecial: Int? = null//opcional!! (Pueden ser nulos)
  ): Double? { // el valor puede ser nulo
    if (calculoEspecial != null) {
        return sueldo * tasa * calculoEspecial
    }else{

        return sueldo * tasa
    }

  }

    fun imprimirMensaje(){  //Unit = Void
        println("")

    }


    //Clases abstractas
/* //no utilizar
    abstract class NumerosJava{
        protected val numeroUno: Int //no es necesario instanciar la propiedad de acceso public por que es por defecto
        private val numeroDos: Int

        constructor(uno: Int, dos:Int) {

            numeroUno = uno
            numeroDos = dos

        }
    }

*/
abstract class Numeros( //val nuevosNumeros = Numeros(1,2)

        protected val numeroUno: Int,
        protected val numeroDos: Int


){

}


class  Suma(
        uno: Int, //Parametro
        dos:  Int //Parametro
):Numeros(uno, dos){

    public fun sumar() : Int{

        return this.numeroUno + this.numeroDos  //values de la clase abastracta-Herencias
    }

}

class  SumaDos(
        public var uno: Int, //Propiedades
        public var dos:  Int //Propiedades
):Numeros(uno, dos){

    public fun sumar() : Int{
        this.uno
        this.dos
        return this.numeroUno + this.numeroDos  //values de la clase abastracta-Herencias
    }

}