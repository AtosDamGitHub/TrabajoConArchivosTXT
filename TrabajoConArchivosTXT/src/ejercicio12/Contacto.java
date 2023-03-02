package ejercicio12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ejercicio4.Ejercicio4;

public class Contacto implements Comparable<Contacto> {
	
	String nombre_contacto;
	String telefono;
	static String ruta = "src\\ficheros\\agenda.txt";
	
	public Contacto(String nombre_contacto, Long telefono) throws Exception {
		setNomCont(nombre_contacto);
		setTelefono(telefono);
	}

	//------------------------------------COMPRUEBA SI SE REPITE NOMBRE---------------------------------------
	
	public void setNomCont(String nc) throws Exception {
		
		String[] titular = nc.split(" ");
		String n;
		String nombredef = "";
		
		for (int i = 0; i < titular.length; i++) {
			
			if(!titular[i].isBlank()) {
				n = titular[i].trim();
				String primera_letra = String.valueOf(n.charAt(0));
				n = primera_letra.toUpperCase() + n.substring(1).toLowerCase();
				nombredef += n + " ";
			}
		}
		
		nombredef.trim();
		boolean existe = false;
		Iterator<Contacto> it = Ejercicio12.agenda.iterator();
		while(it.hasNext()) {
			if(it.next().nombre_contacto.equals(nombredef))
				existe = true;
		}
		
		if(!existe)
			this.nombre_contacto = nombredef;
		else
			throw new Exception("EL NOMBRE DE CONTACTO YA EXISTE");
		
	}

	//------------------------------------COMPRUEBA TELEFONO--------------------------------------------------
	
	public void setTelefono(Long telefono) throws Exception {
		
		String telCli = String.valueOf(telefono);
		
		if(telCli.length() == 9) {
			this.telefono = telCli;	
		} else {
			throw new Exception("NUMERO DE TELEFONO NO VALIDO");
		}
	}
	
	//------------------------------------------NUEVO CONTACTO--------------------------------------------------
	
	public static void nuevoContacto() throws Exception {
		
		System.out.print("INGRESE NOMBRE DE CONTACTO: ");
		String nom = new Scanner(System.in).nextLine();
		
		System.out.print("INGRESE TELEFONO DE CONTACTO: ");
		Long tlf = new Scanner(System.in).nextLong();
		
		Contacto nuevo_contacto = new Contacto(nom, tlf);
		
		Ejercicio12.agenda.add(nuevo_contacto);
	}
	
	//------------------------------------------BUSCAR POR NOMBRE--------------------------------------------------
	
	public static void buscarContacto(String cadenaBusqueda) {
		
		int tamCadena = cadenaBusqueda.length();
		String param = cadenaBusqueda.toUpperCase();
		List<Contacto> coincidencias = new ArrayList<>();
		boolean coincide = true;
		
		Iterator<Contacto> it = Ejercicio12.agenda.iterator();
		while(it.hasNext()) {
			Contacto c = it.next();
			
			for (int i = 0; i < tamCadena; i++) {
				
				if(!String.valueOf(c.nombre_contacto.charAt(i)).toUpperCase().equals(String.valueOf(param.charAt(i))))
					coincide = false;
			}
			
			if(coincide)
				coincidencias.add(c);
			
			coincide = true;
		}
		
		if(coincidencias.isEmpty())
			System.out.println("NO SE ENCONTRARON COINCIDENCIAS PARA \"" + cadenaBusqueda.toUpperCase() + "\"");
		else {
			System.out.println("RESULTADOS OBTENIDOS PARA \"" + cadenaBusqueda.toUpperCase() + "\"");
			for (int i = 0; i < coincidencias.size(); i++) {
				System.out.println(coincidencias.get(i).toString());
			}
		}
	}
	
	
	//------------------------------COMPARABLE (para mostrar por orden alfabético)---------------------------------
	
	@Override
	public int compareTo(Contacto c) {
		if(this.nombre_contacto.compareTo(c.nombre_contacto) > 0)
			return 1;
		else if(this.nombre_contacto.compareTo(c.nombre_contacto) < 0)
			return -1;
		else
			return 0;
	}
	
	//--------------------------------------------TOSTRING()--------------------------------------------------------
	
