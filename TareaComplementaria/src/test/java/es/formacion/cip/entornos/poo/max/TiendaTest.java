
package es.formacion.cip.entornos.poo.max;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de los tests unitarios
 * @author Maxim
 *
 */
public class TiendaTest {
	Tienda t;

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	/**
	 * Cree una tienda t antes de empezar los tests
	 */
	@Before
	public void setUpTienda() {
		t = new Tienda();
	}
	
/**
 * Metodo para obtener un stream de la consola
 */
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(output));
	}
/**
 * Metodo para restorar out de la consola al original
 */
	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}
	/**
	 * Test para comparar funcionalidad de llenarAlmacen, comparando primer elemento del array con lo que necesitamos
	 */
	@Test
	public void llenarAlmacenTest() {
		Tienda expected = new Tienda();
		t.llenarAlmacen();
		llenar(expected);				
		Assert.assertEquals("No es resultado esperado.",expected.articulos[0].toString(), t.articulos[0].toString());
		Assert.assertEquals("No es resultado esperado.",expected.cantidades[0], t.cantidades[0]);
	}
/**
 * Test que compruba salida de la consola, con el mensaje que necesitamos, en este caso, listamos todo el array
 */
	@Test
	public void mostrarInventarioTest() {
		t.llenarAlmacen();
		t.mostrarInventario();
		Assert.assertEquals("ID: 0 Nombre: Cero Precio: 10.0Cantidad: 12\r\n" + 
				"ID: 1 Nombre: Uno Precio: 20.0Cantidad: 9\r\n" + 
				"ID: 2 Nombre: Dos Precio: 15.0Cantidad: 10\r\n" + 
				"ID: 3 Nombre: Tres Precio: 180.0Cantidad: 15\r\n" + 
				"ID: 4 Nombre: Cuatro Precio: 105.0Cantidad: 4\r\n" + 
				"ID: 5 Nombre: Cinco Precio: 99.0Cantidad: 1\r\n" + 
				"",output.toString());

	}
	
	/**
	 * Test para comprobar la funcionalidad del menu con un input por sistema en vez del input manual, aunque solo comprueba
	 * la opcion salir, porque otras tenemos comprobados por otro tests en sus clases respectivamente
	 */
	@Test
	public void mainMenuTest() {	
		InputStream sysInBackup = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
		System.setIn(in);
		
		try {
			Main.menu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals("Input diferente","Una tienda\n" + 
				" Escribe el numero correspondiente para elegir su opcion: \r\n" + 
				"1. Llenar almacen.\r\n" + 
				"2. Mostrar inventario.\r\n" + 
				"3. Salir.\r\n" + 
				"",output.toString());
		System.setIn(sysInBackup);
	}
	
	/**
	 * Metodo simple para logica interna, cuando comparamos tiendas en el metodo llenarAlmacen
	 * @param expected
	 */
	private void llenar(Tienda expected) {
		expected.articulos[0] = new Articulo(0, "Cero", 10.0);
		expected.cantidades[0] = 12;
	}

}
