package dto

import java.util.ArrayList
/**

Clase Sale: representa una venta en el sistema de comercio electrónico.

@property productos Lista de productos de la venta.
 */
open class Sale {
    private var productos: MutableList<Product> = ArrayList()

    /**

    Obtiene la lista de productos de la venta.
    @return Lista de productos.
     */
    fun getProductos(): List<Product> {
        return productos
    }
    /**

    Agrega un producto a la venta.
    @param product Producto a agregar.
     */
    fun addProduct(product: Product) {
        this.productos.add(product)
    }
    /**

    Establece la lista de productos de la venta.
    @param productos Nueva lista de productos.
     */
    fun setProductos(productos: List<Product>) {
        this.productos = productos.toMutableList()
    }
}



