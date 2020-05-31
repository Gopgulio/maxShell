package entornos.cip.Max;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	Double valor1;
    Double valor2;
    
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @Before
    public void setUpVariables() {
    	valor1 = 10.00;
        valor2 = 5.00;
    }
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    public void sumaSimpleTest() {
    	Suma sum = new Suma(valor1,valor2);
    	verificarResultado(sum, 15.00);
    }
    
    @Test
    public void restaSimpleTest() {
        Resta res = new Resta(valor1, valor2);
        verificarResultado(res, 5.00);
    }
    @Test
    public void dividirSimpleTest() {
        Division div;
		try {
			div = new Division(valor1, valor2);
	        verificarResultado(div, 2.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    @Test
    public void dividirDecimalesTest() {
    	valor1 = 9.00;
        Division div;
		try {
			div = new Division(valor1, valor2);
	        verificarResultado(div, 1.80);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void dividirNegativoTest() {
    	valor1 = -10.00;
        Division div;
		try {
			div = new Division(valor1, valor2);
	        verificarResultado(div, -2.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void dividirPorCeroTest() {
        valor2 = 0.0;
        @SuppressWarnings("unused")
		Division div;
        try {
        	div = new Division(valor1, valor2);
        }catch (Exception e) {
            Assert.assertTrue("El mensaje no es el esperado", e.getMessage().contains("No se puede dividir entre cero") );
        }
    }
    
    @Test
    public void multiplicarSimpleTest() {
        Multiplicacion mult = new Multiplicacion (valor1, valor2);
        verificarResultado(mult, 50.00);
    }
    @Test
    public void multiplicarDecimalesTest() {
    	valor1 = 10.50;
        Multiplicacion mult = new Multiplicacion (valor1, valor2);
        verificarResultado(mult, 52.50);
    }
    @Test
    public void multiplicarNegativoTest() {
    	valor1 = -10.00;
        Multiplicacion mult = new Multiplicacion (valor1, valor2);
        verificarResultado(mult, -50.00);
    }
    @Test
    public void multiplicarPorCeroTest() {
    	valor1 = 0.00;
        Multiplicacion mult = new Multiplicacion (valor1, valor2);
        verificarResultado(mult, 0.00);
    }
    @Test
    public void mostrarResultadoTest() {
    	Suma sum = new Suma(valor1,valor2);
    	sum.mostrarResultado();
    	Assert.assertEquals("10.0 + 5.0 = 15.0\r\n" + 
    			"", output.toString());
    }
    
    private void verificarResultado(Operacion oper, Double esperado) {
        Assert.assertNotNull("Resultado es null", oper.res);
        Assert.assertTrue("Incorrecto", oper.res.equals(esperado));
    }


}
