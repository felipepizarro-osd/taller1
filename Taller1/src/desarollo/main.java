package desarollo;
import java.util.InputMismatchException;
import java.io.*;
import java.util.Scanner;


public class main {
//	Lectura de archivos
	public static void lecturaCajas(String ubicacion) throws FileNotFoundException {

		File archivo = new File(ubicacion);
		try (Scanner Sc = new Scanner(archivo)) {
			while(Sc.hasNextLine()){
				 String linea = Sc.nextLine();
				 String[] partes = linea.split(",");
				 switch (partes[0]) {
				case "Knife": {
					double precioCaja = Double.valueOf(partes[1]);
					int stock = Integer.valueOf(partes[2]);
					cajas K = new cajas(partes[0],precioCaja,stock);
					listaCajas.agregarCaja(K);
					int iterador = 3;
					while (iterador <= partes.length) {
						String nombre =partes[iterador];
						iterador++;
						double probabilidad = Double.valueOf(partes[iterador]);
						Aspectos Aspecto = new Aspectos(nombre,probabilidad);
						listaAspectos.agregarAspecto(Aspecto);
						
					}
				}
				case "Milspec":{
					double precioCaja = Double.valueOf(partes[1]);
					int stock = Integer.valueOf(partes[2]);
					cajas M = new cajas(partes[0],precioCaja,stock);
					listaCajas.agregarCaja(M);
					int iterador = 3;
					while (iterador <= partes.length) {
						String nombre =partes[iterador];
						iterador++;
						double probabilidad = Double.valueOf(partes[iterador]);
						Aspectos Aspecto = new Aspectos(nombre,probabilidad);
						listaAspectos.agregarAspecto(Aspecto);
						
					}
				}
				case "Restricted":{
					double precioCaja = Double.valueOf(partes[1]);
					int stock = Integer.valueOf(partes[2]);
					cajas R = new cajas(partes[0],precioCaja,stock);
					listaCajas.agregarCaja(R);
					int iterador = 3;
					while (iterador <= partes.length) {
						String nombre =partes[iterador];
						iterador++;
						double probabilidad = Double.valueOf(partes[iterador]);
						Aspectos Aspecto = new Aspectos(nombre,probabilidad);
						listaAspectos.agregarAspecto(Aspecto);
						
					}
				}
				case "Covert":{
					double precioCaja = Double.valueOf(partes[1]);
					int stock = Integer.valueOf(partes[2]);
					cajas C = new cajas(partes[0],precioCaja,stock);
					listaCajas.agregarCaja(C);
					int iterador = 3;
					while (iterador <= partes.length) {
						String nombre =partes[iterador];
						iterador++;
						double probabilidad = Double.valueOf(partes[iterador]);
						Aspectos Aspecto = new Aspectos(nombre,probabilidad);
						listaAspectos.agregarAspecto(Aspecto);
						
					}
				}
				case "God":{
					double precioCaja = Double.valueOf(partes[1]);
					int stock = Integer.valueOf(partes[2]);
					cajas G = new cajas(partes[0],precioCaja,stock);
					int iterador = 3;
					while (iterador <= partes.length) {
						String nombre =partes[iterador];
						iterador++;
						double probabilidad = Double.valueOf(partes[iterador]);
						Aspectos Aspecto = new Aspectos(nombre,probabilidad);
						listaAspectos.agregarAspecto(Aspecto);
						
					}
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + partes[0]);
				}
			}
		}
	}
	public static void lecturaPersonas(String ubicacion)throws FileNotFoundException {
		File archivo = new File(ubicacion);
		Scanner Sc = new Scanner(archivo);
		while (Sc.hasNextLine()) {
			String linea = Sc.nextLine();
			String[] partes = linea.split(",");
			double saldo = Double.valueOf(partes[2]);
//			accesa un nuevo usuario
			usuario N_user = new usuario(partes[0],partes[1],saldo);
			listaUsuario.agregarUsuario(N_user);
			for (int i = 3; i < partes.length; i++) {
				Inventario arma = new Inventario(partes[i]);
				N_user.agregarArma(arma);
			}
		}
	}
	public static void lecturaArmas(String ubicacion) throws FileNotFoundException {
		File archivo = new File (ubicacion);
		Scanner Sc = new Scanner(archivo);
		int it = 0;
		while (Sc.hasNextLine()) {
			String linea = Sc.nextLine();
			String[] partes = linea.split(",");
			
			double precioNominal = Double.valueOf(partes[1]);
			
			Arma nuevaArma = new Arma(partes[0],precioNominal);
			valorArmas.agregarArma(nuevaArma);
			
		}
	}
	public static boolean ingreso(String nombre,String contraseña) {

		usuario indexu = listaUsuario.buscarUsuario(nombre);
		if (nombre == indexu.getNombre() && contraseña == indexu.getContraseña()) {
			System.out.println("El ususario y contraseña son validos");
			System.out.println("Desplegando menu de usuario");
			return true;
		}else {
			System.out.println("la contraseña es incorrecta intentelo nuevamente");
			return false;
		}
		
		

	}
	public static double saldoInventario(usuario userName) {
		double saldo =0;
		for (int i = 0; i < listaArmas.getCantidad(); i++) {
			double sumando = userName.getArma(i).getPrecio();
			saldo += sumando;
			
		}
		return saldo;
	}
	
	
	public static void menuUsuario(String nombre) {
		System.out.println("Menu usuario");
		System.out.println("1) informacion del usuario");
		System.out.println("2) Añadir Saldo");
		System.out.println("3) Retirar armas");
		System.out.println("4) Comprar cajas");
		System.out.println("Digite el numero del menu que quiera desplegar: ");
		int option = 0;
		Scanner Sc = new Scanner(System.in);
		try {
			option = Sc.nextInt();
			
		}catch (InputMismatchException ex) {
			System.out.println("caracter no aceptado");
			System.out.println("Ingrese nuevamente la opcion");
			
			
		}
			
		while (option > 4 ) {
			System.out.println(option);
			System.out.println("opcion no valida");
			System.out.println("ingrese nuevamente la opcion");
			option = Sc.nextInt();
		}

		
		switch (option) {
		case 1: {
			
			System.out.println("ha elegido la opcion: informacion de la cuenta : ");
			usuario user =listaUsuario.buscarUsuario(nombre);
			double saldoTotal = saldoInventario(user);
			System.out.println("Nombre de usuario"+user.getNombre()+"saldo actual: "+user.getSaldoUsuario()+"total inventariado: "+saldoTotal);
			for (int i = 0; i < listaArmas.getCantidad(); i++) {
				user.getArma(i);
				
			}
			break;
		}
		case 2:{
			System.out.println("ha elegido la opcion Añadir Saldo");
			usuario user =listaUsuario.buscarUsuario(nombre);
			System.out.println("Ingrese el valor a añadir");
			double agregado = Sc.nextDouble();
			user.setSaldoUsuario(user.getSaldoUsuario(),agregado);
			System.out.println("Operacion relizada correctamente");
			System.out.println("Su saldo actual es:  "+ user.getSaldoUsuario());
			break;
			
		}
		case 3:{
			System.out.println("ha elegido la opcion retirar armas ");
			usuario user =listaUsuario.buscarUsuario(nombre);
			for (int i = 0; i < listaArmas.getCantidad(); i++) {
				user.getArma(i);
			}
			System.out.println("ingrese el nombre del arma que desea eliminar");
			String ArmaDelete = Sc.nextLine();
			Inventario a_Delete = listaArmas.buscarArmaInventario(ArmaDelete);
			listaArmas.eliminarArma(a_Delete.getNombre());
			
			System.out.println("El arma se ha eliminado con exito");
			break;
			
		}
		case 4: {
			System.out.println("ha elegido la opcion Comprar Cajas");
//			despligue de cajas
			for (int i = 0; i < listaCajas.getCantidasCajas(); i++) {
				cajas.getCaja(i);
			}
			System.out.println("ingrese el nombre de la caja que desea comprar");
			String cajaComprar = Sc.nextLine();
			cajas cajaU = listaCajas.buscarCaja(cajaComprar);
			double precioCaja = cajaU.getPrecio();
			cajaU.setRecaudacion(cajaU.getPrecio());
			
			usuario user =listaUsuario.buscarUsuario(nombre);
			double saldo = user.getSaldoUsuario();
 			if (precioCaja > saldo) {
				System.out.println("Lo sentimos saldo insuficiente ");
//				agregar saldo
			}else {
				Arma ArmaS = valorArmas.buscarArma(listaAspectos.buscarAspecto(cajaU));
				Inventario Arma =new Inventario (ArmaS.getNombre());
				user.agregarArma(Arma);
				
				if (Arma.getPrecio()>cajaU.getPrecio()) {
					System.out.println("MOMENT BIG CASH");
				}else {
					System.out.println("YOU LOST");
				}
				cajaU.setStockCaja(1);
				user.setSaldoUsuario(user.getSaldoUsuario(),-cajaU.getPrecio());
				user.setCompras(-cajaU.getPrecio());
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
	
	public static void Accesoprivilegiado() {
		System.out.println("Menu priv");
		System.out.println("1) modificar Stock");
		System.out.println("2) recaudaciones");
		System.out.println("3) informacion ventas");
		
		System.out.println("Digite el numero del menu que quiera desplegar: ");
		@SuppressWarnings("resource")
		Scanner Sc = new Scanner(System.in);
		int opcion = 0;
		try {
			opcion = Sc.nextInt();
			
		}catch (InputMismatchException ex) {
			System.out.println("caracter no aceptado");
			System.out.println("Ingrese nuevamente la opcion");
			
			
		}
			
		while (opcion > 4 ) {
			System.out.println(opcion);
			System.out.println("opcion no valida");
			System.out.println("ingrese nuevamente la opcion");
			opcion = Sc.nextInt();
		}
		
		switch (opcion) {
		case 1: {
			for (int i = 0; i < listaCajas.getCantidasCajas(); i++) {
				System.out.println(listaCajas.getCaja(i).getNombre()+"stock: "+ listaCajas.getCaja(i).getStockCaja());
			}
			System.out.println("Ingrese el nombre de la caja a modificar su stock: ");
			String caja = Sc.nextLine();
			cajas cajaStock = listaCajas.buscarCaja(caja);
			System.out.println("Ingrese la cantidad de stock a sumar: ");
			int stockN = Sc.nextInt();
			cajaStock.incStockCaja(stockN);
			break;
			}
			
		
		case 2:{
			System.out.println("Recaudaciones");
			for (int i = 0; i < listaCajas.getCantidasCajas(); i++) {
				
				System.out.println(listaCajas.getCaja(i).getNombre() +"la recaudacuion es de "+listaCajas.getCaja(i).getRecaudacion());
			}
			System.out.println("la recaudacion total es:" + listaCajas.getRecaudaciontotal());

			break;
			
		}
		case 3:{
			System.out.println("informacion de ventas");
			System.out.println("usuarios ingresados");
			for (int i = 0; i < listaUsuario.getCantidadUsuarios(); i++) {
				System.out.println(listaUsuario.getusuario(i)+"gastos: "+listaUsuario.getusuario(i).getCompras());
			}	
			
			

			break;
			
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
	}

		
		
		
	
	
	public static void main (String[]args ) throws FileNotFoundException {

//		manda a leer los txt
		/*
		 * @param ubicacion del archivo en el dispositivo
		 */
		lecturaCajas("cajas.txt");
		lecturaPersonas("personas.txt");
		lecturaArmas("armas.txt");
//		opciones: meter a una funcion
		Scanner Sc = new Scanner(System.in);
		System.out.println("oprima 1 para iniciar sesion: ");
		System.out.println("oprima 2 para registrarse: ");
		int opcion = Sc.nextInt();
		if (opcion == 1) {
//			llamar a ingreso privilegiado
			
			
//			ingresar sesion
			Scanner Sc2 = new Scanner(System.in);
//			parameter nombre de usuario y contraseña
			System.out.println("ingrese su nombre de usuario: ");
			String usuarioIn = Sc2.nextLine();
			System.out.println("ingrese contraseña: ");
			String contraseñaIn = Sc2.nextLine();
			
			if (usuarioIn == "ADMIN"&& contraseñaIn == "ADMIN") {
				Accesoprivilegiado();
			}
			
			
			while (ingreso(usuarioIn, contraseñaIn) == false) {
				System.out.println("la contraseña es incorrecta intentelo nuevamente");
				System.out.println("ingrese nuevamente su nombre de usuario: ");
				usuarioIn = Sc.nextLine();
				System.out.println("ingrese nuevamente contraseña: ");
				contraseñaIn = Sc.nextLine();
			}
			menuUsuario(usuarioIn);
		}else if (opcion == 2) {
//			hacer registro nuevo
			System.out.println("ingrese su nombre de usuario");
			String nombre=Sc.nextLine();
			System.out.println("Ingrese una contraseña");
			String contraseña = Sc.nextLine();
			usuario nuevo_Usuario = new usuario(nombre,contraseña,0);
			while (listaUsuario.buscarUsuario(nuevo_Usuario.getNombre())!= null ) {
				System.out.println("Usuario  ya registrado ");
				System.out.println("ingrese nuevamente un nombre de usuario: ");
				nombre=Sc.nextLine();
				System.out.println("ingrese nuevamente una contraseña: ");
				contraseña = Sc.nextLine();
			}
			listaUsuario.agregarUsuario(nuevo_Usuario);
			System.out.println("Usuario registrado correctamente");
			
			
		}
//		
			
		
		

		
		
	}

}
