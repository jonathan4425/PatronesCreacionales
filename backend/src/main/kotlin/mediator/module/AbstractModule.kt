package module

import dto.SaleOrder

/**

Clase AbstractModule: clase abstracta que representa un módulo en el sistema.
 */
abstract class AbstractModule {

    private lateinit var mediator: ModuleMediator

    /**

    Devuelve el nombre del módulo.
    @return Nombre del módulo.
     */
    abstract fun getModuleName(): String
    /**

    Activa el módulo registrándolo en el mediador.
     */
    fun activate() {
        mediator = ModuleMediator.getInstance()
        mediator.registerModule(this)
    }
    /**

    Completa una orden de venta en el módulo.
    @param saleOrder Orden de venta a completar.
     */
    abstract fun completeOrder(saleOrder: SaleOrder)
    /**

    Notifica un mensaje al módulo y realiza una operación específica según el tipo de mensaje.
    @param message Mensaje a notificar.
    @return Resultado de la operación.
     */
    abstract fun notifyMessage(message: ModuleMessage): Any
}