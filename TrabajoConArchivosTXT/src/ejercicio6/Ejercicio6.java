package ejercicio6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* 6. En Linux disponemos del comando more, al que se le pasa un fichero y lo muestra poco a poco:
 *  cada 24 líneas. Implementar un programa que funcione de forma similar.
 */

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int contador = 0; //Contador de líneas 
		final int VALOR_PARAR = 24; // Valor que indica cada cuantas líneas tiene que parar
			
		try(BufferedReader in = new BufferedReader(new FileReader("src\\ficheros\\ejercicio6.txt"))){//Abre el fichero
			String linea = in.readLine(); //Lee la primera línea 
			
			while(linea!= null) { //Mientras no sea el final del fichero 
				System.out.println(linea); //Impime la línea 
				contador++; //Incrementa el valor del contador
				
				/* Si el contador es igual a VALOR_PARAR tiene que hacer una pausa.
				 * Pide al usuario que pulse intro, para continuar escribiendo líneas
				 * y el contador se inicializa a 0, para que se repita el bucle.
				 */
				if(contador == VALOR_PARAR) { 
					System.out.println(); 
					System.out.println("Pulse intro para continuar..");
					teclado.nextLine(); 
					System.out.println();
					contador=0;
				}
				
				linea = in.readLine(); //Vuelve a leer la línea 
			}
			teclado.close(); //Cierra el teclado
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
