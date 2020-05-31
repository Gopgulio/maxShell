package es.formacion.cip.entornos.poo.max;

import java.util.Scanner;

/**
 * Clase main, que ademas tiene la logica del menu
 * 
 * @author Maxim
 *
 */
public class Main {
	protected static Scanner sc = new Scanner(System.in);
	protected static Tienda t = new Tienda();

	/**
	 * Main de la clase con un try catch para controlar excepciones
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			menu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo del menu, con un bucle while que utiliza sentencias switch con un int
	 * introducido por usuario
	 * 
	 * @throws Exception
	 */
	protected static void menu() throws Exception {
		boolean salir = false;
		int option = 0;

		while (!salir) {
			System.out.println("Una tienda\n Escribe el numero correspondiente para elegir su opcion: ");
			System.out.println("1. Llenar almacen.");
			System.out.println("2. Mostrar inventario.");
			System.out.println("3. Salir.");
			option = sc.nextInt();

			switch (option) {
			case 1:
				t.llenarAlmacen();
				break;
			case 2:
				System.out.println("La lista de los articulos en la tienda: ");
				t.mostrarInventario();
				break;
			case 3:
				salir = true;
				break;
			default:
				throw new Exception("error");
			}
		}
	}
}
