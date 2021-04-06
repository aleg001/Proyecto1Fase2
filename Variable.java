/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/

import java.util.Hashtable;
import java.util.Vector;

/**
 * Variable.java 
 * Clase para manejo de variables.
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


    /**
     * Método para definir una variable nueva.
     * @param line Vector con información de terminal.
     * @param calcu Calculadora para operar.
     * @return Nombre de la variable o error.
     */
    public String defVar(Vector<String> line, Calculadora calcu) {
        String varname = "";
        String value = line.get(3);
        Vista vista = new Vista();
        int i = 0;

        // Verificar si existe una variable con el mismo nombre
        if (Variables.containsKey(varname)) {
            // Error cuando existe una variable con ese nombre.
            vista.VariableExistente();
        } else {
            // Crear un nuevo vector
            Vector<String> v = new Vector<>();
            varname = line.get(2);

            // Verificar que el primer caracter en la pos 3 sea un (, lo que significa que se debe realizar un cálculo.
            if (line.get(3).charAt(0) == '(') {
                // Añadir todos los elementos restantes al nuevo vector.
                for (i = 3; i < line.size() - 1; i++) {
                    v.add(line.get(i));
                }

                // Realizar operaciones y convertir a String.
                int decode = calcu.decode(v, Variables);
                String decodedS = Integer.toString(decode);

                // Asignar variable al Hashtable general de variables.
                Variables.put(varname, decodedS);
            } else {
                // Agregar sin realizar cálculo.
                v.add("(");
                v.add(value);
                v.add(")");
                Variables.put(varname, setValue(v));
            }
        }

        return varname;
    }


    /**
     * Método para asignar valor a valuable.
     * @param line Linea en terminal.
     * @return newValue Nuevo valor de variable.
     */
    public String setQ (Vector<String> line, Calculadora calcu ) {
        
        int i = 0;
        String varname = line.get(2);
        String value = line.get(3);
        Vista vista = new Vista();
        String newValue = "";

        // Verificar que exista la variable
        if (Variables.containsKey(varname)) {
            
            Vector<String> newV = new Vector<>();
    
            // Verificar que el primer caracter de la pos 3 sea (, esto significa que 
            // se debe realizar una operación para agregar valor
            if (line.get(3).charAt(0) == '(') {
                
                // Añadir al vector el resto de valores.
                for (i = 3; i < line.size() - 1; i++) {
                    newV.add(line.get(i));
                }
                
                // Calcular y convertir a String.
                int calc = calcu.decode(newV, Variables);
                String calcS = Integer.toString(calc);
                // Agregar variable a Hashtable general.
                Variables.put(varname, calcS);
            } else {
                // No se debe realizar ninguna operación. Solo agregar variable.
                newV.add("(");
                newV.add(value);
                newV.add(")");
                Variables.put(varname, setValue(newV));
            }
    
            newValue = Variables.get(varname);
    
        } else {
            // En caso ya exista una variable, se muestra mensaje.
            vista.VariableExistente();
        }

        return newValue;

    }

    /**
     * Método en el que se busca entre las variables y se asigna el nuevo valor.
     * @param line Vector nuevo.
     * @return Nuevo valor asignado.
     */
    private String setValue ( Vector<String> line ) {
        
        // Verificar que no sea un núemro.
        if (!line.get(1).matches("[0-9]+")) {
            // Verificar que la variable exista.
            if (Variables.containsKey(line.get(1))) {
                // Asignar valor.
                line.set(1, Variables.get(line.get(1)));
            }
        }

        return line.get(1);
    }
}
