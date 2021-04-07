import junit.framework.TestCase;

public class CalculadoraTest extends TestCase {

	private Calculadora calcu ;
	
	public void escenario() {
		calcu = new Calculadora();
	}
	
	public void testdivision() {
		escenario();
        assertTrue(calcu.division(10,2)==5);
    }
	

	public void testmultiplicacion() {
		escenario();

		assertEquals(20, calcu.multiplicacion(10, 2));
	}
	
	
	public void testresta() {
		escenario();
        assertEquals(21, calcu.resta(28, 7));
    }
	
}
