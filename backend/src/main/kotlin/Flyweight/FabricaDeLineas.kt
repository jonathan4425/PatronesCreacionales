package FlyWeight

class FabricaDeLineas {
    private val lineas: MutableList<ILineaLigera>
    init {
        lineas = ArrayList()
    }
    fun getLine(color: String): ILineaLigera {
        // Comprobar si hemos creado una línea con el color solicitado, y devolverla en tal caso
        for (linea in lineas) {
            if (linea.getColor() == color) {
                println("Línea de color [$color] encontrada, la devolvemos")
                return linea
            }
        }
        // Si no ha sido creada la creamos ahora, la agregamos a la lista y la devolvemos
        println("Creando una línea de color [$color]")
        val linea: ILineaLigera = Linea(color)
        lineas.add(linea)
        return linea
    }

}
