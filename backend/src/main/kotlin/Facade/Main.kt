package Facade

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val liquidos = ComprobarLiquidos()
        liquidos.comprobar()
        val asiento = ComprobarAsiento()
        asiento.comprobar()
        val espejos = ComprobarEspejos()
        espejos.comprobar()
        val arrancar = Arrancar()
        arrancar.encenderContacto()
        println("\nProceso finalizado.")
    }
}