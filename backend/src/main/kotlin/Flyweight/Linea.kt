package FlyWeight

//PesoLigeroConcreto en el diagrama anterior
class Linea (private val color: String?) : ILineaLigera {
    override fun getColor(): String? {
        return color
    }
        // override fun getProduct(): String? {
        //   return id
        // }
        override fun dibujar(col: Int, fila: Int) {
            println("Dibujando línea de color [" + color + "] en [" + col + ", " + fila + "]")
        }
    }