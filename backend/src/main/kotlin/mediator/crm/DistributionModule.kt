package crm

import dto.SaleOrder
import module.AbstractModule
import module.ModuleMessage

/**

Clase DistributionModule: representa un módulo de distribución en el sistema de comercio electrónico.

Extiende AbstractModule.
 */
class DistributionModule: AbstractModule() {

    companion object {
        const val MODULE_NAME = "ECommerce"
        const val OPERATION_COMPLETE_ORDER = "CompleteOrder"
    }

    /**

    Devuelve el nombre del módulo.
    @return Nombre del módulo.
     */
    override fun getModuleName(): String {
        return MODULE_NAME;
    }
    /**

    Completa una orden de venta en el módulo de distribución.
    @param saleOrder Orden de venta a completar.
     */
    override fun completeOrder(saleOrder: SaleOrder) {
        println("Orden completada en el módulo Email")
    }
    /**

    Notifica un mensaje al módulo de distribución y realiza una operación específica según el tipo de mensaje.
    @param message Mensaje a notificar.
    @return Resultado de la operación.
    @throws RuntimeException si se recibe un tipo de mensaje no soportado.
     */
    override fun notifyMessage(message: ModuleMessage): Any {
        return when (message.messageType) {
            OPERATION_COMPLETE_ORDER -> {
                scheduleDelivery(message)
            }
            else -> {
                throw RuntimeException("Operación no soportada '${message.messageType}'")
            }
        }!!
    }
    /**

    Programa la entrega de un pedido.
    @param message Mensaje con el pedido a programar.
    @return Nulo (Void).
     */
    private fun scheduleDelivery(message: ModuleMessage): Void? {
        val saleOrder = message.getSource() as SaleOrder
        println("Programando envío del pedido: ${saleOrder.id}")
// Lógica para programar el envío del producto al cliente
        return null
    }
}