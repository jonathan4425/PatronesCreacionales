package impl

import crm.DistributionModule
import dto.Sale
import dto.SaleOrder
import module.AbstractModule
import module.ModuleMediator
import module.ModuleMessage
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger

/**

Clase CRMModule: representa un módulo CRM en el sistema de comercio electrónico.

Extiende AbstractModule.
 */
class CRMModule : AbstractModule() {
    var mediator: ModuleMediator = ModuleMediator.getInstance()

    companion object {
        const val MODULE_NAME = "CRM"
        const val OPERATION_CREATE_ORDER = "CreateOrder"
    }

    /**

    Devuelve el nombre del módulo.
    @return Nombre del módulo.
     */
    override fun getModuleName(): String {
        return MODULE_NAME
    }
    /**

    Completa una orden de venta en el módulo CRM.
    @param saleOrder Orden de venta a completar.
     */
    override fun completeOrder(saleOrder: SaleOrder) {
        println("Orden completada en el módulo CRMModule")
    }
    /**

    Notifica un mensaje al módulo CRM y realiza una operación específica según el tipo de mensaje.
    @param message Mensaje a notificar.
    @return Resultado de la operación.
    @throws RuntimeException si se recibe un tipo de mensaje no soportado.
     */
    override fun notifyMessage(message: ModuleMessage): Any {
        return when (message.messageType) {
            OPERATION_CREATE_ORDER -> mediator.measureExecutionTime { createSaleOrder(message) }
            else -> throw RuntimeException("Operación no soportada '${message.messageType}'")
        }
    }
    /**

    Crea una orden de venta.

    @param event Mensaje con la venta.

    @return Identificador de la orden de venta creada.
     */
    private fun createSaleOrder(event: ModuleMessage): String {
        val sale = event.getPayload() as Sale
        val id = UUID.randomUUID().toString()
        println("Orden de venta creada exitosamente")

        val saleOrder = SaleOrder(id)
        saleOrder.setProductos(sale.getProductos())

        val stockEvent = ModuleMessage(MODULE_NAME, StockModule.MODULE_NAME, StockModule.OPERATION_DECREMENT_STOCK, saleOrder)
        mediator.mediate(stockEvent)

        Thread {
            try {
                Thread.sleep(1000 * 10)
                val distributionEvent = ModuleMessage(MODULE_NAME, DistributionModule.MODULE_NAME, DistributionModule.OPERATION_COMPLETE_ORDER, saleOrder)
                mediator.mediate(distributionEvent)
            } catch (e: InterruptedException) {
                Logger.getLogger(CRMModule::class.java.name).log(Level.SEVERE, null, e)
            }
        }.start()

        return id
    }
}