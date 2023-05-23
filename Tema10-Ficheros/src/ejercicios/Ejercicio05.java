package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio05 {
	
		/*
		 * Diseña una aplicación que pida al usuario su nombre y edad. Estos datos deben
		 * guardarse en el fichero datos.txt. Si este fichero existe, deben añadirse al
		 * final en una nueva línea, y en caso de no existir, debe crearse.
		 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nombre = "";
		int edad = 0;
		String opcion = "";

		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("src\\ejercicios\\datos.txt", true));
			System.out.println("Desea introducir datos? S/N");
			opcion = sc.next();
			while (!opcion.equalsIgnoreCase("n")) {
				System.out.println("Por favor introduzca el nombre: ");
				nombre = sc.next();
				System.out.println("Por favor introduzca la edad: ");
				edad = sc.nextInt();
				bw.write(nombre + " "+ edad);
				bw.newLine();
				System.out.println("Desea introducir datos? S/N");
				opcion = sc.next();
			}
			System.out.println("Ha acabado de introducir datos.");
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			System.out.println("Se ha producido un error al acceder al fichero.");
			e.printStackTrace();
		}
		sc.close();
	}

}
