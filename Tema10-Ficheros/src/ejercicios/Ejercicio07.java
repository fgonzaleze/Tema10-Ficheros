package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio07 {
	/*
	 * Diseña una pequeña agenda, que muestre el siguiente menú: 
	 * 
	 * Nuevo contacto.
	 * Buscar por nombre. 
	 * Mostrar todos. 
	 * Salir. 
	 * 
	 * En ella, guardaremos el nombre y el
	 * teléfono de un máximo de 20 personas. La opción 1 nos permitirá introducir un
	 * nuevo contacto siempre y cuando la agenda no esté llena, comprobando que el
	 * nombre no se encuentra ya insertado. La opción 2 pedirá el nombre a buscar en
	 * la agenda y mostrará el teléfono correspondiente a dicho nombre. La opción 3
	 * mostrará un listado con toda la información (nombres y teléfonos) ordenados
	 * alfabéticamente por nombre. Por último, la opción 4 guarda todos los datos de
	 * la agenda en el archivo agenda.txt. La próxima vez que se ejecute la
	 * aplicación, si hay datos guardados, se cargarán en memoria. 
	 * Consejo: utiliza una colección para el tratamiento de la agenda. ¿Cuál es la colección más
	 * adecuada en este caso?
	 * 
	 */
		// Escaner fuera estatico para los metodos
		static Scanner sc = new Scanner(System.in);
		// BR para escribir en el fichero
		static BufferedWriter br;
		// TreeMap es lo mejor para guardar los contactos y sus datos
		static TreeMap<String, Integer> contactos = new TreeMap<>();
		// Dado que vamos a usar la ruta dinámica del fichero varias veces, conviene
		// convertirlo en una constante
		private static final String AGENDA = "src\\ejercicios\\Agenda.txt";

	
		public static void main(String[] args) {
			// La opcion del usuario para el switch
			int opc = 0;

			do {
				// Mostramos el menu y llamamos a las funciones
				menu();
				opc = sc.nextInt();
				switch (opc) {
				case 1:
					anadirContacto();
					break;
				case 2:
					buscarNombre();
					break;
				case 3:
					mostrarTodos();
					break;
				case 0:
					System.out.println("Ha salido de la agenda");
					break;
				default:
					System.out.println("Elija otra opcion");
					break;
				}
			} while (opc != 0);
		}

		public static void menu() {
			System.out.println("Agenda");
			System.out.println("Seleccione una opción");
			System.out.println("1.Añadir un nuevo contacto.");
			System.out.println("2.Buscar por nombre.");
			System.out.println("3.Mostrar todos los contactos guardados.");
			System.out.println("0.Salir");

		}

		public static void anadirContacto() {
			// Necesitamos el nombre y el numero de tlfn
			String nombre = "";
			int numero = 0;
			System.out.println("Introduzca el nombre");
			nombre = sc.next();
			sc.nextLine();
			System.out.println("Introduzca el numero.");
			numero = sc.nextInt();
			sc.nextLine();
			if (contactos.containsKey(nombre)) {
				System.out.println("Ese nombre ya existe en la agenda");
			} else {
				contactos.put(nombre, numero);
				System.out.println("Se ha guardado un nuevo contacto.");
			}
			try {
				// Para que no borre hay que poner el append (booleano) en true
				br = new BufferedWriter(new FileWriter(AGENDA, true));
				// For each para ir recorriendo el map
				for (String nom : contactos.keySet()) {
					nombre = nom;
					numero = contactos.get(nombre);
					// Escribirmos el nombre y el numero separados con un espacio
					br.write(nombre + " " + numero);
					br.newLine();
				}
				// flush para pasarlo al archivo
				br.flush();
			} catch (IOException e) {
				System.out.println("Error al guardar datos");
				System.out.println(e.getMessage());
			}

		}

		/*
		 * Metodo para buscar por el nombre
		 */
		public static void buscarNombre() {
			String nombre = "";
			System.out.println("Introduzca el nombre del contacto:");
			nombre = sc.next();
			sc.nextLine();
			// Si el nombre se encuentra, lo imprimimos
			if (contactos.containsKey(nombre)) {
				System.out.println(nombre + ": " + contactos.get(nombre));
				// Sino, el nombre no está en la agenda
			} else {
				System.out.println("El nombre que buscar no tiene ningun numero registrado.");
			}

		}

		/*
		 * Metodo para mostrar los datos de la agenda
		 */
		public static void mostrarTodos() {
			// La linea que leeremos
			String linea;
			try {
				BufferedReader br = new BufferedReader(new FileReader(AGENDA));
				linea = br.readLine();
				// Mientras la linea no sea nula
				while (linea != null) {
					System.out.println();
					System.out.println(linea);
					// Volvemos a leer
					linea = br.readLine();
				}
			} catch (IOException e) {
				System.out.println("Error al leer el fichero");
				e.printStackTrace();
			}
			System.out.println();
		}

	}
