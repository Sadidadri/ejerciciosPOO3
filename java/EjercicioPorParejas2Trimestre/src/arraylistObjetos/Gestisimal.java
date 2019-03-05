package arraylistObjetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestisimal {
	static ArrayList<Articulo> lista = new ArrayList<Articulo>();
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		//Creacion del arraylist que contendra los articulos
		System.out.println("Bienvenido al menu Gestisimal:");
		do {
			mostrarMenu(); //Pide al usuario introducir un numero para escoger la opcion
			System.out.println("Elige una opción:");
			int opcion = entrada.nextInt();
			entrada.nextLine();
			switch(opcion) {
				case 1: //Muestra lista
					System.out.println("Tenemos:");
					mostrarLista();
					break;
				case 2: //Agnade un elemento a la lista
					System.out.println("Vamos a dar de alta un articulo, rellene los siguientes datos:");
					annadirNuevoArticulo();		 
					break;
				case 3: //borra un elemento de la lista
					borrarArticulo();
					break;
				case 4: //Modifica un elemento de la lista
					modificarArticulo();
				break;
				case 5: //Aumenta el stock de un elemento de la lista
					entradaMercancia();
					break;
				case 6: //Decrementa el stock de un elemento de la lista
					salidaMercancia();
					break;
				case 7: //Sale del programa
					System.out.println("Saliendo...");
					System.exit(1);
					break;
				default:System.err.println("Has introducido una opcion incorrecta");
					break;
			}
		}while(true);
	}
/**
 * Muestra las opciones del menu
 */
	static void mostrarMenu() {
		System.out.println("1. Listado\n"+
				"2. Alta\n"+
				"3. Baja\n"+
				"4. Modificación\n"+
				"5. Entrada de mercancía\n"+
				"6. Salida de mercancía\n"+
				"7. Salir\n");
	}
	/**
	 * Muestra el contenido de la lista
	 */
	static void mostrarLista() {
		if (lista.size() == 0) {
			System.out.println("La lista de articulos ahora mismo esta vacia");
		}
		for(Articulo e : lista) {
			System.out.println(e);
		}
	}
	/**
	 * Agnade un articulo a la lista
	 */
	public static void annadirNuevoArticulo() {
		boolean compruebaCodigo;
		int codigo;
		do {
			compruebaCodigo = false;
			System.out.println("Introduzca el codigo del producto:");
			codigo = entrada.nextInt();
			entrada.nextLine();
			for(Articulo a: lista) {
				if(a.getCodigo() == codigo) {
					compruebaCodigo = true;
					System.err.println("El codigo introducido ya existe, introduzca otro:");
				}
			}
		}while(compruebaCodigo);
		System.out.println("Introduzca su descripcion:");
		String descripcion = entrada.nextLine();
		System.out.println("Introduzca un precio de compra:");
		double precioCompra = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("Introduzca un precio de venta:");
		double precioVenta = entrada.nextDouble();
		System.out.println("Introduzca la cantidad del producto:");
		int stock = entrada.nextInt();
		entrada.nextLine();
		lista.add(new Articulo(codigo,descripcion,precioCompra,precioVenta,stock));
	}
	/**
	 * Borra un articulo de la lista
	 */
	public static void borrarArticulo() {
		if(compruebaTamagnoLista()) {
			System.out.println("Vamos a borrar un articulo, introduzca el codigo del articulo a borrar:");
			boolean compruebaCodigo = false;
			int codigo = entrada.nextInt();
			entrada.nextLine();
			for(Articulo a: lista) {
				if(a.getCodigo() == codigo) {
					System.out.println("Borrando el articulo con codigo"+codigo+"...");
					lista.remove(a);
					compruebaCodigo = true;
				}
			}
			if(!compruebaCodigo) {
				System.out.println("No hemos podido encontrar un articulo con ese indice.");
			}
		}
		else {
			System.out.println("La lista de articulos esta vacia, no hay donde borrar");
		}
	}
	/**
	 * Comprueba que el tamagno de la lista sea mayor que 0
	 * @return true si es mayor que 0, false si es menor igual que 0
	 */
	public static boolean compruebaTamagnoLista() {
		boolean comprobador = (lista.size()>=1)? true: false;
		return comprobador;
	}
	/**
	 * Modifica un articulo de la lista
	 */
	public static void modificarArticulo() {
		if(compruebaTamagnoLista()) {
			int indiceObtenido = 0;
			boolean compruebaArticuloExistente = false;
			int codigoBusqueda;
			System.out.println("Introduzca el codigo del articulo a modificar:");
			codigoBusqueda = entrada.nextInt();
			entrada.nextLine();
			for(Articulo a : lista) {
				if(a.getCodigo() == codigoBusqueda) {
					compruebaArticuloExistente = true;
					indiceObtenido = lista.indexOf(a);
				}
			}
			if (compruebaArticuloExistente) {
				boolean compruebaCodigo;
				int codigo;
				do {
					compruebaCodigo = false;
					System.out.println("Introduzca el nuevo codigo del producto:");
					codigo = entrada.nextInt();
					entrada.nextLine();
					for(Articulo a: lista) {
						if(a.getCodigo() == codigo) {
							compruebaCodigo = true;
							System.err.println("El codigo introducido ya existe, introduzca otro:");
						}
					}
				}while(compruebaCodigo);
				System.out.println("Introduzca la nueva descripcion:");
				String descripcion = entrada.nextLine();
				System.out.println("Introduzca el nuevo precio de compra:");
				double precioCompra = entrada.nextDouble();
				entrada.nextLine();
				System.out.println("Introduzca el nuevo precio de venta:");
				double precioVenta = entrada.nextDouble();
				System.out.println("Introduzca la cantidad nueva del producto:");
				int stock = entrada.nextInt();
				entrada.nextLine();
				lista.set(indiceObtenido,new Articulo(codigo,descripcion,precioCompra,precioVenta,stock));
			}else {
				System.out.println("Has introducido un indice que no corresponde a ningun articulo existente");
			}
		}else {
			System.out.println("La lista está vacia, no hay elemento a modificar.");
		}
	}
	/**
	 * Aumenta una unidad el stock de un articulo de la lista
	 */
	public static void entradaMercancia() {
		if(compruebaTamagnoLista()) {
			boolean compruebaCodigo;
			int codigo;
			do {
				compruebaCodigo = true;
				System.out.println("Introduzca el codigo del producto a aumentar su stock:");
				codigo = entrada.nextInt();
				entrada.nextLine();
				for(Articulo a: lista) {
					if(a.getCodigo() == codigo) {
						compruebaCodigo = false;
						System.out.println("Aumentando el stock del articulo con codigo: "+codigo);
						a.entraMercancia();
					}
				}
			}while(compruebaCodigo);
		}
		else {
			System.out.println("La lista no tiene elementos, no puede realizarse un aumento de stock");
		}	
	}
	/**
	 * Decrementa una unidad el stock de un articulo de la lista
	 */
	public static void salidaMercancia() {
		if(compruebaTamagnoLista()) {
			boolean compruebaCodigo;
			int codigo;
			do {
				compruebaCodigo = true;
				System.out.println("Introduzca el codigo del producto a decrementar su stock:");
				codigo = entrada.nextInt();
				entrada.nextLine();
				for(Articulo a: lista) {
					if(a.getCodigo() == codigo) {
						compruebaCodigo = false;
						System.out.println("Aumentando el stock del articulo con codigo: "+codigo);
						a.saleMercancia();
					}
				}
			}while(compruebaCodigo);
		}
		else {
			System.out.println("La lista no tiene elementos, no puede realizarse un decremento de stock");
		}	
	}
}