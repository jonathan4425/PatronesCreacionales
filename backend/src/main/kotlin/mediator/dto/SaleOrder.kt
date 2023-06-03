package dto

/**

Clase SaleOrder: representa una orden de venta en el sistema de comercio electrónico.

@property id Identificador de la orden de venta.
 */
class SaleOrder(var id: String) : Sale() {

    /**

    Obtiene el identificador de la orden de venta.
    @return Identificador de la orden de venta.
     */
    @JvmName("getId1")
    fun getId(): String {
        return id
    }
    /**

    Establece el identificador de la orden de venta.
    @param id Nuevo identificador de la orden de venta.
     */
    @JvmName("setId1")
    fun setId(id: String) {
        this.id = id
    }
}



