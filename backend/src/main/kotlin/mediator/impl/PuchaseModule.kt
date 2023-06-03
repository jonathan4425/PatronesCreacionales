package impl

import dto.SaleOrder
import module.AbstractModule
import module.ModuleMessage

/**

Clase PurchaseModule: representa un módulo de compra en el sistema.

Extiende AbstractModule.
 */
class PurchaseModule : AbstractModule() {

    companion object {
        const val MODULE_NAME = "Chopping"
        const val OPERATION_PURCHASE_REQUEST = "PurchaseRequest"
    }

    /**

    Devuelve el nombre del módulo.
    @return Nombre del módulo.
     */
    override fun getModuleName(): String {
        return MODULE_NAME
    }
    /**

    Completa una orden de venta en el módulo de compra.
    @param saleOrder Orden de venta a completar.
     */
    override fun completeOrder(saleOrder: SaleOrder) {
        TODO("Not yet implemented")
    }
    /**

    Notifica un mensaje al módulo de compra y realiza una operación específica según el tipo de mensaje.

    @param message Mensaje a notificar.

    @return Resultado de la operación.

    @throws RuntimeException si se recibe un tipo de mensaje no soportado.
     */
    override fun notifyMessage(message: ModuleMessage): Any {
        if (message == null){
            println("Valor nulo")
        }

        when (message!!.getMessageType()) {
            OPERATION_PURCHASE_REQUEST -> return purchaseRequest(message)!!
            else -> throw RuntimeException("Operación no soportada '${message!!.getMessageType()}'")
        }
    }

    /**

    Realiza una solicitud de compra según el mensaje recibido.
    @param message Mensaje de solicitud de compra.
    @return null.
     */
    private fun purchaseRequest(message: ModuleMessage): Void? {
        return null
    }
}