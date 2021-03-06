
/***************************************************************
* Funciones.java
* Autor: Ana, Ale, Maco
* Universidad del Valle de Guatemala
*
* Fecha creacion: 27/03/21
* Ultima modificacion: 06/04/21
***************************************************************/

/**
 * Funciones.java
 * Clase para crear funciones
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/

// Imports utilizados
import java.util.Hashtable;
import java.util.Vector;



public class Funciones {

    // Propiedades

    private static Hashtable<String, Integer> Parametros; // Hashtable con parametros de función
    private static Hashtable<String, Vector<String>> InstruccionesDeFuncion; // Hashtable con cuerpo de función

    public Funciones ( ) {
        Parametros = new Hashtable<>();
        InstruccionesDeFuncion = new Hashtable<>();
    }
    
    // Getters
    public static Hashtable<String, Vector<String>> getBody() { return InstruccionesDeFuncion; }
    public static Hashtable<String, Integer> getParametros() { return Parametros; }

    // Setters
    public static void setBody(Hashtable<String, Vector<String>> body) { InstruccionesDeFuncion = body; }
    public static void setParametros(Hashtable<String, Integer> parametros) { Parametros = parametros; }



    /**
     * Método para declarar una nueva función.
     * @param TikToks Vector que contiene información de la linea.
     * @throws Exception
     */
    
    public String defun(Vector<String> TikToks) throws Exception {
        
        String name = " ";
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
            Integer parametrosUtilizados = VariableFinal - VariableInicial - 1;
    
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

    // FUncion y parametros -----------> (defun factorial (n)   VERIFICADO SI SIRVE
    // CUERPO --------> (cond (eq n 0) (1) (* n (factorial (- n 1))))) 

    /**
     * Método default
     * @param line
     * @param calcu
     * @param Variables
     * @return
     * @throws Exception
     */
    public String existingFun(Vector<String> line, Calculadora calcu, Hashtable<String, String> Variables) throws Exception {

        Vector<String> cuerpoFuncion = new Vector<>();
        Vector<String> param = new Vector<>();
        String secondElement = line.get(1);
        int cantParam = line.size() - 5;
        boolean invalid = false;
        Vector<String> cuerpoTemp;
        Vista v = new Vista();
        String result = "";
        int params = 0;
        int in = 0;
        int i = 0;

        // Si el tamaño es 3 significa que solo debe imprimir el contenido dentro de los paréntesis.
        if (line.size() == 3) {
            return v.printLISP(line, Variables);
        }

        // Verificar si en los parametros hay alguna función con el nombre indicado.
        if (!Parametros.containsKey(secondElement)) {
            // Excepción porque no está definida la función
            v.FuncionExistente();
            invalid = true;
        } else {
            // Obtener información de función
            params = Parametros.get(secondElement);
            cuerpoFuncion = InstruccionesDeFuncion.get(secondElement);

            // Añadir valores al vector de los parametros
            for (i = 0; i < cantParam; i++) {
                param.add(line.get(3 + i));
            }
        }

        // Revizar que en el if pasado no hubiera ningún error.
        if (invalid == false) {
            // Revizar cantidad valores pasadas sean iguales a la cantidad de los parámetos de la función.
            if (params != cantParam){
                // Si no es igual entonces no se pasaron todos los parametros y hay un error.
                v.ArgumentosInvalido();
            } else {
                // Sustituir variables en parámetros y ejecutar función.
                cuerpoTemp = new Vector<>(cuerpoFuncion);
                for (i = 0; i < cuerpoFuncion.size(); i++) {
                    if(!cuerpoTemp.get(i).matches("[0-9(+-/*)]+")) {
                        cuerpoTemp.set(i, param.get(in));
                        in++;
                    }
                }
                int resultI = calcu.decode(cuerpoTemp, Variables);
                result = Integer.toString(resultI);
            }
        }

        return result;
    }
}