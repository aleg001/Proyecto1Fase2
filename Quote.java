

/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/
/**
 * Calculadora.java Interface
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/

import java.util.Vector;

public class Quote {

    // Propiedades
    Vector<String> QuoteCode; // Vector en donde se almacena todo el código referente.

    /**
     * En el constructor se debe recibir un ArrayList con todos los valores que
     * después de un ( cuentan con la palabra reservada "quote", hasta el paréntesis
     * cerrado. También  deben agregarse todos los valores que van después de un '.
     */
    public Quote (Vector<String> QuoteVector) {

        QuoteCode = QuoteVector;

    }

    /**
     * Método que retorna un String con valores seguidos de un quote o '
     * @return quote por imprimir
     */
    public String toPrint ( ) {

        String msj = "";

        // Recorrer Vector menos primer parentesis ni "quote"
        for ( int i = 2; i < QuoteCode.size()-1; i++ ) {
                // Concatenar msj con el resto de valores en ArrayList
                msj += QuoteCode.get(i);
                msj += (" ");
        }

        return msj;
    }
}