package desarollo;


public class listaUsuario {
	private static usuario [] lista;
	private static int cantidadUsuarios;
	private static int max;

	
	public listaUsuario(int max) {
		lista = new usuario[max];
		cantidadUsuarios =  0;
		this.max = max;
	}
	
	public static  boolean agregarUsuario(usuario n_user) {
		if (cantidadUsuarios < max) {
			lista[cantidadUsuarios] = n_user;
			cantidadUsuarios++;
			return true;
		}else {
			return false;
		}
	}




	public static int getCantidadUsuarios() {
		return cantidadUsuarios;
	}




	public void setCantidadUsuarios(int cantidadUsuarios) {
		this.cantidadUsuarios = cantidadUsuarios;
	}
	public static usuario getusuario(int i) {
		if (i>=0 && i<cantidadUsuarios) {
			return lista[i];
		}else {
			return null;
		}
	}
	public static usuario buscarUsuario(String nombre) {
		int i;
		for (i = 0 ; i < cantidadUsuarios;i++) {
			if (lista[i].getNombre().equals(nombre)) {
				break;
			}
		}
		if (i == cantidadUsuarios) {
			return null;
		}
		else {
			return lista[i];
		}
	}
	public boolean eliminarUsuario(String nombre) {
		int j ;
		for (j = 0; j < cantidadUsuarios; j++) {
			if (lista[j].getNombre().equals(nombre)) {
				break;
			}
		}if (j == cantidadUsuarios) {
			return false;
		}else {
			for (int k=j ; k < lista.length-1; k=j++) {
				lista[k] = lista[k+1];
			}
			cantidadUsuarios--;
			return true;
		}
	}

	
	public String toString() {
		String r = "";
		for (int i = 0; i < cantidadUsuarios; i++) {
			r= r+lista[i].toString()+"\n";
		}return r;
	}

}
