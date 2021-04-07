
/***************************************************************
 * Condiciones.java
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
import java.util.ArrayList;
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
        
        // Propiedades
      int i = 0;
      Vista v = new Vista();
      String resultado = "";
      boolean approved = false; // Boolean que indica si la condición de cumple
      boolean invalido = false;
      String ValoresEnList = "";
      String signo = condiciones.get(3); // equals, > o <
      
      // Verificar si pos 3 es una variable
      if (!condiciones.get(4).matches("[0-9]+")) { 
          // Busca si existe una variable
          if (Variables.containsKey(condiciones.get(4))) {
              // Se asigna el valor de variable al vector.
              condiciones.set(4, Variables.get(condiciones.get(4)));
          }
      }
      // Verificar si pos 4 es una variable
      if (!condiciones.get(5).matches("[0-9]+")) {
         // Busca si existe una variable
          if (Variables.containsKey(condiciones.get(5))) {
             // Se asgina el valor de variable al vector.
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
              if ((condiciones.get(4).toString().equals((condiciones.get(5)).toString()))) {
                  approved = true;
              }
              break;
         
         case "LIST":
     
               // Se crea un nuevo arraylist
               ArrayList<String> ValoresAlmacenados = new ArrayList<String>();

               // Ciclo for para la cantidad de elementos en lista.
               for ( int contador = 3; contador < condiciones.size()-2; contador++) {
                    // Por cada elemento de la lista, se agregan al array.
                    //elementos[contador] = condiciones.get(contador); // No es Variables
                    if ( condiciones.get(contador) != ")" ) {
                        ValoresAlmacenados.add(condiciones.get(contador)); // Se almacena el contenido del list si no es un parentesis
                    }
               }

               if ( ValoresAlmacenados.size() != 0 ) {
                  approved = true;
                  ValoresEnList = ValoresAlmacenados.toString(); // El valor de la lista se convierte en un String.
               }
               
              break;
         
         case "ATOM":
            int alert = 0; // No se usa
            int sign = -1;
            String temp = condiciones.get(3);  
            if (condiciones.size() == 4) {
                //Tiene exactamente la cantidad requerida por el atom
                approved = true;
            } else if(temp == "("){
                //Revisa la posibilidad de que sea una lista vacia 
                for(int l = 3; l < condiciones.size()-1; l++){
                    //Recorre el resto del string encontrando el parentesis que cierra
                    String temporal2 = condiciones.get(l);
                    if(temporal2 == ")"){
                        alert += 1;
                        sign  = l - 3;
                        if(sign == 1){
                           approved = true;
                        } else {
                           approved = false;
                        }
                    }
                }


            } else if(temp == "'" || temp == "LIST") { 
                //Con el signo de lista se busca que sea vacia
                String temporal3 = condiciones.get(5);
               if(temporal3 == ")"){
                  approved = true;
               }else{
                  approved = false;
               }
                
            } else {
               approved = false;
            }
                break;

         default:
            if (approved==false) {
               v.OperadorInvalido();
               invalido = true;
            }
            break;
              
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
