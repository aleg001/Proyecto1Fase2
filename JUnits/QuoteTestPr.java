import java.util.Vector;
import junit.framework.TestCase;

public class QuoteTestPr extends TestCase {
	
	Quote frase;
		
	public void test() {
		frase = new Quote();
		Vector<String> vectorExample = new Vector<String>();
		vectorExample.add("(");
		vectorExample.add("QUOTE");
		vectorExample.add("HOLA");
		vectorExample.add(")");
		String output = frase.toPrint(vectorExample);
		assertEquals("HOLA ", output);
	}

}
