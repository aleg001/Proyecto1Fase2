/***************************************************************
* Controlador.java
* Autor: Marco, Paola, ALejandro
* Universidad del Valle de Guatemala
*
* Fecha creacion: 03/04/21
* Ultima modificacion: 06/04/21
***************************************************************/

import java.util.Hashtable;
import java.util.Vector;


public class Controlador {

    // Se declaran instancias de clases
    Quote quote = new Quote();
    Variable var = new Variable();
    Tokenize tok = new Tokenize();
    Funciones fun = new Funciones();
    Predicados pre = new Predicados();
    Condiciones cond = new Condiciones();
    Calculadora calcu = new Calculadora();

 

    Hashtable<String, String> Vars = var.getVariables(); // Vector con variables

    public Controlador() {}

    /**
     * Controlador.java 
     * Clase encargada de realizar los procesos del interprete Lisp.
     * @author Jose Hernández
     * @author Ana Molina
     * @author Antonio Jurado
     * @return output en string
     * @throws Exception
     * 
     */
    public String controlar( Vector<String> tokens ) throws Exception {
        
        // Atributos
        String output = "";
        boolean apagar = false;
        Vista v = new Vista();
        
        // Toma el primer valor del vector la cual es la palabra clave que indica qué realizar y llama al método.
        switch ( tokens.get(1) ) {

            // Caso de salida
            case "QUIT":
                output = "SALIR";
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
            
            // Cond
            case "COND":
                
                output = cond.Cond(tokens, Vars, calcu);
                break;

            // SetQ
            case "SETQ":
            
                output = var.setQ(tokens, calcu);
                break;

            case "DEFVAR":
                
                output = var.defVar(tokens, calcu);
                break;

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

            case ">":

                output = pre.Predica(tokens, Vars, calcu);
                break;

                case "<":

                output = pre.Predica(tokens, Vars, calcu);
                break;
            case "PRINT":
                output = v.printLISP(tokens, Vars);
                break;                    
                
            default:
                // Esta tirando error porque necesita que le entre como argumento el controlador :o
                output = fun.existingFun(tokens, calcu, Vars); 
                break;
                
            }
        tokens.clear();
        // Imprimir output.
        return output; 
    }

}

