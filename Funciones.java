
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

    Vista v = new Vista();

    // Propiedades
    private static Hashtable<String, Integer> Parametros; // Hashtable con parametros de función
    private static Hashtable<String, Vector<String>> InstruccionesDeFuncion; // Hashtable con cuerpo de función

    //Metodo Constructor
    public Funciones (Vector<String> FuncionesCod) {}

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
        
        
        String name = TikToks.get(2);
        // Revisar si existe una función con el mismo nombre
        if (Parametros.containsKey(name)) {
            // Si existe, tirar una excepción
            v.Exepsion();
            v.FuncionExistente();

        } else {
            // No existe función entonces crea una nueva
            
            // Se declaran varibales 
            int VariableInicial = 3; int VariableFinal = 0; int i = 0;

            Vector<String> vEctor = new Vector<>();
            
            // Para conocer cuantos valores tiene la función
            for (i = VariableInicial; i < TikToks.size(); i++) {
                if (TikToks.get(i).equals(")")) {
                    VariableFinal = i;
                    break;
                }
            }
    
            //Se obtiene el numero de parametros
            Integer parametrosUtilizados = VariableFinal - VariableInicial - 1;
    
            //Se obtienen las instrucciones de funciones
            for (i = VariableFinal + 1; i < TikToks.size() - 1; i++) {
                vEctor.add(TikToks.get(i));
            }
    
            // Agregar nueva función a hashtables
            Parametros.put(name, parametrosUtilizados); InstruccionesDeFuncion.put(name, vEctor);
        }

        return name;
    }


    
}