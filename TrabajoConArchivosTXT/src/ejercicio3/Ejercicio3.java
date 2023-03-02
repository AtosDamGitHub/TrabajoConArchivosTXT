package ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {

    public static void main(String[] args) {

        // Definir el nombre del archivo
        String nombreArchivo = "src\\ficheros\\carta.txt";

        // Inicializar los contadores
        int numCaracteres = 0;
        int numLineas = 0;
        int numPalabras = 0;

        try {
            // Abrir el archivo en modo lectura
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader lector = new BufferedReader(archivo);

            // Leer la primera línea del archivo
            String linea = lector.readLine();

            while (linea != null) {

                // Contar los caracteres de la línea
                numCaracteres += linea.length();

                // Contar las palabras de la línea
                String[] palabras = linea.split(" ");
                numPalabras += palabras.length;

                // Incrementar el contador de líneas
                numLineas++;

                // Leer la siguiente línea del archivo
                linea = lector.readLine();
            }
            // Cerrar el archivo
            lector.close();
            // Imprimir los resultados
            System.out.println("Caracteres: " + numCaracteres);
            System.out.println("Líneas: " + numLineas);
            System.out.println("Palabras: " + numPalabras);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
}
