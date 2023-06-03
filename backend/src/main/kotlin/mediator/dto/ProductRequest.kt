package dto

import java.util.ArrayList

/**

Clase ProductRequest: representa una solicitud de productos en el sistema de comercio electrónico.

@property products Lista de productos de la solicitud.
 */
class ProductRequest {
    private var products: MutableList<Product> = ArrayList()

    /**

    Obtiene la lista de productos de la solicitud.
    @return Lista de productos.
     */
    fun getProducts(): List<Product> {
        return products
    }
    /**

    Establece la lista de productos de la solicitud.
    @param products Nueva lista de productos.
     */
    fun setProducts(products: List<Product>) {
        this.products = products.toMutableList()
    }
}