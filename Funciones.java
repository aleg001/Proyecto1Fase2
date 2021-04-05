
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
import java.util.ResourceBundle.Control;



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
     */
    
    public String defun(Vector<String> TikToks) {
        
        String name = " ";
        Vista v = new Vista();

        // Revisar si existe una función con el mismo nombre
        if (Parametros.containsKey(name)) {
            // Si existe, tirar una excepción
            v.Exepsion();
            v.FuncionExistente();

        } else {
            System.out.println(" ----------> Entre al else del defun");
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
                System.out.println("----------->  El elemento evaluado es:   ..." + TikToks.get(i)+ "...");
                if (TikToks.get(i).equals(")")) {
                    System.out.println("----------->  AHUEVO");
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

            for(int j = 0; j < vEctor.size() - 1; j++){
                System.out.println(vEctor.get(j));
            }
            

        }

        return name;
    }

    /**
     * Método default
     * @param line
     * @param calcu
     * @param Variables
     * @return
     * @throws Exception
     */
    public String existingFun(Vector<String> line, Calculadora calcu, Hashtable<String, String> Variables, Controlador c)throws Exception {
        
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
                try {
                    // Sustituir variables en parámetros y ejecutar función.
                    cuerpoTemp = new Vector<>(cuerpoFuncion);
                    for (i = 0; i < cuerpoFuncion.size()-1; i++) {

                        System.out.println("empecé el FORRRRR  " + i);
                        
                        // Remplaza el valor de variables en vector
                        if (!cuerpoTemp.get(i).matches("[0-9(+-/*)]+")) {
                            cuerpoTemp.set(i, param.get(in));
                            in++;

                            System.out.println("                      SWITCH                    ");
                        }

                        // int resultI = calcu.decode(cuerpoTemp, Variables);
                        // result = Integer.toString(resultI);
                        
                        // for todos los elementos del vector llamar al controlador y que evalue.
                        c.controlar(cuerpoTemp);

                        System.out.println("TERMINEEEEEEEEEEEEEEE el FORRRRR  " + i);
                    }
                    
                } catch (Exception e) {
                    v.Error();
                }
                
            }
        }

        return result;
    }
}