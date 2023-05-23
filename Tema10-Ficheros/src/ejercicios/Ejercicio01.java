package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio01 {
	
		/*
		 * Crea con un editor el fichero de texto NumerosReales.txt en la carpeta del
		 * proyecto. Escribe en él una serie de números reales separados por espacios
		 * simples. Implementar un programa que acceda a NumerosReales.txt, lea los
		 * números y calcule la suma y la media aritmética, mostrando los resultados por
		 * pantalla.
		 * 
		 */
	
	public static void main(String[] args) {
		// Variable suma donde contendrá la suma de los numros reales
		double suma = 0;
		// Variable con la media de los numeros reales
		double media;
		// Variable con un contador para las veces de que se pasa
		int contador = 0;
		
		try {
			Scanner sc = new Scanner(new FileReader("src\\ejercicios\\NumerosReales"));
			
			// Bucle while mientras tenga double
			while(sc.hasNextDouble()) {
				suma += sc.nextDouble();
				contador++;
			}
			
			media = suma / contador;
			
			System.out.println("Suma: " + suma);
			System.out.println("Media: " + media);
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			e.getMessage();
		}
	
	}

}
