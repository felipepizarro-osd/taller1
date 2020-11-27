package desarollo;

public class listaCajas {
	private static cajas[] listaCajas;
	private static int max ;
	private static int cantidadCajas;
	private static double recaudaciontotal;
	
	public listaCajas(int max) {
		super();
		this.max = 5;
		this.cantidadCajas = 0;
		listaCajas = new cajas[max];
	}
	public double getPrecio() {
		return cajas.getPrecio();
	}
	
	public static  boolean agregarCaja(cajas caja) {
		
		if (cantidadCajas < max) {
			listaCajas[cantidadCajas] = caja;
			cantidadCajas++;
			return true;
		}else {
			return false;
		}
	}
	
	public static int getCantidasCajas() {
		return cantidadCajas;
	}
	public void setCantidasCajas(int cantidasCajas) {
		this.cantidadCajas = cantidasCajas;
	}
	
	public static cajas getCaja(int i) {
		
		return listaCajas[i];
	}
	
	public static cajas buscarCaja(String nombre) {
		int i;
		for (i = 0 ; i < cantidadCajas;i++) {
			if (listaCajas[i].getNombre().equals(nombre)) {
				break;
			}
		}
		if (i == cantidadCajas) {
			return null;
		}
		else {
			return listaCajas[i];
		}
	}
	public static void setTotal(double sumat) {
		for (int i = 0; i < listaCajas.length; i++) {
			recaudaciontotal += listaCajas[i].getRecaudacion();
		}
		
		
	}
	public static double getRecaudaciontotal() {
		return recaudaciontotal;
	}
	public String toString() {
		String r = "";
		for (int i = 0; i < cantidadCajas; i++) {
			r= r+listaCajas[i].toString()+"\n";
		}return r;
	}
	
}
