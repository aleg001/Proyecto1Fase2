/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* calculadora.java
* Autor: Clase sección 30 EDS
*
* Interfaz calculadora
* Fecha creacion: 03/04/21
* Ultima modificacion: 06/04/21
********************************************************/

import java.util.Vector;
import java.util.Hashtable;

/**
 * iCalculadora.java (interfaz)
 * Interfaz de calculadora
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/
public interface ICalculadora {


    // Metodos para realizar procesos de calculadora, posteriormente implementados en calculadora.
    
    
    /**
     * @param int x
    * @param int y
    * @return int Resultado de la suma
    */
    public int suma(int x, int y);

    /**
     * @param int x
    * @param int y
    * @return int Resultado de la resta
    */
    public int resta(int x, int y);

    /**
     * @param int x
    * @param int y
    * @return int Resultado de la multiplicacion
    */
    public int multiplicacion(int x, int y);

    /**
     * @param int x
    * @param int y
    * @return int Resultado de la division
    */
    public int division(int x, int y);

    /**
     * @param Stack x
    * @return int Resultado de operacion
    */
    public int operar(Stack x, Hashtable<String, String> var);//operar recibe un stack en formato postfix, y lo opera para devolver un entero que es igual al valor total de la operación
   
    /**
     * @param Vector<String> fila
    * @return int Resultado decodificado
    */
    public int decode(Vector<String> fila,Hashtable<String, String> var);//función que se encarga de leer el archivo y decodificar cada línea para realizar las operaciones de cada una

}
