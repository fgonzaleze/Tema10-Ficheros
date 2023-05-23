package ejercicios;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio06 {

	/*
	 * Implementa un programa que lea números enteros no ordenados de un archivo,
	 * con un número por línea, y los almacene en una lista. A continuación, debe
	 * guardar los números de la lista en otro fichero distinto pero ordenados de
	 * forma ascendente.
	 * 
	 */

	public static void main(String[] args) {

		TreeSet<Integer> numeros = new TreeSet();
		int numero = 0;
		String numString;
		BufferedWriter bw;

		try {
			bw = new BufferedWriter(new FileWriter("src\\ejercicios\\NumerosAscendente.txt"));
			Scanner sc = new Scanner(new FileReader("src\\ejercicios\\Numeros.txt"));

			while (sc.hasNextInt()) {
				numero = sc.nextInt();
				numeros.add(numero);
			}
			for (int num : numeros) {
				numString = Integer.toString(num);
				bw.write(numString);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			System.out.println(numeros);
		} catch (IOException e) {
			System.out.println("Error");
		}

	}

}
