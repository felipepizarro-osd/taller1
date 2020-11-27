package desarollo;

public class listaAspectos {
	private static Aspectos[] listasAspectos;
	private static int cant;
	private static int max;
	
	public listaAspectos( int cant, int max) {
		super();
		this.listasAspectos = new Aspectos[max];
		this.cant = cant;
		this.max = max;
	}
	public static  boolean agregarAspecto(Aspectos Asp) {
		if (cant < max) {
			listasAspectos[cant] = Asp;
			cant++;
			return true;
		}else {
			return false;
		}
	}
	public int getCantidadAspectos() {
		return cant;
	}
	public static String buscarAspecto(cajas cajaU) {
		int i;
		double mayor = -1;
		String ArmaComprada = "";
		for (i = 0 ; i < cant;i++) {
			if (listasAspectos[i].getProbabilidad()>mayor) {
				ArmaComprada=listasAspectos[i].getNombre();
				
			}
		}
		return ArmaComprada;
	}
	
	
}
