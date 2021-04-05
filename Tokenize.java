/***************************************************************
* Tokenize.java
* Autor: Ale Gomez
* Autor: Pao Molina
* Autor: Antonio Jurado
* Universidad del Valle de Guatemala
*
* Fecha creacion: 04/03/21
* Ultima modificacion: 04/03/21
***************************************************************/


//Los imports a utilizar en esta clase
import java.util.Vector;
import java.util.Scanner;


public class Tokenize {

    // Se crea un vector con el generico para que el desarrollador decida que hacer con el.
    Vista v = new Vista();
    Scanner elEscannerXDXD = new Scanner(System.in);

    private Vector<String> BitCoins = new Vector<String>();

    /**
     * RevisaParentesis
     * @param String s
     * @return n/a
     **/

    public void RevisaParentesis(String textoString) {
        
        /*
        Este metodo se encarga de revisar que los
        parentesis coincidan para que el programa
        corra de forma correcta. Recibe el String para revisar los parentesis,
        en caso no coincida el numero de parentesis abiertos con cerrados
        tira un mensaje de error.
        */

        // Se declaran variables
        int parentesisAbierto = 0; int parentesisCerrado = 0;

        // Ciclo for para verificar numero de parentesis
        for (int ContadorGeneral = 0; ContadorGeneral < textoString.length(); ContadorGeneral++) {
            // Verifica si es parentesis que abre o cierra, para
            // Sumarlo al contador respectivo.

            if (textoString.charAt(ContadorGeneral) == '(' ) {
                //Agrega al contador el numero de parentesis abiertos.
                parentesisAbierto++;
            } else if (textoString.charAt(ContadorGeneral) == ')') {
                //Agrega al contador el numero de parentesis cerrados.
                parentesisCerrado++;
            }
        }

        //Verifica si los parentesis no coinciden. 
        if (parentesisAbierto != parentesisCerrado) {
            //Se muestra mensaje de error.
            System.out.println("Cuidado... Los parentesis no coinciden :o");
        }
    }


    
    /**
     * ProcesosCorrespondientesATokenizar
     * @param String s
     * @return n/a
     **/

    public Vector<String> ProcesosCorrespondientesATokenizar() {
        
        /*  Este metodo se encarga de realizar los procesos
            necesarios para poder tokenizar.*/

        // Se define el String que ingresa usuario
        String elStringUtilizadoEnElPrograma = ""; 
        System.out.print(">> ");
            
        elStringUtilizadoEnElPrograma = elEscannerXDXD.nextLine().trim().toUpperCase();
        System.out.println(elStringUtilizadoEnElPrograma);

        // TryCatch que utiliza metodo recursivo para revisar parentesis 
        try { 
            // Tokeniza y evalua lo intresado, lo agrega a bitcoins
            
            RevisaParentesis(elStringUtilizadoEnElPrograma);
            BitCoins = procesosDeTokenizacion(elStringUtilizadoEnElPrograma);
        }   

        catch (Exception e) {
            // Tira excepcion si no cumple con lo q se desea 
            v.Error();
        }

        System.out.print(">> ");

        return BitCoins;

    }



    /**
     * procesosDeTokenizacion
     * @param String ingreso del usuario
     * @return Vector<String> 
     **/

    private Vector<String> procesosDeTokenizacion(String StringATokenizar) {
            
            /* Se define un metodo encargado de realizar
                los procesos necesarios para tokenizar 
                los Strings analizados por usuario. */


        //Se declara variable
        int i = 0;

        //Ciclo if con la longitud analizada.
        if (StringATokenizar.length() == 1 ) {
            //Agrega a BitCoin *Vector de String* los datos del String, en caso sea 1.
            BitCoins.add(StringATokenizar);
            return BitCoins; //Devuelve BitCoin
        }

        //Hace ciclo while para ver la longitud del string ingresado
        //y lo matchea con las variables definidas.
        while ( i < StringATokenizar.length() ) {
            //Se define el contador.
            int ContadorUtilizado = i + 1;

            //Se definen las condiciones a cumplir, segun sea por letras, numeros, simbolos o espacios.
            if ( StringATokenizar.substring(i, ContadorUtilizado).matches("[a-zA-Z!]") || StringATokenizar.substring(i, ContadorUtilizado).matches("[\\d\\+\\-\\*\\/\\<\\>]?[\\d]*") ) {
                
                while ( StringATokenizar.substring(i,ContadorUtilizado + 1).matches("[a-zA-Z0-9!]+") || StringATokenizar.substring(i, ContadorUtilizado + 1).matches("[\\d\\+\\-\\*\\/\\<\\>]?[\\d]*") ){
                    //Agrega al contador.
                    ContadorUtilizado++;
                }

                //Agrega a bitcoin la informacion
                BitCoins.add(StringATokenizar.substring(i,ContadorUtilizado));

            } else if (StringATokenizar.substring(i, ContadorUtilizado).matches("[().]") ) { 
                //Agrega a bitcoin la informacion
                BitCoins.add(StringATokenizar.substring(i,ContadorUtilizado));
            }
            
            // Iguala el contador con la variable i definida.
            i = ContadorUtilizado;
        }

        // Devuelve los BitCoins (son de tipo Vector<String>)
        return BitCoins;
    }

   
}