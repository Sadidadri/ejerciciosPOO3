package arraylistObjetos;

public class Articulo {
	private int codigo;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int stock;
	//Constructor
	public Articulo(int codigo,String descripcion,double precioCompra,double precioVenta,int stock) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
		setStock(stock);
	}
	/**
	 * Obtiene valor de codigo
	 * @return valor de codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * Obtiene el contenido de la descripcion
	 * @return cadena de descripcion
	 */
	private String getDescripcion() {
		return descripcion;
	}
	/**
	 * Obtiene valor del precio de compra
	 * @return valor del precio de compra
	 */
	private double getPrecioCompra() {
		return precioCompra;
	}
	/**
	 * Obtiene valor del precio de venta
	 * @return valor del precio de venta
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * Obtiene la cantidad de stock
	 * @return cuanto hay de stock
	 */
	public int getStock() {
		return stock;
	}
	//Constructor por defecto
	public Articulo() {
		this.codigo = 0;
		this.descripcion = "";
		this.precioCompra = 0;
		this.precioVenta = 0;
		this.stock = 0;
	}
	
/**
 * Establece el valor del precio de compra, controla que no sea negativo, en ese caso lo iguala a 0
 * @param pv
 */
	private void setPrecioVenta(double pv) {
		if(pv >= 0) {
			this.precioVenta = pv;
		}else {
			System.err.println("Error, el precio de venta no puede ser negativo, lo asigno a 0");
			this.precioVenta = 0;
		}		
	}
	/**
	 * Establece el valor del precio de venta, controla que no sea negativo, en ese caso lo iguala a 0
	 * @param pc
	 */
	private void setPrecioCompra(double pc) {
		if(pc >= 0) {
			this.precioCompra = pc;
		}else {
			System.err.println("Error, el precio de compra no puede ser negativo, lo asigno a 0");
			this.precioCompra = 0;
		}
	}
	/**
	 * Establece la cantidad de stock, controla que no sea negativo, en ese caso lo iguala a 0
	 * @param s
	 */
	private void setStock(int s) {
		if(s >= 0) {
			this.stock = s;
		}else {
			System.err.println("Error, el stock no puede ser negativo, lo asigno a 0");
			this.precioCompra = 0;
		}
	}
	/**
	 * Entra mercancia, el stock del articulo aumenta en una unidad
	 */
	public void entraMercancia() {
		setStock(getStock()+1);
	}
	/**
	 * Sale mercancia, el stock del articulo decrementa en una unidad
	 */
	public void saleMercancia() {
		setStock(getStock()-1);
	}
	/**
	 * Metodo toString de articulo
	 */
	public String toString() {
		return "El articulo de codigo "+getCodigo()+",cuya descripcion es: "+getDescripcion()+" tiene un precio de compra de "+getPrecioCompra()+"€, un precio de venta de "+getPrecioVenta()+"€. Quedan "+getStock()+" unidades";
		
	}
}
