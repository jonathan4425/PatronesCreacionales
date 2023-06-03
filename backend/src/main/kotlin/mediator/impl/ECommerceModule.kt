package impl

import dto.Sale
import dto.SaleOrder
import module.AbstractModule
import module.ModuleMediator
import module.ModuleMessage

/**

Clase ECommerceModule: representa un módulo de comercio electrónico en el sistema.

Extiende AbstractModule.
 */
class ECommerceModule : AbstractModule() {

    var mediator: ModuleMediator = ModuleMediator.getInstance()

    companion object {
        const val MODULE_NAME = "ECommerce"
        const val OPERATION_COMPLETE_ORDER = "CompleteOrder"
    }

    /**

    Devuelve el nombre del módulo.
    @return Nombre del módulo.
     */
    override fun getModuleName(): String {
        return MODULE_NAME
    }
    /**

    Completa una orden de venta en el módulo de comercio electrónico.
    @param saleOrder Orden de venta a completar.
     */
    override fun completeOrder(saleOrder: SaleOrder) {
        println("Orden completada en el módulo ECommerceModule")
    }
    /**

    Notifica un mensaje al módulo de comercio electrónico y realiza una operación específica según el tipo de mensaje.
    @param message Mensaje a notificar.
    @return Resultado de la operación.
    @throws RuntimeException si se recibe un tipo de mensaje no soportado.
     */
    override fun notifyMessage(message: ModuleMessage): Any {
        when (message.getMessageType()) {
            OPERATION_COMPLETE_ORDER -> return completeOrder(message)
            else -> throw RuntimeException("Operación no soportada '${message.getMessageType()}'")
        }
    }
    /**

    Completa una orden de venta.

    @param message Mensaje con la orden de venta.

    @return Identificador de la orden de venta completada.
     */
    private fun completeOrder(message: ModuleMessage): String {
        val saleOrder = message.getPayload() as SaleOrder
        println("Orden completada exitosamente > ")

        val crmMessage = ModuleMessage(
            MODULE_NAME,
            NotifyModule.MODULE_NAME,
            NotifyModule.OPERATION_NOTIFY,
            saleOrder
        )
        mediator!!.mediate(crmMessage)
        return saleOrder.getId()
    }

    /**

    Crea una venta.
    @param sale Venta a crear.
    @return Identificador de la orden de venta creada.
     */
    fun createSale(sale: Sale): String {
        val crmMessage = ModuleMessage(
            MODULE_NAME,
            CRMModule.MODULE_NAME,
            CRMModule.OPERATION_CREATE_ORDER,
            sale
        )
        return mediator!!.mediate(crmMessage).toString()
    }
}



