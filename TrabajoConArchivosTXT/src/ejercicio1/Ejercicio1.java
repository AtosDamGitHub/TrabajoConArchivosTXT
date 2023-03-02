package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Pide al usuario el nombre del fichero 
		System.out.println("Nombre del fichero: ");
		String fichero = teclado.nextLine();
		
		//Guarda la ruta donde se encontraría el fichero, junto con el nombre que ha indicado el usuario y la extensión
		String busqueda ="src\\ficheros\\"+fichero+".txt"; 
		
		/* Lo convierte a un archivo para comprobar si existe.
		 * Si existe se queda con el valor que ha indicado el usuario (ya que puede abrir dicho fichero).
		 * Si no existe, se le da a busqueda por defecto el valor de la ruta para acceder al fichero prueba.txt
		 */
		File archivo = new File(busqueda); 
		if (!archivo.exists()) {
			busqueda = "src\\ficheros\\prueba.txt";
		}
	
		String texto =""; //Guarda los datos que contiene el fichero
	
		try(BufferedReader in = new BufferedReader(new FileReader(busqueda))){//Abre el fichero resultante 
			String linea = in.readLine(); //Lee la primera línea 

			while (linea!=null) { //Mientras no sea el final del fichero
				texto = texto + linea + '\n'; //Guarda el valor de la línea 
				linea = in.readLine(); //Lee la siguiente línea 
			}
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println(texto); //Muestra datos del fichero
	
		teclado.close(); //Cierra el teclado
	}
}
