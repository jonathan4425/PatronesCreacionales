package impl

import dto.ProductRequest
import dto.SaleOrder
import module.AbstractModule
import module.ModuleMediator
import module.ModuleMessage

/**

Clase StockModule: representa un módulo de inventario en el sistema.

Extiende AbstractModule.
 */
class StockModule : AbstractModule() {
    var mediator: ModuleMediator = ModuleMediator.getInstance()

    companion object {
        const val MODULE_NAME = "Stock"
        const val OPERATION_DECREMENT_STOCK = "DecrementStock"
    }

    /**

    Devuelve el nombre del módulo.
    @return Nombre del módulo.
     */
    override fun getModuleName(): String {
        return MODULE_NAME
    }

    /**

    Completa una orden de venta en el módulo de inventario.
    @param saleOrder Orden de venta a completar.
     */
    override fun completeOrder(saleOrder: SaleOrder) {
        TODO("Not yet implemented")
    }

    /**

    Notifica un mensaje al módulo de inventario y realiza una operación específica según el tipo de mensaje.
    @param message Mensaje a notificar.
    @return Resultado de la operación.
    @throws RuntimeException si se recibe un tipo de mensaje no soportado.
     */
    override fun notifyMessage(message: ModuleMessage): Any {
        when (message.getMessageType()) {
            OPERATION_DECREMENT_STOCK -> return decrementStock(message)!!
            else -> throw RuntimeException("Operación no soportada '${message.getMessageType()}'")
        }
    }

    /**

    Decrementa el stock de productos según el mensaje recibido.

    @param message Mensaje de decremento de stock.

    @return null.
     */
    private fun decrementStock(message: ModuleMessage): Void? {
        val saleOrder = message.getPayload() as SaleOrder
        for (product in saleOrder.getProductos()) {
            println("decrement product > ${product.getName()}")
        }

        val productRequest = ProductRequest()
        productRequest.setProducts(saleOrder.getProductos())

        val purchaseMessage = ModuleMessage(
            MODULE_NAME,
            PurchaseModule.MODULE_NAME,
            PurchaseModule.OPERATION_PURCHASE_REQUEST,
            productRequest
        )
        mediator!!.mediate(purchaseMessage)
        return null
    }
}