package module

import java.util.HashMap

/**
 * Clase ModuleMediator: representa un mediador para la comunicación entre módulos del sistema.
 */
class ModuleMediator private constructor() {

    companion object {
        private var mediator: ModuleMediator? = null
        private val modules: MutableMap<String, AbstractModule> = HashMap()

        /**
         * Devuelve una instancia del mediador. Si no existe, crea una nueva instancia.
         * @return Instancia del mediador.
         */
        @Synchronized
        fun getInstance(): ModuleMediator {
            if (mediator == null) {
                mediator = ModuleMediator()
            }
            return mediator!!
        }
    }

    /**
     * Registra un módulo en el mediador.
     * @param module Módulo a registrar.
     */
    fun registerModule(module: AbstractModule) {
        modules[module.getModuleName()] = module
    }

    /**
     * Mediar un evento de mensaje entre módulos.
     * @param mediateEvent Evento de mensaje a mediar.
     * @return Resultado de la operación.
     * @throws RuntimeException si el módulo objetivo no está registrado.
     */
    fun mediate(mediateEvent: ModuleMessage): Any {
        if (!modules.containsKey(mediateEvent.getTarget())) {
            throw RuntimeException("El módulo '${mediateEvent.getTarget()}' no está registrado")
        }

        println("Mediate source > '${mediateEvent.getSource()}', target > '${mediateEvent.getTarget()}', messagetType > '${mediateEvent.getMessageType()}'")

        val module: AbstractModule? = modules[mediateEvent.getTarget()]
        return module!!.notifyMessage(mediateEvent) ?: throw RuntimeException("El módulo '${mediateEvent.getTarget()}' no está registrado")
    }

    /**
     * Mide el tiempo de ejecución de una acción.
     * @param action Acción a medir.
     */
    fun measureExecutionTime(action: () -> Unit) {
        val startTime = System.currentTimeMillis()
        action()
        val endTime = System.currentTimeMillis()
        val executionTime = endTime - startTime
        println("Tiempo de ejecución: $executionTime ms")
    }
}
