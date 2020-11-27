package desarollo;

public class Inventario {
	private String nombre;
	private double precio;
	
	public Inventario(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return Arma.getPrecio();
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	


	
}
