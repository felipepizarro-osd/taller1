package desarollo;

public class usuario {
	private String nombre;
	private String contrase�a;
	private double saldoUsuario;
	private listaArmas listaArmas;
	private double saldogastado;
	
	
	/**
	 * @param nombre
	 * @param contrase�a
	 * @param saldoUsuario
	 */

	public usuario(String nombre, String contrase�a, double saldoUsuario) {

		super();
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.saldoUsuario = saldoUsuario;
		this.listaArmas = new listaArmas();
	}

	public String getNombre() {
		return nombre;
	}

	
	
	
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public double getSaldoUsuario() {
		return saldoUsuario;
	}
	public void setSaldoUsuario(double saldoUsuario,double saldoAgregado) {
		if (saldoAgregado>0) {
			this.saldoUsuario += saldoAgregado;
			 
		}
		
	}
	public int getCantidadArmas() {
		return listaArmas.getCantidad();
	}

	public Inventario getArma(int i) {
		//TODO: check i esta en el rango
		return listaArmas.getArma(i);
	}
	public void agregarArma(Inventario Armas ) {
		this.listaArmas.agregarArma(Armas);
		
	}
	
	
	public String toString() {
		return "usuario [nombre=" + nombre + ", contrase�a=" + contrase�a + ", saldoUsuario=" + saldoUsuario + "]";
	}

	public void setCompras(double d) {
		// TODO Auto-generated method stub
		saldogastado+=d;
		
	}
	public double getCompras() {
		return saldogastado;
	}


	
	



	
}
