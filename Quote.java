

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

import java.util.ArrayList;

public class Quote {

    // Propiedades
    ArrayList<String> QuoteCode; // ArrayList en donde se almacena todo el código referente.

    /**
     * En el constructor se debe recibir un ArrayList con todos los valores que
     * después de un ( cuentan con la palabra reservada "quote", hasta el paréntesis
     * cerrado. También  deben agregarse todos los valores que van después de un '.
     */
    public Quote (ArrayList<String> QuoteList) {

        QuoteCode = QuoteList;

    }

    /**
     * Método que retorna un String con valores seguidos de un quote o '
     * @return quote por imprimir
     */
    public String toPrint ( ) {

        String msj = "";

        // Recorrer ArrayList
        for ( int i = 0; i < QuoteCode.size()-1; i++ ) {
            String temp = QuoteCode.get(i);
            // Si es un quote o ' concatena todo lo siguiente hasta antes del )
            if ( temp == "quote" || temp == "'" ) {
                // Concatenar msj con el resto de valores en ArrayList
                for ( int j = i; j < QuoteCode.size()-1; j++ ) {
                    String temp2 = QuoteCode.get(j);
                    if ( temp2 != ")" ) {
                        msj += temp2;
                    }
                }
            }
        }

        return msj;
    }
}