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
import java.util.List;
import java.util.Arrays;

public class Predicados {
    

   private final static String[] PredicadosReservadosLisp = {"ATOM","LIST","EQUAL",">","<"};

   public ArrayList<String> Verificar(String tipoInstruccion) { 
       tipoInstruccion = tipoInstruccion.toUpperCase();
       
       switch (tipoInstruccion) {
           case "ATOM":
               
               break;
       
               
            case "LIST":
               
               break;
       
            case "EQUAL":
               
               break;
       
            case ">":
               
               break;
       
           
            case "<":
               
               break;
       
            default:
               break;
       }

    
   }

