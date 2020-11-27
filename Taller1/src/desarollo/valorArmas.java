package desarollo;

public class valorArmas {
	private static Arma[] listaA ;
	private static int max;
	private static int cantidadArma ;
	
	public valorArmas(int max) {
		super();
		this.listaA = new Arma[max];
		this.max = max;
		this.cantidadArma = 0;
	}
	public static boolean agregarArma(Arma arma) {
		if (cantidadArma < max) {
			listaA[cantidadArma] = arma;
			cantidadArma++;
			return true;
		}else {
			return false;
		}
	}
	public int getCantidadArmas() {
		return cantidadArma;
	}
	public static Arma buscarArma(String nombre) {
		int i;
		for (i = 0 ; i < cantidadArma;i++) {
			if (listaA[i].getNombre().equals(nombre)) {
				break;
			}
		}
		if (i == cantidadArma) {
			return null;
		}
		else {
			return listaA[i];
		}
	}
	public String toString() {
		String r = "";
		for (int i = 0; i < cantidadArma; i++) {
			r= r+listaA[i].toString()+"\n";
		}return r;
	}

	

}
