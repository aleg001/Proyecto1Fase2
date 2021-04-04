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

    /**
     * MensajeSalida
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/

    public void MensajeSalida(){
        System.out.println("Gracias por usar el interprete de Lisp");
        System.out.println("Autores:");
        System.out.println("Paola de Leon");
        System.out.println("Marco Jurado");
        System.out.println("Alejandro Gomez");
        
    }
    
    /**
     * LectorArchivo
     * @param String name
     * @author Alejandro Gomez
     * @return n/a
     **/

    public void LectorArchivo(String name){
        System.out.println("Leyendo el archivo... "+name+".txt");
    }
    
    /**
     * Error
     * @param n/a
     * @author Alejandro Gomez
     * @return n/a
     **/

    public void Simbolo1(){
        System.out.println(">> ");
    }

    public void Cuidaoo(){
        System.out.println("Cuidado... :o");
    }

    /**
     * RevisaParentesis
     * @param String s
     * @author Jose Gomez
     * @author Ana Molina
     * @return n/a
     **/
    public void RevisaParentesis(String textoString) throws Exception {
        
        /*
        Este metodo se encarga de revisar que los
        parentesis coincidan para que el programa
        corra de forma normal jeje. Recibe el String para revisar los parentesis,
        en caso no coincida el numero de parentesis abiertos con cerrados
        tira excepcion
        */


        int parentesisAbierto = 0;
        int parentesisCerrado = 0;

        for(int i = 0; i < textoString.length(); i++) 
        {
            if(textoString.charAt(i) == '(')
            parentesisAbierto++;

            else if(textoString.charAt(i) == ')')
            parentesisCerrado++;
        }

        if(parentesisAbierto != parentesisCerrado)
            System.out.println("Cuidado... Los parentesis no coinciden :o");
    }

}
