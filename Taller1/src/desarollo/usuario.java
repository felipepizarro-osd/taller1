package desarollo;

public class usuario {
	private String nombre;
	private String contraseña;
	private double saldoUsuario;
	private listaArmas listaArmas;
	private double saldogastado;
	
	
	/**
	 * @param nombre
	 * @param contraseña
	 * @param saldoUsuario
	 */

	public usuario(String nombre, String contraseña, double saldoUsuario) {

		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.saldoUsuario = saldoUsuario;
		this.listaArmas = new listaArmas();
	}

	public String getNombre() {
		return nombre;
	}

	
	
	
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
		return "usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", saldoUsuario=" + saldoUsuario + "]";
	}

	public void setCompras(double d) {
		// TODO Auto-generated method stub
		saldogastado+=d;
		
	}
	public double getCompras() {
		return saldogastado;
	}


	
	



	
}
