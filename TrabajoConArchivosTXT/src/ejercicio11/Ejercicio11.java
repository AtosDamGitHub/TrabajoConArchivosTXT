package ejercicio11;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio11 {

public static void main(String[] args) {
		
		try (BufferedReader in = new BufferedReader(new FileReader("src\\ficheros\\texto1.txt"));BufferedReader in2 = new BufferedReader(new FileReader("src\\ficheros\\texto2.txt"))){
			String linea1 = in.readLine();
			String linea2 = in2.readLine();
			int contador = 0;
			int linea = 0;
			boolean iguales = true;
			Character[] line1;
			Character[] line2;
			while (((linea1!=null)||(linea2!=null))&&iguales) {
				line1 = new Character[linea1.length()];
				line2 = new Character[linea2.length()];
				contador = 0;
				for (int i = 0; i < linea1.length(); i++) {
					line1[i] = linea1.charAt(i);
				}
				for (int i = 0; i < linea2.length(); i++) {
					line2[i] = linea2.charAt(i);
				}				
				try {
					if (linea1.length()>linea2.length()){
						for (int i = 0; i < line1.length; i++) {
							contador++;
							if(!line1[i].equals(line2[i])) {
								iguales = false;
								break;
							}
						}
					}else {
						for (int i = 0; i < line2.length; i++) {
							contador++;
							if(!line2[i].equals(line1[i])) {
								iguales = false;
								break;
							}
						}
					}
				} catch (Exception e) {
					iguales = false;
				}
				
				linea1 = in.readLine();
				linea2 = in2.readLine();
				linea++;
				
			}
			
			if (iguales) {
				System.out.println("Los dos archivos son iguales.");
			}else {
				System.out.println("Hay una diferencia en la línea "+linea+" en el caracter "+contador);
			}
		} catch (Exception e) {
			System.out.println("Un archivo tiene mas lineas que otro");
		}
		
	}
}
