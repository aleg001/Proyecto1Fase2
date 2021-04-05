
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

import java.util.Hashtable;
import java.util.Vector;
import java.util.ArrayList;


public class Predicados {
    
   
   public String Predica (Vector<String> condiciones, Hashtable<String, String> Variables, Calculadora calcu ) {
      
      // Propiedades
      Vista v = new Vista();
      String resultado = "";
      boolean approved = false; // Boolean que indica si la condición de cumple
      boolean invalido = false;
      String ValoresEnList = "";
      String signo = condiciones.get(2); // equals, > o <

      // Verificar si pos 3 es una variable
      if (!condiciones.get(3).matches("[0-9]+")) { 
          // Busca si existe una variable
          if (Variables.containsKey(condiciones.get(3))) {
              // Se asigna el valor de variable al vector.
              condiciones.set(3, Variables.get(condiciones.get(3)));
          }
      }
      // Verificar si pos 4 es una variable
      if (!condiciones.get(4).matches("[0-9]+")) {
         // Busca si existe una variable
          if (Variables.containsKey(condiciones.get(4))) {
             // Se asgina el valor de variable al vector.
              condiciones.set(4, Variables.get(condiciones.get(4)));
          }
      }

      // Segun valor de signo evaluar.
      switch ( signo ) {
          // Comparar
          case "<":
              if (Integer.parseInt(condiciones.get(3)) < Integer.parseInt(condiciones.get(4))) {
                  approved = true;
              }
              break;
              
          case ">":
              if (Integer.parseInt(condiciones.get(3)) > Integer.parseInt(condiciones.get(4))) {
                  approved = true;
              }
              break;

          case "EQ":
              if ((condiciones.get(3).toString().equals((condiciones.get(4)).toString()))) {
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
              
      }
      
      // Verificar que no exista un error.
      if (invalido == false) {
         // Si se cumple a condición
         if ( approved == true ) {
            // Segun valor de signo evaluar.
            switch ( signo ) {
               // Comparar
               case "<":
               case ">":
               case "EQ":
               case "ATOM":
                  resultado = "T";
                  break;
               
               case "LIST":
                  resultado = ValoresEnList;
                  break;
            }
         } else {
            // Segun valor de signo evaluar.
            switch ( signo ) {
   
               // Comparar
               case "<":
               case ">":
               case "EQ":
               case "ATOM":
                  resultado = "NIL";
                  break;
               
               case "LIST":
                  resultado = "Error. No es una lista. "; 
                  break;
            }
             
         }

      }

      return resultado;
   }

}

