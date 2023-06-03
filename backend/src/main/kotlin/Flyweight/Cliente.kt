package FlyWeight

object Cliente {
    @JvmStatic
    //coleccion de flyweights
    fun main(args: Array<String>) {
        val fabrica = FabricaDeLineas()
        val linea1 = fabrica.getLine("AZUL")
        val linea2 = fabrica.getLine("ROJO")
        val linea3 = fabrica.getLine("AMARILLO")
        val linea4 = fabrica.getLine("AZUL")
        println("-------------------")

        linea1.dibujar(100, 400)
        linea2.dibujar(200, 500)
        linea3.dibujar(300, 600)
        linea4.dibujar(400, 700)
    }

}