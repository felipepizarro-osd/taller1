package desarollo;

public class listaArmas {
	private static  Inventario[] Armas= new Inventario[20];
	private static int cantidad = 0;
	
	public static int getCantidad() {
		return cantidad;
	}

	public Inventario getArma(int i) {
		
		return Armas[i];
	}

	public void agregarArma(Inventario armas) {
		Armas[cantidad] = armas;
		cantidad++;
		
	}
	public static Inventario buscarArmaInventario(String nombre) {
		int i;
		for (i = 0 ; i < cantidad;i++) {
			if (Armas[i].getNombre().equals(nombre)) {
				break;
			}
		}
		if (i == cantidad) {
			return null;
		}
		else {
			return Armas[i];
		}
	}
	public static boolean eliminarArma(String nombre) {
		int j ;
		for (j = 0; j < cantidad; j++) {
			if (Armas[j].getNombre().equals(nombre)) {
				break;
			}
		}if (j == cantidad) {
			return false;
		}else {
			for (int k=j ; k < Armas.length-1; k=j++) {
				Armas[k] = Armas[k+1];
			}
			cantidad--;
			return true;
		}
	}

}
