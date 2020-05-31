/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.formacion.cip.entornos.poo.max;

/**
 * Clase de objetos, con metodos necesarios
 * 
 * @author Maxim
 */
public class Articulo {

	protected int id;
	protected String nombre;
	protected double precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Constructor del objeto Articulo
	 * 
	 * @param id
	 * @param nombre
	 * @param precio
	 */
	public Articulo(int id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * el toString del Articulo que devuelve String con valores de id, nombre y
	 * precio.
	 */
	public String toString() {
		return "ID: " + id + " Nombre: " + nombre + " Precio: " + precio;
	}

}
