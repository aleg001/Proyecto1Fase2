
/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/

/**
 * Clase para crear funciones
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/

import java.util.Hashtable;
import java.util.Vector;



public class Funciones {

    // Propiedades
    private static Hashtable<String, Integer> Parametros; // Hashtable con parametros de función
    private static Hashtable<String, Vector<String>> InstruccionesDeFuncion; // Hashtable con cuerpo de función

    // Getters
    public static Hashtable<String, Vector<String>> getBody() { return InstruccionesDeFuncion; }
    public static Hashtable<String, Integer> getParametros() { return Parametros; }

    // Setters
    public static void setBody(Hashtable<String, Vector<String>> body) { InstruccionesDeFuncion = body; }
    public static void setParametros(Hashtable<String, Integer> parametros) { Parametros = parametros; }



    /**
     * Método para declarar una nueva función.
     * @throws Excepción cuando la función ya existe en la base de datos.
     */
    
    public String defun(Vector<String> TikToks) {
        
        String name = "";
        Vista v = new Vista();
        
        // Revisar si existe una función con el mismo nombre
        if (Parametros.containsKey(name)) {
            // Si existe, tirar una excepción
            v.Exepsion();
            v.FuncionExistente();

        } else {
            // Asignar valor a variable de retorno.
            name = TikToks.get(2);

            // No existe función entonces crea una nueva
            // Se declaran varibales 

            Vector<String> vEctor = new Vector<>();
            int VariableInicial = 3;
            int VariableFinal = 0;
            int i = 0;
            
            // Conocer cuantos parametros tiene la función
            for (i = VariableInicial; i < TikToks.size(); i++) {
                if (TikToks.get(i).equals(")")) {
                    VariableFinal = i;
                    break;
                }
            }
    
            // Se obtiene el numero de parametros totales
            int parametrosUtilizados = VariableFinal - VariableInicial - 1;
    
            // Se agregan al vector nuevo las instrucciones de funciones
            for (i = VariableFinal + 1; i < TikToks.size() - 1; i++) {
                vEctor.add(TikToks.get(i));
            }
    
            // Agregar nueva función a hashtables
            Parametros.put(name, parametrosUtilizados);
            InstruccionesDeFuncion.put(name, vEctor);

        }

        return name;
    }


    
}