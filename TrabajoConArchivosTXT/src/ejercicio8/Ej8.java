package ejercicio8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ej8 {

public static void main(String[] args) {
		
		String[] alfabeto = null;
		String[] cod = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader("src\\ficheros\\codec.txt"))) {
			
			String l = br.readLine();
			alfabeto = l.split(" ");
			
			l = br.readLine();
			cod = l.split(" ");
			
			//System.out.println(Arrays.deepToString(alfabeto));
			//System.out.println(Arrays.deepToString(cod));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		List<String> letras = Arrays.asList(alfabeto);
		//List<String> letrasCodificadas = Arrays.asList(cod);		
		
		try(BufferedReader br = new BufferedReader(new FileReader("src\\ficheros\\texto.txt"))) {
			
			String verso = br.readLine();
			String texto_final = "";
			
			while(verso != null) {
				for (int i = 0; i < verso.length(); i++) {
					if(letras.contains(String.valueOf(verso.charAt(i)).toLowerCase())) {
						int pos = Collections.binarySearch(letras, String.valueOf(verso.charAt(i)).toLowerCase());
						if(pos < 0) {
							pos = -pos;
						}
						
						// ESTO ES PARA LA LETRA Ñ QUE POR CODIFICACION DA EL VALOR 28 EN EL BINARYSEARCH()
						if(pos == 28)
							pos = 14;
						
						texto_final += cod[pos];
						
					} else {
						texto_final += verso.charAt(i);
					}
				}
				texto_final += "\n";
				verso = br.readLine();
			}
			
			System.out.println(texto_final);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
