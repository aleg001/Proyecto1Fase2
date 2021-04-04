/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/

import java.util.Hashtable;

/**
 * Calculadora.java Interface
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/


public class Variable {

    // Propiedades
    private Hashtable<String, String> Variables;

    // Constructor
    public Variable ( ) {
        Variables = new Hashtable<>();
    }

    // Getter
    public Hashtable<String, String> getVariables ( ) { return Variables; }

    // Setter
    public void setVariables( Hashtable<String, String> variables ) { Variables = variables; }

}
