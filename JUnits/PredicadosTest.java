import junit.framework.TestCase;
import java.util.Hashtable;
import java.util.Vector;


public class PredicadosTest extends TestCase {

	private Predicados predicador;
	private Calculadora calcu;
	private Hashtable<String, String> vars;
	
	public void Test() {
		vars = new Hashtable<String, String>();
		predicador = new Predicados();
		calcu = new Calculadora();
	}
	
	// JUnit de caso: mayor que
	public void testMayor ( ) {
		Test();
		Vector<String> vector = new Vector<String>();
		vector.add("(");
		vector.add(">");
		vector.add("1");
		vector.add("0");
		vector.add(")");
		String verdadero = predicador.Predica(vector, vars, calcu);
		assertEquals("T", verdadero);
	}
	
	// JUnit de caso: menor que
	public void testMenor ( ) {
		Test();
		Vector<String> vector = new Vector<String>();
		vector.add("(");
		vector.add("<");
		vector.add("1");
		vector.add("3");
		vector.add(")");
		String verdadero = predicador.Predica(vector, vars, calcu);
		assertEquals("T", verdadero);
	}
	
	// JUnit de caso: equals
	public void testEquals ( ) {
		Test();
		Vector<String> vector = new Vector<String>();
		vector.add("(");
		vector.add("EQ");
		vector.add("5");
		vector.add("5");
		vector.add(")");
		String verdadero = predicador.Predica(vector, vars, calcu);
		assertEquals("T", verdadero);
	}
	
	// JUnit de caso: atom
	public void testAtom ( ) {
		Test();
		Vector<String> vector = new Vector<String>();
		vector.add("(");
		vector.add("ATOM");
		vector.add("5");
		vector.add(")");
		String verdadero = predicador.Predica(vector, vars, calcu);
		assertEquals("T", verdadero);
	}
	
	// JUnit de caso: list
	public void testList ( ) {
		Test();
		Vector<String> vector = new Vector<String>();
		vector.add("(");
		vector.add("LIST");
		vector.add("5");
		vector.add("5");
		vector.add(")");
		String verdadero = predicador.Predica(vector, vars, calcu);
		assertEquals("[5, 5]", verdadero);
	}
	
}
