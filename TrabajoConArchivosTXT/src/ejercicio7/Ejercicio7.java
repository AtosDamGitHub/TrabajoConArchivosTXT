package Flujo_Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Actividad_7 {

	public static void main(String[] args) {

		File file1 = new File("perso1.txt");
		File file2 = new File("perso2.txt");
		File file3 = new File("todos.txt");

		// Creamos tres objetos "BufferedReader" para guardar los archivos
		try (BufferedReader arch1 = new BufferedReader(new FileReader(file1));
				BufferedReader arch2 = new BufferedReader(new FileReader(file2));
				BufferedWriter T = new BufferedWriter(new FileWriter(file3))) {

			// Creamos dos variables de tipo cadena que le vamos a estar pasando el
			// contenido de los archivos
			String line1 = arch1.readLine();
			String line2 = arch2.readLine();

			// Creamos un bucle que mientras no se termine el archivo va a estar escribiendo
			// el nuevo archivo con el contenido de los otros 2
			while (line1 != null && line2 != null) {
				if (line1.compareTo(line2) <= 0) { // Si la línea del archivo 1 es menor o igual al archivo 2, este se
													// escribirá en el archivo de salida, en caso contrario será el
													// archivo 2 el que se escriba primero. Esto ordena alfabeticamente.
					T.write(line1 + " \n ");
					line1 = arch1.readLine();
				} else {
					T.write(line2 + " \n");
					line2 = arch2.readLine();
				}
			}

			// Estos dos bucles comprueban si se ha quedado líneas sin leer en ambos
			// archivos
			while (line1 != null) {
				T.write(line1 + "\n");
				line1 = arch1.readLine();
			}

			while (line2 != null) {
				T.write(line2 + "\n");
				line2 = arch2.readLine();
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}