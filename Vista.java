/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/

/**
 * Metodos de Vista
 * @author Alejandro Gomez
 * */

import java.util.Scanner;


public class Vista {
    Scanner scan;

    /**
     * Metodo constructor
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/

    public Vista(){
        scan = new Scanner(System.in);
    }

    /**
     * Metodo de opciones
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/

    public int MenuOp(){
        int op = 2;
        String ops = "";
        boolean validar = true;
        System.out.println("\n1. Usar Interprete de LISP");
        System.out.println("2. Salir\n");
        while(validar == true){
            System.out.println("Ingrese su opcion:  ");
            ops = scan.next();
            op = validarNum(ops);
            if(op != -1){
                validar = false;
            } else {}
        } return op;
        
    }



    public String Archivo(){
        return scan.next();
    }

    /**
     * Metodo de Bienvenida
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/
    public void Welcome(){
        System.out.println("\nBienvenido al Interprete de LISP");
    }


    /**
     * Error
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/

    public void Error(){
        System.out.println("ERROR: ");
        System.out.println("Ingreso erroneo, intente de nuevo.");
    }

    /**
     * FileInput
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/
    public void FileInput(){
        System.out.println("Ingrese el nombre del archivo que desea leer");
        System.out.println("Tip: No escriba la extension .txt");
    }

    /**
     * FileOption
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/

    public void FileOption(){
        System.out.println("Que desea hacer?");
        System.out.println("1. Abrir otro archivo");
        System.out.println("2. Salir\n");
        System.out.println("Ingrese su opcion:  ");
    }

  

    public int validarNum (String rawNumero) {
        int numInt = -1;
        try {
            numInt = Integer.parseInt(rawNumero);
        }
        catch (NumberFormatException e)
        {
           System.out.println( "\nIngrese un numero valido porfa." );
        }
        
        return numInt;
      }

      
    public void MensajeSalida(){
        System.out.println("Gracias por usar el interprete de Lisp");
        System.out.println("Feliz Dia");
        System.out.println("Autores:");
        System.out.println("Paola de Leon");
        System.out.println("Marco Jurado");
        System.out.println("Alejandro Gomez");
        
    }

    public void LectorArchivo(String name){
        System.out.println("Leyendo el archivo... "+name+".txt");
    }

}
