package impl

import dto.SaleOrder
import module.AbstractModule
import module.ModuleMessage

/**

Clase NotifyModule: representa un módulo de notificación en el sistema.

Extiende AbstractModule.
 */
class NotifyModule : AbstractModule() {

    companion object {
        const val MODULE_NAME = "Notification"
        const val OPERATION_NOTIFY = "Notify"
    }

    /**

    Devuelve el nombre del módulo.
    @return Nombre del módulo.
     */
    override fun getModuleName(): String {
        return MODULE_NAME
    }
    /**

    Completa una orden de venta en el módulo de notificación.
    @param saleOrder Orden de venta a completar.
     */
    override fun completeOrder(saleOrder: SaleOrder) {
        TODO("Not yet implemented")
    }
    /**

    Notifica un mensaje al módulo de notificación y realiza una operación específica según el tipo de mensaje.
    @param message Mensaje a notificar.
    @return Resultado de la operación.
    @throws RuntimeException si se recibe un tipo de mensaje no soportado.
     */
    override fun notifyMessage(message: ModuleMessage): Any {
        when (message.getMessageType()) {
            OPERATION_NOTIFY -> return notify(message)!!
            else -> throw RuntimeException("Operación no soportada '${message.getMessageType()}'")
        }
    }
    /**

    Envía una notificación según el mensaje recibido.
    @param message Mensaje de notificación.
    @return null.
     */
    private fun notify(message: ModuleMessage): Void? {
        println("Notificación por EMail enviada")
        return null
    }
}