package dto

/**

Clase Product: representa un producto en el sistema de comercio electrónico.

@property name Nombre del producto.
 */
class Product(private var name: String) {

    /**

    Obtiene el nombre del producto.
    @return Nombre del producto.
     */
    fun getName(): String {
        return name
    }
    /**

    Establece el nombre del producto.
    @param name Nuevo nombre del producto.
     */
    fun setName(name: String) {
        this.name = name
    }
}