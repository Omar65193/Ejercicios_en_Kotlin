import kotlin.math.sqrt

//EJERCICIO 1
fun descuento(precio : Double, porcentaje: Double): Double{
    return precio-(precio*(porcentaje/100))
}

fun iva(precio : Double, porcentaje: Double): Double {

    return precio + precio * (porcentaje / 100.00)
}


fun calcular(cesta : HashMap<Double, Double>, funcion: (Double, Double) -> Double): Double{
    var monto: Double = 0.0;

    for(it in cesta){
        monto += funcion(it.key,it.value);
    }
    return monto
}

//EJERCICIO 2
fun orden_superior(lista: List<Int>, funcion : (Int) -> Int):List<Int>{
    val lista2: MutableList<Int>  = mutableListOf()

    for(it in lista){
        lista2.add(funcion(it))
    }

    return lista2
}

//EJERCICIO 3
fun palabras(frase: String):HashMap<String,Int>{
    val delimitador = " "
    val mapa : HashMap<String,Int> = HashMap()
    val lista = frase.split(delimitador)
    for(palabra in lista){
        mapa.put(palabra,palabra.length)
    }
    return mapa
}

//EJERCICIO 4
fun calificaciones(mapa:HashMap<String,Int>): HashMap<String,String>{
    val mapa2 : HashMap<String,String> = HashMap()
    for(it in mapa){
        if(it.value>=95 && it.value<=100){
            mapa2.put(it.key.uppercase(),"Excelente")
        }else if(it.value>=85 && it.value<=94){
            mapa2.put(it.key.uppercase(),"Notable")
        }else if(it.value>=75 && it.value<=84){
            mapa2.put(it.key.uppercase(),"Bueno")
        }else if(it.value>=70 && it.value<=74){
            mapa2.put(it.key.uppercase(),"Suficiente")
        }else if(it.value<70){
            mapa2.put(it.key.uppercase(),"Desempeño insuficiente")
        }
    }
    return mapa2
}

//EJERCICIO 5
fun modulo(x:Double, y:Double):Double{
    return sqrt(Math.pow(x,2.0)+Math.pow(y,2.0))
}

//EJERCICIO 6
fun atipicos(lista: List<Double>):List<Double>{
    val lista2 : MutableList<Double> = mutableListOf()
    var desviacion : Double = 0.0
    var sumatoria : Double = 0.0
    for (it in lista){
        sumatoria+=it
    }
    var promedio = sumatoria/lista.size.toDouble()
    sumatoria = 0.0
    for(it in lista){
        sumatoria+=Math.pow((it-promedio),2.0)
    }

    desviacion = sqrt(sumatoria/ (lista.size-1).toDouble())

    for (it in lista){
        if((it-promedio)/desviacion>3 || (it-promedio)/desviacion<-3){
            lista2.add(it);
        }
    }
    return lista2

}

fun main(args: Array<String>) {
    //EJERCICIO 1
    println("\nEJERCICIO 1")
    var precios1 = hashMapOf<Double,Double>(24.0 to 5.0, 67.3 to 10.0, 55.6 to 17.0, 45.34 to 50.0)
    var precios2 = hashMapOf<Double,Double>(24.0 to 17.0, 67.3 to 17.0, 55.6 to 17.0, 45.34 to 17.0)
    println("Monto despues de descuento: "+calcular(precios1,::descuento))
    println("Monto despues de iva: "+calcular(precios2,::iva))
    //EJERCICIO 2
    println("\nEJERCICIO 2")
    var l1 = listOf<Int>(1,2,3,4,5,6)
    var l2 = orden_superior(l1,{it -> it*2})
    println("Los valores de la lista se multiplicaron por 2")
    for (it in l2){
        println(it)
    }
    //EJERCICIO 3
    println("\nEJERCICIO 3")
    var mapa = palabras("Hola buenos días")
    println("Las palabras de la cadena anterior son: ")
    for(it in mapa){
        println(it.key+" "+it.value)
    }

    //EJERCICIO 4
    println("\nEJERCICIO 4")
    var calif = hashMapOf<String,Int>("Español" to 90, "Matematicas" to 80, "Ciencias Naturales" to 70, "Programación" to 100, "Contabilidad" to 60)
    var diccionario = calificaciones(calif)
    println("Este es tu desempeño en el semestre:")
    for(it in diccionario){
        println(it.key+" "+it.value)
    }

    //EJERCICIO 5
    println("\nEJERCICIO 5")
    println("El modulo del vector es: ")
    println(modulo(7.0,3.0))

    //EJEMPLO EJERCICIO 6
    var lista = listOf(3.0,7.0,8.0,4.0,5.0,6.0,7.0,9.0,10.0,11.0,34.0,5.0,2.0)
    var at = atipicos(lista)
    println("\nEJERCICIO 6")
    println("Valores atipicos: ")
    for(it in at){
        println(it)
    }

}