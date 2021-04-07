/***************************************************************
* Quote.java
* Autor: Alejandro, Marco, Paola
* Universidad del Valle de Guatemala
*
* Fecha creacion: 27/03/21
* Ultima modificacion: 06/04/21
***************************************************************/
/**
 * Quote.java 
 * Clase para realizar proceso de imprimir, dentro del interprete.
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/

// Se definen imports
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