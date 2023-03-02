package ejercicio10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio10 {

	public static void main(String[] args) {

		int fila, columna;
		int[][] matriz, traspuesta;

		try (BufferedReader in = new BufferedReader(new FileReader("src\\ficheros\\matriz.txt"))) {
			String linea = in.readLine(); // Lee una línea completa de un archivo
			String datos[] = linea.split(" "); // Cuando en la variable línea se encuentre un espacio en blanco, se
							  // guarda un dato en el array "dato"
			fila = Integer.parseInt(datos[0]); // El primer elemento que se encuentre hasta un espacio en blanco se
												// guardará en la variable fila
			columna = Integer.parseInt(datos[1]);

			// Crea la matriz y la matriz traspuesta
			matriz = new int[fila][columna];
			traspuesta = new int[columna][fila];

			// Lee el resto de líneas para obtener la matriz
			for (int i = 0; i < fila; i++) {
				linea = in.readLine();
				datos = linea.split(" ");

				for (int j = 0; j < columna; j++) {
					matriz[i][j] = Integer.parseInt(datos[j]);
				}
			}

			// Trasponemos la matriz
			for (int i = 0; i < fila; i++) {
				for (int j = 0; j < columna; j++) {
					traspuesta[i][j] = matriz[j][i];
				}
			}

			// Imprime la matriz traspuesta
			for (int i = 0; i < columna; i++) {
				for (int j = 0; j < fila; j++) {
					System.out.print(traspuesta[i][j] + "");
				}
				System.out.println();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
