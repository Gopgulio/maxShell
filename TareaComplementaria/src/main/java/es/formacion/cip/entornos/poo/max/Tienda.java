/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.formacion.cip.entornos.poo.max;

/**
 * Clase con metodos que trabajan con el objeto Articulo y tiene estructura de una
 * tienda, con toda logica apropiada
 * 
 * @author Maxim
 */
public class Tienda {

	private static final int MAX_ARTICULOS = 1000;
	protected Articulo[] articulos;
	protected int[] cantidades;
	protected int numArticulos;

	/**
	 * Metodo par instanciar la tienda, que propone numero maxim de los articulos
	 */
	public Tienda() {
		articulos = new Articulo[MAX_ARTICULOS];
		cantidades = new int[MAX_ARTICULOS];
	}

	/**
	 * Metodo que imprime toString de cada objeto en el array articulos en la
	 * consola
	 */
	public void mostrarInventario() {
		for (int n = 0; n < numArticulos; ++n) {
			String art = articulos[n].toString();
			System.out.println(art + "Cantidad: " + cantidades[n]);
		}

	}

	/**
	 * Metodo que llena el array articulos con objetos articulo y sus valores
	 */
	public void llenarAlmacen() {
		articulos[0] = new Articulo(0, "Cero", 10.0);
		cantidades[0] = 12;
		articulos[1] = new Articulo(1, "Uno", 20.0);
		cantidades[1] = 9;
		articulos[2] = new Articulo(2, "Dos", 15.0);
		cantidades[2] = 10;
		articulos[3] = new Articulo(3, "Tres", 180.0);
		cantidades[3] = 15;
		articulos[4] = new Articulo(4, "Cuatro", 105.0);
		cantidades[4] = 4;
		articulos[5] = new Articulo(5, "Cinco", 99.0);
		cantidades[5] = 1;
		numArticulos = 6;
	}

}
