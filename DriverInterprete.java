
/***************************************************************
* DriverInterprete.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 2/04/21
* Ultima modificacion: 4/04/21
***************************************************************/

/**
 * DriverInterprete.java
 * Main del programa.
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/

import java.util.*;


public class DriverInterprete {
    public static void main(String[] args) throws Exception {
        
        //Instancias de clases
        Vista v = new Vista();
        Controlador control = new Controlador();

        
        Tokenize tok = new Tokenize();  
        
        
        Vector<String> tokens = new Vector<String>();
        
        // Atributos
        String output = "";
        boolean apagar = false;
        
        
        // Se muestra mensajes de inicio de programa.
        v.MetodosInicioPrograma();

        // Mensaje de bienvenida
        v.MensajeTexto();
        
        while (apagar == false) {
            // Primero se tiene que leer la linea con la clase y asignar lo que devuelve a vector tokens.
            tokens = tok.ProcesosCorrespondientesATokenizar();
            output = control.controlar(tokens);
            tokens.clear();
            if (output.equals("SALIR")){
                apagar = true;
            }else{
                v.ImpresionXD(output);
            }
        }
    }
    
}
