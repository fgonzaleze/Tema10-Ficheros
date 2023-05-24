package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04 {

	/*
	 * Escribe un texto en un archivo de texto, línea a línea leídas de teclado,
	 * hasta que se introduzca la cadena “fin”.
	 */

	public static void main(String[] args) {
		
		// variable para recoger el texto que se escriba por consola
		String texto = "";
		// Declaramos el bw a null
		BufferedWriter bw = null; 
		// Guardamos la ruta del fichero para una mejor organización
		String fichero = "src\\ejercicios\\Ejercicio4Texto";
		// Abrimos el escaner
		Scanner sc = new Scanner(System.in);
		
		try {
			bw = new BufferedWriter(new FileWriter(fichero)); 
			System.out.println("Introduzca unas líneas de texto: ");
			texto = sc.nextLine();

			bw.write(texto);

			while (!texto.equals("fin")) {
				bw.newLine();
				texto = sc.next();
				bw.write(texto);
			}
			System.out.println("Se ha añadido con éxito el texto");
			sc.close();
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo");
			System.out.println(e.getMessage());
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar el archivo");
				System.out.println(e.getMessage());
			}
		}

	}

}
