

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

    /**
     * Método que retorna un String con valores seguidos de un quote o '
     * @param QuoteCode Vector con infomación de linea.
     * @return quote por imprimir
     */
    public String toPrint ( Vector<String> QuoteCode ) {

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