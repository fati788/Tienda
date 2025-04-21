import java.util.ArrayList;
import java.util.List;
/**
 * La clase tienda gestiona un inventario de productos 
 * que nos permitir agregar productos , venderlos aplicando
 * descuentos , actualizar precios stock , y calcular el valor 
 * del total inventario
 * @version 1.0
 * @author fatima
 */
public class Tienda {
	private static final double DESCUENTO_25_PORCIENTO = 0.25;
	private static final double DESCUENTO_10_PORCIENTO = 0.10;
	private List <Producto> productos;
	/**
	 * un contruclor que no recibe nada 
	 * es solo inicializar el arrayList del productos.
	 */
	public Tienda() {
		productos =new ArrayList<>();
	}
	/**
	 * Este método crea un objeto de tipo Producto con el nombre, precio y stock
	 * proporcionados, y lo agrega a la lista productos del inventario
	 * @param nombre es un string que representa el nombre del producto
	 * @param precio es un double que representa el precio del producto
	 * @param stock es un integer que representa el cantidad del stock
	 */
	// Añadir producto nuevo
	public void agregarProducto (String nombre, double precio, int stock) {
		Producto producto= new Producto (nombre, precio, stock);
		productos.add(producto);
	}
	/**
	 * Realiza una venta de un producto. Si se encuentra el producto en el inventario y hay
	 * suficiente stock, aplica un descuento dependiendo del precio total de la venta.
	 * Después, reduce el stock del producto y muestra el subtotal, el descuento aplicado y el
	 * total con descuento.
	 * @param nombreProducto es el nombre del producto
	 * @param totalVenta es la cantidad del dinero total  del total del venta 
	 */
	// Vender producto
	public void venderProducto(String nombreProducto, int totalVenta) {
	    boolean productoEncontrado = false;  // Variable para verificar si se encontró el producto
	    for (Producto producto : productos) {
	        	        
	        // Comprobamos si el nombre del producto coincide
	        if (producto.getNombre().equals(nombreProducto)) {
	            productoEncontrado = true;  // Marcamos que el producto fue encontrado
	            
	            // Verificamos si hay suficiente stock
	            if (producto.getStock() >= totalVenta) {
	                double total = producto.getPrecio() * totalVenta;
	                double descuento = 0;

	                // Aplicamos descuento según el total
	                boolean DescuentoInicial = total >= 50 && total <= 100;
					if (DescuentoInicial) {
	                    descuento = DESCUENTO_10_PORCIENTO;  // 10% de descuento
	                } else {
						boolean DescuentoAvanzado = total > 100;
						if (DescuentoAvanzado) {
						    descuento = DESCUENTO_25_PORCIENTO;  // 25% de descuento
						}
					}

	                // Calculamos el total con el descuento
	                double totalConDescuento = CalcularDescuentoVenta(total, descuento);
	                
	                // Reducimos el stock del producto
	                producto.reducirStock(totalVenta);    
	                // Mostramos venta por pantalla
	                venderProducto(producto, total, descuento, totalConDescuento);
	            } else {
	                System.out.println("Stock insuficiente.");
	            }
	            break;  // Salimos del ciclo porque ya hemos procesado el producto
	        }
	    }
	    
	    // Si no se encontró el producto
	    if (!productoEncontrado) {
	        System.out.println("Producto "+nombreProducto +" no encontrado.");
	    }
	}
	/**
	 * Mostra por pantalla los datos de la venta del producto 
	 * @param producto es el producto del venta 
	 * @param total representa el precio total 
	 * @param descuento es el descuento que se hace sobre el precio del producto
	 * @param totalConDescuento es el total del descuento
	 */

	private void venderProducto(Producto producto, double total, double descuento, double totalConDescuento) {
		System.out.println("Venta "+ producto.getNombre()+" realizada. ");
		System.out.println("Subtotal : " + total);
		System.out.println("Decuento aplicado: "+descuento);
		System.out.println("Total : " + totalConDescuento);
	}
      /**
       * Calcula el precio final despuis el descuento
       * @param total es el precio total del venta
       * @param descuento es descuento que se aplica sobre el precio
       * @return devuelve el precio final del venta despuis el descuento
       */
	private double CalcularDescuentoVenta(double total, double descuento) {
		double totalConDescuento = total - (total * descuento);
		return totalConDescuento;
	}
	/**
	 * Muestra por pantalla todos los productos en el inventario 
	 * junto con su precio y stockactual.
	 */

	public void mostrarInventario() {
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Stock: " + producto.getStock());
        }
    }
	/**
	 * Busca un producto por su nombre (ignorando mayúsculas/minúsculas)
	 * Devuelve el objeto Producto correspondiente si se encuentra,
	 *  o null si no se encuentra.
	 * @param nombre es el nombre del producto que reciba el metodo
	 * @return duevelve el producto si lo encuentra
	 * si no devuelve un null
	 */
	
	 // Buscar producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    /**
     * Actualiza el precio de un producto si se encuentra en el inventario.
     * @param nombre es el nombre del producto que se actualiza
     * @param nuevoPrecio es el precio nuevo del producto
     */
	
    // Actualizar precio de un producto
    public void actualizarPrecio(String nombre, double nuevoPrecio) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
	/**
	 * Aumenta el stock de un producto específico si se encuentra en el inventario.
	 * @param nombre es el nombre del producto que vas a aumentar el stock de el
	 * @param cantidad es la cantidad que sume a la cantidad antigua del precio
	 */
    // Actualizar stock
    public void reponerStock(String nombre, int cantidad) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.aumentarStock(cantidad);
            System.out.println("Stock actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
	/**
	 * Calcula el valor total del inventario multiplicando el precio de cada producto por su
	 * stock y sumando los resultados
	 * @return devuelve el precio total del stock despuis calcular al valor del inventario
	 */
    // Calcular valor total del inventario
    public double calcularValorInventario() {
        double precioTotalStock = 0;
        for (Producto producto : productos) {
            precioTotalStock += producto.getPrecio() * producto.getStock();
        }
        return precioTotalStock;
    }
	
}//fin clase

