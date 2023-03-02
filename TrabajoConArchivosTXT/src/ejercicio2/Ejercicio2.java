package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		/* Abre el fichero para escritura, si no existe lo crea*/
		try(BufferedWriter out = new BufferedWriter(new FileWriter("src\\ficheros\\datos.txt"))){
			//Pide al usuario el nombre y la edad 
			System.out.println("Introduce tu nombre: ");
			String nombre = teclado.nextLine();
			System.out.println("Introduce tu edad: ");
			int edad = teclado.nextInt();
		
			out.write(nombre + " "+ edad); //Escribe una cadena en el fichero con el nombre y la edad 
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
			
		}catch(InputMismatchException e) {
			System.out.println("Formato no valido");
		}
		
		teclado.close(); //Cierra el teclado
	}
}
