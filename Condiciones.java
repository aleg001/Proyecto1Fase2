
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

 // Imports utilizados
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
        boolean invalido = false;
        boolean approved = false; // Boolean que indica si la condición de cumple
        String signo = condiciones.get(3); // equals, > o <

        // Cuando el valor después del signo es una variable se busca entre Hashtable general.
        if (!condiciones.get(4).matches("[0-9]+")) { 
            // Pos 4 del vector es diferente a un número
            // Busca si existe una variable
            if (Variables.containsKey(condiciones.get(4))) {
                // Se asigna el valor del vector a la variable en esa pos
                condiciones.set(4, Variables.get(condiciones.get(4)));
            }
        }

        // Cuando el valor después de primer valor después del signo es una variable se busca entre Hashtable general.
        if (!condiciones.get(5).matches("[0-9]+")) {
            // Pos 5 del vector no es número, por lo que sería una variable.
            if (Variables.containsKey(condiciones.get(5))) {
                condiciones.set(5, Variables.get(condiciones.get(5)));
            }
        }

        // Según valor de signo evaluar.
        switch ( signo ) {

            // Comparar
            case "<":
                // Se efectuan las operaciones correspondientes para menor que
                if (Integer.parseInt(condiciones.get(4)) < Integer.parseInt(condiciones.get(5))) {
                    approved = true;
                }
                break;
                
            case ">":
                // Se efectuan las operaciones correspondientes para el mayor que
                if (Integer.parseInt(condiciones.get(4)) > Integer.parseInt(condiciones.get(5))) {
                    approved = true;
                }
                break;

            case "EQ":
                // Se efectuan las operaciones correspondientes para el caso de equals
                isEq = true;
                if ((condiciones.get(4).toString().equals((condiciones.get(5)).toString()))) {
                    approved = true;
                }
                break;

            default:
                // Se efectuan las operaciones correspondientes para caso general.
                if (approved==false && isEq == false) {
                    v.OperadorInvalido();
                    invalido = true;
                }
                
        }
        
        // Verificar que no existe ningún error.
        if ( invalido == false ) {
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
                int result = calcu.decode(ifTrue, Variables);
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
                int result = calcu.decode(ifFalse, Variables);
                resultado = Integer.toString(result);
            }
        }
        // Devuelve el resultado
        return resultado;
    }

}
