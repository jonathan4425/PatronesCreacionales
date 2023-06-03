import dto.Product
import dto.Sale
import impl.*
import java.lang.NullPointerException

/**

Función principal que ejecuta el sistema de comercio electrónico.
 */
fun main() {
    // Activar el módulo CRM
    CRMModule().activate()

    // Activar el módulo Notify
    NotifyModule().activate()

    // Activar el módulo Stock
    StockModule().activate()

    // Activar el módulo Purchase
    PurchaseModule().activate()

    // Crear una instancia del módulo de comercio electrónico
    val client = ECommerceModule()
    client.activate()

    // Crear un objeto de venta
    val sale = Sale()

    // Agregar 5 productos a la venta
    for (c in 0 until 5) {
        sale.addProduct(Product("Product" + (c + 1)))
    }

    try {
    // Intentar crear una venta usando el módulo de comercio electrónico
        client.createSale(sale)

    } catch (e: NullPointerException) {
    // Manejar la excepción de NullPointerException si ocurre durante la creación de la venta
        println("Operación terminada")
    }
}