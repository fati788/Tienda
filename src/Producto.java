/**
  * La clase Producto representa un artículo disponible en una tienda. Contiene información
  * sobre su nombre, precio y cantidad en stock.
  * @version 1.0
  * @author fatima
  */

public class Producto {
 
	private String nombre;
	private double precio;
	private int stock;
	
	/**
	 * Constructor con todos los parametros del producto
	 * @param nombre es un string que representa el nombre del producto
	 * @param precio es un double que representa el precio del producto
	 * @param stock es un integer que representa el cantidad del stock
	 */
	public Producto (String nombre, double precio, int stock) {
		this.nombre=nombre;
		this.precio=precio;
		this.stock=stock;
	}
	/**
	 * Devuelve el nombre del producto
	 * @return Devuelve el nombre del producto
	 */
	
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece un nuevo nombre para el producto
	 * @param nombre es un string que representa el nombre del producto
	 */
	
	public void setNombre (String nombre) {
		this.nombre=nombre;
	}
	/**
	 * Devuelve el precio del producto
	 * @return devuelve el precio del producto
	 */
	
	public double getPrecio () {
		return precio;
	}
	/**
	 * Establece un nuevo precio para el producto
	 * @param precio es un double que representa el precio del producto
	 */
	
	public void setPrecio (double precio) {
		this.precio=precio;
	}
	/**
	 * Devuelve la cantidad en stock del producto
	 * @return devuelve el stock del producto
	 */
	
	public int getStock() {
		return stock;
	}
	/**
	 * Establece una nueva cantidad en stock para el producto
	 * @param stock  es un integer que representa el cantidad del stock
	 */
	public void setStock(int stock) {
		this.stock=stock;
	}
	/**
	 * Reduce el stock del producto en una cantidad determinada
	 * @param cantidad es la cantidad que se resta del stock
	 */
	public void reducirStock (int cantidad) {
		this.stock-=cantidad;
	}
	/**
	 * Aumenta el stock del producto en una cantidad determinada
	 * @param cantidad es la cantidad que se suma al stock
	 */
	
	public void aumentarStock (int cantidad) {
		this.stock+=cantidad;
	}
	
}
