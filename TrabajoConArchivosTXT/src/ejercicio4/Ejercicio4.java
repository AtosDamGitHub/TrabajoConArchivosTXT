package ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		try (BufferedReader in = new BufferedReader(new FileReader("src\\ficheros\\numeros.txt"))) {
			Scanner s; // Se crea la variable de tipo scanner
			String linea = in.readLine(); // Se crea la variable donde vamos a guardar lo que se lee por línea con
											// in.readLine
			int menor = 0; // Creamos la variable menor donde guardaremos el número menor
			List<Integer> numeros = new ArrayList<>(); // Creamos un Arraylist donde iremos guardando los diferentes
														// números que encontremos en el archivo
			while (linea != null) {// mientas que linea sea diferente a null se realiza el bucle
				s = new Scanner(linea);// Se crea un objeto scanner que lee el contenido de linea y se asigna a la
										// variable s.
				if (s.hasNextInt()) {// comprobamos que halla numeros enteros
					numeros.add(s.nextInt());// Lo añadirmos a la lista de números
				}
				linea = in.readLine();// volvemos a leer la siguiente linea de el archivo.
			}
			menor = Collections.min(numeros);//Guardamos en la variable menor el numero mas chico de el ArrayList.
			System.out.println(menor);//Lo mostramos por pantalla.
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
