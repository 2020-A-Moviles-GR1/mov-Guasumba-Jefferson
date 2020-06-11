import java.util.*

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

}

//Funciones

  fun calcularSueldo (sueldo: Double,   //Requeridos!
                      tasa: Double = 12.00, //(Tiene valor defecto)
                      calculoEspecial: Int? = null//opcional!! (Pueden ser nulos)
  ): Double {
    if (calculoEspecial != null) {
        return sueldo * tasa * calculoEspecial
    }else{

        return sueldo * tasa
    }

  }

    fun imprimirMensaje(){  //Unit = Void
        println("")

    }