	@Override
	public String toString() {
		String cadena_perfecta = this.nombre_contacto;
		int separacion = 53 -(this.nombre_contacto.length() + this.telefono.length());
		for (int i = 0; i < separacion; i++) {
			cadena_perfecta += " ";
		}
		cadena_perfecta += this.telefono;
		return "\u001b[43;1m\u001b[30m" + cadena_perfecta + "\u001b[0m";
	}
	
	//-------------------------------------------------LISTAR-------------------------------------------------------
	
	public static void mostrarContactos() {
		
		Iterator<Contacto> it = Ejercicio12.agenda.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
		
	//-----------------------------------------------CARGAR DATOS----------------------------------------------------
	
	public static void cargarContactos() {
		
		System.out.println("COMPROBANDO EXISTENCIA DE DATOS ANTERIORES...");
		File paginas_amarillas = new File(ruta);
		if(paginas_amarillas.exists()) {
			
			System.out.println("DATOS ANTERIORES ENCONTRADOS...\nRESTAURANDO DATOS DE LA AGENDA...");
			try(BufferedReader contactos = new BufferedReader(new FileReader(paginas_amarillas))) {
				
				String linea;
				Contacto contacto_guardado = null;
				Object[] atributos;
				
				linea = contactos.readLine();				
				
				while(linea != null) {
					
					atributos = linea.split("\t");
					contacto_guardado = new Contacto((String) atributos[0], Long.valueOf((String) atributos[1]));
					
					Ejercicio12.agenda.add(contacto_guardado);
					
					linea = contactos.readLine();
				}
					
				System.out.println("DATOS RESTAURADOS CORRECTAMENTE\nPROCEDIENDO A ABRIR APLICACION...");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			System.out.println("NO SE ENCONTRARON DATOS PARA RESTAURAR\nPROCEDIENDO A ABRIR APLICACION...");
	}	
	
	//------------------------------------------------GUARDAR DATOS--------------------------------------------------

	public static void grabarContactos() {
		
		File paginas_amarillas = new File(ruta);
		Contacto contacto_a_guardar = null;
		
		System.out.println("GRABANDO CONTACTOS...");
		try(BufferedWriter anotar = new BufferedWriter(new FileWriter(paginas_amarillas))) {
			
			Iterator<Contacto> it = Ejercicio12.agenda.iterator();
			while(it.hasNext()) {
				contacto_a_guardar = it.next();
				
				anotar.write(contacto_a_guardar.nombre_contacto);
				anotar.write("\t");
				anotar.write(contacto_a_guardar.telefono);
				anotar.newLine();
			}
			
			System.out.println("NUEVOS CONTACTOS ANOTADOS CORRECTAMENTE");
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//------------------------------------------------MENÚ--------------------------------------------------
	
	public static void menu() {
		
		cargarContactos();
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		System.out.println("ELIJA ALGUNA DE LAS SIGUIENTES OPCIONES:\n"
				+ "1.- NUEVO CONTACTO\n"
				+ "2.- BUSCAR CONTACTO\n"
				+ "3.- MOSTRAR CONTACTOS\n"
				+ "4.- SALIR");
		opcion = sc.nextInt();
		
		while(opcion != 4) {
			
			switch (opcion) {
			case 1:
				try {
					nuevoContacto();
				} catch (Exception e) {
					System.err.println(e);
				}
				break;
				
			case 2:
				System.out.print("BUSCAR CONTACTOS QUE COMIENCEN POR -> ");
				String parametro_busqueda = sc.next();
				try {
					buscarContacto(parametro_busqueda);
				} catch (Exception e) {
					System.err.println(e);
				}
				break;
				
			case 3:
				System.out.println("\u001b[7m\u001b[1m                  PAGINAS AMARILLAS                  \u001b[0m");
				mostrarContactos();				
				break;
				
			default:
				System.out.println("ACCION NO VALIDA");
				break;
			}
			
			System.out.println("ELIJA ALGUNA DE LAS SIGUIENTES OPCIONES:\n"
					+ "1.- NUEVO CONTACTO\n"
					+ "2.- BUSCAR CONTACTO\n"
					+ "3.- MOSTRAR CONTACTOS\n"
					+ "4.- SALIR");
				opcion = sc.nextInt();
		}
		
		grabarContactos();		
	}
}