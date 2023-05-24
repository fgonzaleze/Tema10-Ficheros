package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Implementa una aplicación que mantenga un registro de las temperaturas máxima y mínima diarias medidas en una estación meteorológica. 
 * Los datos se guardarán en un archivo de texto con el siguiente formato:
 * Fecha,Temperatura máxima,Temperatura mínima
 * 2020-01-15,12,-1
 * 2020-01-16,15,2
 * Al arrancar la aplicación aparecerá un menú con las opciones:
 * Registra nueva temperatura.
 * Mostrar historial de registros.
 * Salir.
 * El historial de registros mostrará todos los datos registrados junto con el máximo valor de las 
 * temperaturas máximas y el mínimo de las temperaturas mínimas.
 */

public class Ejercicio08 {

	// Dado que vamos a usar la ruta dinámica del fichero varias veces, conviene
	// convertirlo en una constante
	private static final String FICHERO = "src\\ejercicios\\Temperaturas.txt";

	public static void main(String[] args) {
		// Variable para la opcion del switch
		int opc;
		// String que contendrá la linea que leeremos con el br
		String linea;
		// String que contendrá la fecha
		String fecha;
		// Para la temperatura minima de cada dia
		double tempMin;
		// Para la temperatura maxima de cada dia
		double tempMax;
		// variables para el minimo y maximo total de todos los dias, inicializando el
		// max_value y el min_value y cambiandolos despues
		double tempMinTotal = Double.MAX_VALUE;
		double tempMaxTotal = Double.MIN_VALUE;
		// Array de strings para cuando cortemos las lineas de nuestro txt
		String[] datos;
		// Escáner para la consola
		Scanner sc = new Scanner(System.in);
		// Para leer y escribir el fichero
		BufferedWriter bw = null;
		BufferedReader br = null;

		try {
			bw = new BufferedWriter(new FileWriter(FICHERO, true));

			do {
				// Llamamos al menu
				menu();
				opc = sc.nextInt();
				sc.nextLine();

				// Switch para las diferentes opciones
				switch (opc) {
				case 1:
					// Pedimos fecha
					System.out.println("Introduzca la fecha (Formato: aaaa-mm-dd):");
					fecha = sc.nextLine();
					// Pedimos temperaturas
					System.out.println("Introduzca la temperatura mínima:");
					tempMin = sc.nextDouble();
					sc.nextLine();
					System.out.println("Introduzca la temperatura máxima:");
					tempMax = sc.nextDouble();
					sc.nextLine();
					// Escribimos en el archivo con write
					bw.write(fecha + "," + tempMax + "," + tempMin);
					// Aseguramos hacer un salto de linea para ir pasando a la siguiente
					bw.newLine();
					// Actualizamos el archivo
					bw.flush();

					break;
				case 2:
					br = new BufferedReader(new FileReader(FICHERO));
					// Salto de linea vacio porque la primera linea no nos interesa
					br.readLine();
					// Empezamos a leer las lineas
					linea = br.readLine();
					while (linea != null) {
						// El array de datos lo llenamos de lo separado por comas, en este caso será:
						// fecha [0], temperatura maxima [1], temperatura minima [2]
						datos = linea.split(",");
						System.out.println("Fecha: " + datos[0]);
						// Parse double para sacar las temperaturas
						tempMax = Double.parseDouble(datos[1]);
						tempMin = Double.parseDouble(datos[2]);

						System.out.println("Temperatura máxima: " + tempMax);
						System.out.println("Temperatura mínima: " + tempMin);
						System.out.println("--------------------------------");
						// Para sacar la temperatura maxima total
						if (tempMaxTotal < tempMax) {
							tempMaxTotal = tempMax;
						}
						// Para sacar la temperatura minima total
						if (tempMinTotal > tempMin) {
							tempMinTotal = tempMin;
						}
						// Para seguir leyendo las lineas en el fichero
						linea = br.readLine();
					}
					System.out.println("Temperatura máxima total: " + tempMaxTotal);
					System.out.println("Temperatura mínima total: " + tempMinTotal);
					System.out.println();
					break;
				default:
					System.out.println("La opción introducida no es correcta");

				}
				// Para salirnos serña la opcion 3
			} while (opc != 3);

			// Excepción para cuando no se pueda abrir el fichero
		} catch (IOException e) {
			System.out.println("Error al abrir el fichero");
			System.out.println(e.getMessage());
			// En el finally cerramos todo
		} finally {
			// Como el bw lo hemos declarado a null necesitamos esta condición
			if (bw != null) {
				try {
					bw.close();
					br.close();
					sc.close();
					// En caso de que no se pueda cerra el fichero
				} catch (IOException e) {
					System.out.println("Error al cerrar el fichero");
					System.out.println(e.getMessage());
				}
			}
		}

	}

	/**
	 * Meotodo para imprimir el menu por pantalla
	 */
	public static void menu() {
		System.out.println("1. Registra nueva temperatura.");
		System.out.println("2. Mostrar historial de registros.");
		System.out.println("3. Salir.");
	}

}
