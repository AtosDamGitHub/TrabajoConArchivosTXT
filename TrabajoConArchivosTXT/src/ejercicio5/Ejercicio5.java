package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        LibroDeFirmas libro = new LibroDeFirmas();
        try (Scanner Scanner = new Scanner(System.in)) {
			int opcion;
			do {
			    System.out.println("1. Mostrar firmas registradas");
			    System.out.println("2. Agregar nueva firma");
			    System.out.println("0. Salir");
			    System.out.print("Selecciona una opción: ");
			    opcion =Scanner.nextInt();
			    //Scanner.nextLine();
			    switch (opcion) {
			        case 1:
			            libro.mostrarFirmas();
			            break;
			        case 2:
			            libro.agregarFirma();
			            break;
			        case 0:
			            System.out.println("¡Hasta pronto!");
			            break;
			        default:
			            System.out.println("Opción no válida.");
			            break;
			    }
			} while (opcion != 0);
		}
    }
}
