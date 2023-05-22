package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio02 {
	/*
	 * Crear con un editor el fichero de texto Enteros.txt en la carpeta del
	 * proyecto y escribe en él una serie de números enteros separados por
	 * secuencias de espacios y tabuladores, incluso en líneas distintas, tal como:
	 * 2	3  45		73
  	 * 123		4   21
	 * Implementar un programa que acceda a Enteros.txt con un objeto Scanner a
	 * través de un flujo de entrada, lea los números y calcule la suma y la media
	 * aritmética, mostrando los resultados por pantalla.
	 * 
	 */

	public static void main(String[] args) {
		double suma = 0;
		double media = 0;
		int contador = 0;

		try {
			Scanner sc = new Scanner(new FileReader("src\\ejercicios\\Enteros"));

			while (sc.hasNextDouble()) {
				suma += sc.nextDouble();
				contador++;
			}
			media = suma / contador;
			System.out.println("Suma: " + suma);
			System.out.println("Media: " + media);
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
		}

	}

}
