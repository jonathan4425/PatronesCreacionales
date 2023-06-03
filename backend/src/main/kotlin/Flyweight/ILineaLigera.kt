package FlyWeight

//PesoLigero en el diagrama anterior
//IFlyweight
interface ILineaLigera {
    fun getColor(): String?
    //fun getProduct(): String?
    fun dibujar(col: Int, fila: Int)
}
/*aqui se implementan los metodos que se implementaran
se trabaja el lado instrinseco
 */
