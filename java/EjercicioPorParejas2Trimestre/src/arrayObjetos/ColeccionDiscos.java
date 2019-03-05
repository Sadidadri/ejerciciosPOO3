package arrayObjetos;
/**
 * Modifica el programa �Colecci�n de discos� como se indica a continuaci�n:
 * a) Mejora la opci�n �Nuevo disco� de tal forma que cuando se llenen todas las
 * posiciones del array, el programa muestre un mensaje de error. No se permitir�
 * introducir los datos de ning�n disco hasta que no se borre alguno de la lista.
 *  b) Mejora la opci�n �Borrar� de tal forma que se verifique que el c�digo
 *  introducido por el usuario existe.
 *  c) Modifica el programa de tal forma que el c�digo del disco sea �nico, es decir
 *  que no se pueda repetir.
 *  d) Crea un submen� dentro dentro de �Listado� de tal forma que exista un
 *  listado completo, un listado por autor (todos los discos que ha publicado un
 *  determinado autor), un listado por g�nero (todos los discos de un g�nero determinado) y un listado de discos cuya duraci�n est� en un rango determinado
 *  por el usuario.
 * @author d18momoa
 *
 */
public class ColeccionDiscos{
  // N determina el tama�o del array
  static int N = 100;

  public static void main(String[] args) {
    //Crea el array de discos
    Disco[] album = new Disco[N];
    // Crea todos los discos que van en cada una de
    // las celdas del array
    for(int i = 0; i < N; i++) {
      album[i] = new Disco();
    }

    int opcion;
    String codigoIntroducido;
    String autorIntroducido;
    String tituloIntroducido;
    String generoIntroducido;
    String duracionIntroducidaString;
    int duracionIntroducida;
    int primeraLibre;
    int i;
    
    do {
      System.out.println("\n\nCOLECCI�N DE DISCOS");
      System.out.println("===================");
      System.out.println("1. Listado");
      System.out.println("2. Nuevo disco");
      System.out.println("3. Modificar");
      System.out.println("4. Borrar");
      System.out.println("5. Salir");
      System.out.print("Introduzca una opci�n: ");
      opcion = Integer.parseInt(System.console().readLine());
      
      switch (opcion) {
      case 1:
        int opcionSubMenu;
        System.out.println("�C�mo desea mostrar el listado?");
        System.out.println("1.-Listado Completo");
        System.out.println("2.-Listado por Autor");
        System.out.println("3.-Listado por g�nero");
        System.out.println("4.-Listado seg�n duraci�n");
        System.out.print("Introduzca una opci�n: ");
        opcionSubMenu = Integer.parseInt(System.console().readLine());
        switch(opcionSubMenu) {
        	case 1:
        		System.out.println("\nLISTADO");
            System.out.println("=======");
            for(i = 0; i < N; i++) {
              if (!album[i].getCodigo().equals("LIBRE")) {
                System.out.println(album[i]);
              }
            }
        		break;
        	case 2:
        		
        		break;
        	case 3:
        		break;
        	case 4:
        		break;
        	default:
        		break;
        }
        
        break;
        
      case 2:
        System.out.println("\nNUEVO DISCO");
        System.out.println("===========");
        
        // Busca la primera posici�n libre del array
        primeraLibre = -1;
        do {
          primeraLibre++; 
        } while (!((album[primeraLibre].getCodigo()).equals("LIBRE")));
        if (primeraLibre == N) {
        	System.out.println("No se permitir� introducir los datos de ning�n disco hasta que no se borre alguno de la lista");
        }
        else{
        	System.out.println("Por favor, introduzca los datos del disco.");  
        	
        	boolean compruebaSiExisteCodigo;
        	do {
        		compruebaSiExisteCodigo = false;
        		System.out.print("C�digo: ");
        		codigoIntroducido = System.console().readLine();
        		album[primeraLibre].setCodigo(codigoIntroducido);
        		for(int x = 0;x<album.length;x++) {
        			if (album[x].getCodigo().equals(codigoIntroducido)) {
        				System.err.println("El codigo introducido ya existe, prueba con otro.");
        			}
        		}
        	}while(compruebaSiExisteCodigo);
        	System.out.print("Autor: ");
        	autorIntroducido = System.console().readLine();
        	album[primeraLibre].setAutor(autorIntroducido);
        
        	System.out.print("T�tulo: ");
        	tituloIntroducido = System.console().readLine();
        	album[primeraLibre].setTitulo(tituloIntroducido);
        
        	System.out.print("G�nero: ");
        	generoIntroducido = System.console().readLine();
        	album[primeraLibre].setGenero(generoIntroducido);
        
        	System.out.print("Duraci�n: ");
        	duracionIntroducida = Integer.parseInt(System.console().readLine());
        	album[primeraLibre].setDuracion(duracionIntroducida);
        }
        break;
        
      case 3:
        System.out.println("\nMODIFICAR");
        System.out.println("===========");
        
        System.out.print("Por favor, introduzca el c�digo del disco cuyos datos desea cambiar: ");
        codigoIntroducido = System.console().readLine();
  
        i = -1;
        do {
          i++;
        } while (!((album[i].getCodigo()).equals(codigoIntroducido)));
        
        System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
        boolean compruebaSiExisteCodigo;
        do {
	        compruebaSiExisteCodigo = false;
	        System.out.println("C�digo: " + album[i].getCodigo());
	        System.out.print("Nuevo c�digo: ");
	        codigoIntroducido = System.console().readLine();
	        for(int x = 0;x<album.length;x++) {
	    			if (album[x].getCodigo().equals(codigoIntroducido)) {
	    				System.err.println("El codigo introducido ya existe, prueba con otro.");
	    			}
	    		}
        }while(compruebaSiExisteCodigo);
        if (!codigoIntroducido.equals("")) {
          album[i].setCodigo(codigoIntroducido);
        }
        
        System.out.println("Autor: " + album[i].getAutor());
        System.out.print("Nuevo autor: ");
        autorIntroducido = System.console().readLine();
        if (!autorIntroducido.equals("")) {
          album[i].setAutor(autorIntroducido);
        }
        
        System.out.println("T�tulo: " + album[i].getTitulo());
        System.out.print("Nuevo t�tulo: ");
        tituloIntroducido = System.console().readLine();
        if (!tituloIntroducido.equals("")) {
          album[i].setTitulo(tituloIntroducido);
        }
        
        System.out.println("G�nero: " + album[i].getGenero());
        System.out.print("Nuevo g�nero: ");
        generoIntroducido = System.console().readLine();
        if (!generoIntroducido.equals("")) {
          album[i].setGenero(generoIntroducido);
        }
        
        System.out.println("Duraci�n: " + album[i].getDuracion());
        System.out.print("Duraci�n: ");
        duracionIntroducidaString = System.console().readLine();
        if (!duracionIntroducidaString.equals("")) {
          album[i].setDuracion(Integer.parseInt(duracionIntroducidaString));
        }
        
        break;
      case 4:
        System.out.println("\nBORRAR");
        System.out.println("======");
        
        System.out.print("Por favor, introduzca el c�digo del disco que desea borrar: ");
        codigoIntroducido = System.console().readLine();
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
