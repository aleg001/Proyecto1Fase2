
/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 2/04/21
* Ultima modificacion: 4/04/21
***************************************************************/

/**
 * Calculadora.java Interface
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/

import java.util.*;


public class DriverInterprete {
    public static void main(String[] args) throws Exception {
        
        //Instancias de clases
        Vista v = new Vista();
        Quote quote = new Quote();
        Variable var = new Variable();
        Tokenize tok = new Tokenize();
        Funciones fun = new Funciones();
        Predicados pre = new Predicados();
        Condiciones cond = new Condiciones();
        Calculadora calcu = new Calculadora();
        
        
        // Atributos
        String output = "";
        Vector<String> tokens = new Vector<String>();
        Hashtable<String, String> Vars = var.getVariables(); // Vector con variables
        boolean apagar = false;
        
        // Se muestra mensajes de inicio de programa.
        v.MetodosInicioPrograma();

        // Mensake de bienvenida
        v.MensajeTexto();
        
        while (apagar == false) {
            // Primero se tiene que leer la linea con la clase y asignar lo que devuelve a vector tokens.
            tokens = tok.ProcesosCorrespondientesATokenizar();
            // Toma el primer valor del vector la cual es la palabra clave que indica qué realizar y llama al método.
            switch ( tokens.get(1) ) {
    
                case "QUIT":
                    v.MensajeSalida();
                    apagar = true;
                    break;
                
                // Aritmética
                case "+":

                    int resultado = calcu.decode(tokens, Vars);
                    output = Integer.toString(resultado);
                    break;
    
                // Aritmética
                case "-":
                
                    int resultado2 = calcu.decode(tokens, Vars);
                    output = Integer.toString(resultado2);
                    break;
    
                // Aritmética
                case "*":

                    int resultado3 = calcu.decode(tokens, Vars);
                    output = Integer.toString(resultado3);
                    break;
                    
                // Aritmética
                case "/":

                    int resultado4 = calcu.decode(tokens, Vars);
                    output = Integer.toString(resultado4);
                    break;
    
                // Quote
                case "QUOTE":
                  
                    output = quote.toPrint(tokens);
                    break;
                
                // Cambiar por cond
                case "COND":
                    
                    output = cond.Cond(tokens, Vars, calcu);
                    break;

                // Cambiar para que sea setq
                case "SETQ":
                
                    output = var.setQ(tokens, calcu);
                    break;
    
                case "DEFVAR":
                  
                    output = var.defVar(tokens, calcu);
                    break;

                // // print
                // case "PRINT":
                //     output = print(tokens);
                //     break;
                // Funciones y paso de parámetros
                case "DEFUN":

                    output = fun.defun(tokens);
                    break;
    
                case "ATOM":
                     
                    output = pre.Predica(tokens, Vars, calcu);
                    break;
    
                case "LIST":
                    
                    output = pre.Predica(tokens, Vars, calcu);
                    break;
    
                case "EQ":
                   
                    output = pre.Predica(tokens, Vars, calcu);
                    break;
                    
                    
                default:
                    System.out.println(" Default ");
                    break;
                    
                }
                
            // Imprimir output.
            v.ImpresionXD(output); 
            tokens.clear();
        }
    }
    
}
