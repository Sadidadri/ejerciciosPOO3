package arrayObjetos;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Modifica el programa “Colección de discos” como se indica a continuación:
 * a) Mejora la opción “Nuevo disco” de tal forma que cuando se llenen todas las
 * posiciones del array, el programa muestre un mensaje de error. No se permitirá
 * introducir los datos de ningún disco hasta que no se borre alguno de la lista.
 *  b) Mejora la opción “Borrar” de tal forma que se verifique que el código
 *  introducido por el usuario existe.
 *  c) Modifica el programa de tal forma que el código del disco sea único, es decir
 *  que no se pueda repetir.
 *  d) Crea un submenú dentro dentro de “Listado” de tal forma que exista un
 *  listado completo, un listado por autor (todos los discos que ha publicado un
 *  determinado autor), un listado por género (todos los discos de un género determinado) y un listado de discos cuya duración esté en un rango determinado
 *  por el usuario.
 * @author d18momoa
 *
 */
public class ColeccionDiscos{
  // N determina el tamaño del array
  static int N = 100;

  public static void main(String[] args) {
  	Scanner entrada = new Scanner(System.in);
    //Crea el array de discos
    Disco[] album = new Disco[N];
    // Crea todos los discos que van en cada una de
    // las celdas del array
    for(int i = 0; i < N; i++) {
      album[i] = new Disco();
    }
    //Declaracion variable
    int opcion;
    String codigoIntroducido;
    String autorIntroducido;
    String tituloIntroducido;
    String generoIntroducido;
    String duracionIntroducidaString;
    int duracionIntroducida;
    int primeraLibre;
    int i;
    
    do {//mostrar menu
      System.out.println("\n\nCOLECCIÓN DE DISCOS");
      System.out.println("===================");
      System.out.println("1. Listado");
      System.out.println("2. Nuevo disco");
      System.out.println("3. Modificar");
      System.out.println("4. Borrar");
      System.out.println("5. Salir");
      System.out.print("Introduzca una opción: ");
      opcion = entrada.nextInt();      
      entrada.nextLine();//nextline despues del nextInt para evitar fallos
      switch (opcion) {
      case 1:
      	//Dentro del listado, se hace un submenu para indicar como mostrar el array
        int opcionSubMenu;
        System.out.println("¿Cómo desea mostrar el listado?");
        System.out.println("1.-Listado Completo");
        System.out.println("2.-Listado por Autor");
        System.out.println("3.-Listado por género");
        System.out.println("4.-Listado según duración");
        System.out.print("Introduzca una opción: ");
        opcionSubMenu = entrada.nextInt();
        entrada.nextLine();
        switch(opcionSubMenu) {
        	case 1:
        		//Listado normal
        		System.out.println("\nLISTADO");
            System.out.println("=======");
            for(i = 0; i < N; i++) {
              if (!album[i].getCodigo().equals("LIBRE")) {
                System.out.println(album[i]);
              }
            }
        		break;
        	case 2:
        		//Para ordenarlo alfabeticamente por autor, es necesario usar arraylist
        		System.out.println("\nLISTADO POR AUTOR");
            System.out.println("=======");
        		
        		break;
        	case 3:
        	//Para ordenarlo alfabeticamente por genero, es necesario usar arraylist
        		System.out.println("\nLISTADO POR GENERO");
            System.out.println("=======");
        		break;
        	case 4:
        	//Por duracion si se puede, ya que el atributo duracion es un valor numerico
        		System.out.println("\nLISTADO POR DURACION");
            System.out.println("=======");
            Arrays.sort(album);
            for(i = 0; i < N; i++) {
              if (!album[i].getCodigo().equals("LIBRE")) {
                System.out.println(album[i]);
              }
            }
        		break;
        	default:
        		System.out.println("Has introducido una opcion no valida");
        		break;
        }
        
        break;
        
      case 2:
     // Busca la primera posición libre del array
      	
      	if (!album[N-1].getCodigo().equals("LIBRE")) {
        	System.err.println("No se permitirá introducir los datos de ningún disco hasta que no se borre alguno de la lista");
        }
      	else{
	        System.out.println("\nNUEVO DISCO");
	        System.out.println("===========");
	        System.out.println("Por favor, introduzca los datos del disco.");  
	        
	        //Comprobamos que el codigo sea unico
	        boolean compruebaSiExisteCodigo;
	        do {
	        	compruebaSiExisteCodigo = false;
	        	System.out.print("Código: ");
	        	codigoIntroducido = entrada.nextLine();
	        	for(int x = 0;x<album.length;x++) {
	        		if (album[x].getCodigo().equals(codigoIntroducido)) {
	        			System.err.println("El codigo introducido ya existe, prueba con otro.");
	        			compruebaSiExisteCodigo = true;
	        		}
	       		}
	        }while(compruebaSiExisteCodigo);
	        	//Busca la primera posicion que esté libre
	        	primeraLibre = 0;
	        	while (!((album[primeraLibre].getCodigo()).equals("LIBRE"))) {
	        		primeraLibre++; 
	        	}
	        	album[primeraLibre].setCodigo(codigoIntroducido);
	        	System.out.print("Autor: ");
	        	autorIntroducido = entrada.nextLine();
	        	album[primeraLibre].setAutor(autorIntroducido);
	        
	        	System.out.print("Título: ");
	        	tituloIntroducido = entrada.nextLine();
	        	album[primeraLibre].setTitulo(tituloIntroducido);
	        
	        	System.out.print("Género: ");
	        	generoIntroducido = entrada.nextLine();
	        	album[primeraLibre].setGenero(generoIntroducido);
	        
	        	System.out.print("Duración: ");
	        	duracionIntroducida = entrada.nextInt();
	        	entrada.nextLine();
	        	album[primeraLibre].setDuracion(duracionIntroducida);
      		}
        break;
        
      case 3:
        System.out.println("\nMODIFICAR");
        System.out.println("===========");
        
        System.out.print("Por favor, introduzca el código del disco cuyos datos desea cambiar: ");
        codigoIntroducido = entrada.nextLine();
  
        i = -1;
        do {
          i++;
        } while (!((album[i].getCodigo()).equals(codigoIntroducido)));
        
        System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
        boolean compruebaSiExisteCodigo;
        do {
	        compruebaSiExisteCodigo = false;
	        System.out.println("Código: " + album[i].getCodigo());
	        System.out.print("Nuevo código: ");
	        codigoIntroducido = entrada.nextLine();
	        for(int x = 0;x<album.length;x++) {
	    			if (album[x].getCodigo().equals(codigoIntroducido)) {
	    				System.err.println("El codigo introducido ya existe, prueba con otro.");
	    				compruebaSiExisteCodigo = true;
	    			}
	    		}
        }while(compruebaSiExisteCodigo);
        if (!codigoIntroducido.equals("")) {
          album[i].setCodigo(codigoIntroducido);
        }
        
        System.out.println("Autor: " + album[i].getAutor());
        System.out.print("Nuevo autor: ");
        autorIntroducido = entrada.nextLine();
        if (!autorIntroducido.equals("")) {
          album[i].setAutor(autorIntroducido);
        }
        
        System.out.println("Título: " + album[i].getTitulo());
        System.out.print("Nuevo título: ");
        tituloIntroducido = entrada.nextLine();
        if (!tituloIntroducido.equals("")) {
          album[i].setTitulo(tituloIntroducido);
        }
        
        System.out.println("Género: " + album[i].getGenero());
        System.out.print("Nuevo género: ");
        generoIntroducido = entrada.nextLine();
        if (!generoIntroducido.equals("")) {
          album[i].setGenero(generoIntroducido);
        }
        
        System.out.println("Duración: " + album[i].getDuracion());
        System.out.print("Duración: ");
        duracionIntroducidaString = entrada.nextLine();
        if (!duracionIntroducidaString.equals("")) {
          album[i].setDuracion(Integer.parseInt(duracionIntroducidaString));
        }
        
        break;
      case 4:
        System.out.println("\nBORRAR");
        System.out.println("======");
        
        System.out.print("Por favor, introduzca el código del disco que desea borrar: ");
        codigoIntroducido = entrada.nextLine();
        i = -1;
        do {
          i++;
        } while (!((album[i].getCodigo()).equals(codigoIntroducido)));
        if (album[i].getCodigo().equals(codigoIntroducido)) {
        	album[i].setCodigo("LIBRE");
          System.out.println("Album borrado.");
        }
        else {
        	System.err.println("Lo sentimos, pero no hemos podido encontrar un Disco con ese codigo.");
        }
        break;   
      default:
      } // switch
    } while (opcion != 5);
  }
  
}
