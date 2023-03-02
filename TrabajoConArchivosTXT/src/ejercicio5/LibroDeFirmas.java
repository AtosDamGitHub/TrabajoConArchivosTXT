package ejercicio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibroDeFirmas {
    private static List<String> nombres;

    public LibroDeFirmas() {
        nombres = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\firmas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null)
                nombres.add(linea);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }

    public void mostrarFirmas() {
        System.out.println("Nombres registrados:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public void agregarFirma() {
    	System.out.print("Agregar firma: ");
    	String nueva_firma = new Scanner(System.in).nextLine();
    	
    	if(nombres.contains(nueva_firma))
    		System.out.println("Este usuario ya ha firmado con anterioridad");
    	else {
    		
    		nombres.add(nueva_firma);
    		
    		try(BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ficheros\\firmas.txt"))) {
    			
    			for (String n : nombres) {
					bw.write(n);
					bw.newLine();
				}
    			
    		} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
}
