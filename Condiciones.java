
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

 //Imports utilizados
import java.util.Hashtable;
import java.util.Vector;


public class Condiciones {
    
    /* Clase creada para realizar los proceso 
        de condiciones necesarias.
    */

    /**
     * Método para evaluar una condición.
     * @param condiciones Vector con linea
     * @param Variables Variables generales del programa.
     * @param calcu Para poder operar.
     * @return Resultado como String.
     */
    public String Cond (Vector<String> condiciones, Hashtable<String, String> Variables, Calculadora calcu ) {
        
        // Se declaran variables e instancias
        int i = 0;
        boolean isEq = false;
        Vista v = new Vista();
        String resultado = " ";
        boolean approved = false; // Boolean que indica si la condición de cumple
        String signo = condiciones.get(3); // equals, > o <
        String primerOp = condiciones.get(8); // Primer valor
        String segundoOp = condiciones.get(13); // Segundo valor

        // Ciclo if para verificar si es distinto a 0-9
        if (!condiciones.get(4).matches("[0-9]+")) { 
            // Pos 4 del vector es diferente a un número
            // Busca si existe una variable
            if (Variables.containsKey(condiciones.get(4))) {
                // Se asigna el valor del vector a la variable en esa pos
                condiciones.set(4, Variables.get(condiciones.get(4)));
            }
        }

        if (!condiciones.get(5).matches("[0-9]+")) {
            if (Variables.containsKey(condiciones.get(5))) {
                condiciones.set(5, Variables.get(condiciones.get(5)));
            }
        }

        // Segun valor de signo evaluar.
        switch ( signo ) {

            // Comparar
            case "<":
                if (Integer.parseInt(condiciones.get(4)) < Integer.parseInt(condiciones.get(5))) {
                    approved = true;
                }
                break;
                
            case ">":
                if (Integer.parseInt(condiciones.get(4)) > Integer.parseInt(condiciones.get(5))) {
                    approved = true;
                }
                break;

            case "EQ":
                isEq = true;
                if ((condiciones.get(4).toString().equals((condiciones.get(5)).toString()))) {
                    approved = true;
                }
                break;

            default:
                if (approved==false && isEq == false) {
                    v.OperadorInvalido();
                }
                
        }
        
        // Si se cumple a condición
        if ( approved == true ) {
            Vector<String> ifTrue = new Vector<String>( condiciones );

            // Borra la condición del vector por que si se cumplió
            for (i = 0; i < 7; i++) {
                ifTrue.remove(0);
            }

            // Borra el else
            for (i = 0; i < ifTrue.size(); i++) {
                ifTrue.remove(5);
            }
            
            // Opera
            int result = calcu.decode(ifTrue);
            resultado = Integer.toString(result);

        } else {

            // Cuando no se cumple la condición
            Vector<String> ifFalse = new Vector<String>(condiciones);

            // Borra condición true
            for (i = 0; i < 12; i++) {
                ifFalse.remove(0);
            }

            ifFalse.remove(5);
            
            // Opera
            int result = calcu.decode(ifFalse);
            resultado = Integer.toString(result);
        }

        return resultado;
    }

    

}
