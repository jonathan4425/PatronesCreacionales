package module

/**
 * Clase ModuleMessage: representa un mensaje enviado entre módulos del sistema.
 * @property source Módulo fuente del mensaje.
 * @property target Módulo objetivo del mensaje.
 * @property messageType Tipo de mensaje.
 * @property payload Carga útil del mensaje.
 */
class ModuleMessage(
    private val source: String,
    private val target: String,
    val messageType: String,
    private val payload: Any
) {
    /**
     * Devuelve el módulo fuente del mensaje.
     * @return Módulo fuente.
     */
    fun getSource(): String {
        return source
    }

    /**
     * Devuelve el módulo objetivo del mensaje.
     * @return Módulo objetivo.
     */
    fun getTarget(): String {
        return target
    }

    /**
     * Devuelve el tipo de mensaje.
     * @return Tipo de mensaje.
     */
    @JvmName("getMessageType1")
    fun getMessageType(): String {
        return messageType
    }

    /**
     * Devuelve la carga útil del mensaje.
     * @return Carga útil del mensaje.
     */
    fun getPayload(): Any {
        return payload
    }
}