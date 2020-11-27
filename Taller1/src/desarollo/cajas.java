package desarollo;

public class cajas {
	private String nombre;
	private static double precio;
	private int stockCaja;
	private static double recaudacion;
	
	listaAspectos listaAspectos;
	
	public cajas(String nombre,double precio,int stockCaja) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stockCaja =stockCaja;
		

			
	}
	public static cajas getCaja(int i) {
		//TODO: check i esta en el rango
		return listaCajas.getCaja(i);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static double getPrecio() {
		return precio;
	}
	public double getRecaudacion() {
		return recaudacion;
	}
	public static void setRecaudacion(double reca) {
		recaudacion += reca;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStockCaja() {
		return stockCaja;
	}
	public void setStockCaja(int decStock) {
		this.stockCaja -= decStock;
	}
	public void incStockCaja(int incStock) {
		if (incStock>0) {
			this.stockCaja += incStock;
		}
		
	}


	
	
	
}
