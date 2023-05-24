package ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio03 {

	/*
	 * Crea con un editor el fichero de texto Alumnos.txt en la carpeta del proyecto
	 * y escribe en él los nombres, edades y estaturas de los alumnos de un grupo,
	 * cada uno en una línea:
	 * 
	 * juan 22 1.77 luis 21 1.80 pedro 20 1.73 … Implementa un programa que lea del
	 * fichero los datos, muestre los nombres y calcule la media de la edad y de las
	 * estaturas, mostrándolas por pantalla.
	 * 
	 */

	public static void main(String[] args) {
		String linea = "";
		String[] nombres = new String[0];
		int sumaEdad = 0;
		double sumaAltura = 0;
		int contador = 0;

		try {
			// Creamos un buffered reader para el archivo Alumnos.txt
			BufferedReader br = new BufferedReader(new FileReader("src\\ejercicios\\Alumnos"));
			
			// La linea que iremos leyendo
			linea = br.readLine();
			System.out.println("Nombres de los alumnos: \n");
			// Mientras la linea no sea a null (será null cuando llegue al final escrito del fichero)
			while (linea != null) {
				
				// Pa separar a partir de un espacio
				nombres = linea.split(" ");
				
				// Imprimir los nombres que en el split será el primer parámetro
				System.out.println(nombres[0]);
				
				// La suma de la edad será el parse int (convertir de string a Int) de la posición 1 que serán las edades
				sumaEdad += Integer.parseInt(nombres[1]);
				
				// La suma de la altura será el parse double (convertir de string a double) de la posicion 2  que serán las alturas
				sumaAltura += Double.parseDouble(nombres[2]);
				
				// Contador para ir sumando y realizar la media
				contador++;
				
				linea = br.readLine();
			}
			
			// Imprimimos todos los datos
			System.out.println();
			System.out.println("El total de las edades de los alumnos es de : " + sumaEdad + " años");
			System.out.println("La edad media de los alumnos es de: " + (double) sumaEdad / contador + " años");
			System.out.println("El total de las alturas de los alumnos es de: " + sumaAltura + " metros");
			System.out.println("La altura media de los alumnos es de: " + (double) sumaAltura / contador + " metros");
			
		// Excepción en caso de que no encuentre el fichero
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
			e.getMessage();
		// Excepción en caso de que el fichero esté vacío
		} catch (IOException e) {
			System.out.println("El fichero está vacío");
			e.getMessage();

		}

	}

}
