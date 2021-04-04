/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* calculadora.java
* Autor: Clase sección 30 EDS
*
* Interfaz calculadora
********************************************************/

import java.util.Vector;

public interface ICalculadora {

    public int suma(int x, int y);
    public int resta(int x, int y);
    public int multiplicacion(int x, int y);
    public int division(int x, int y);

    public int operar(Stack x);//operar recibe un stack en formato postfix, y lo opera para devolver un entero que es igual al valor total de la operación

    public int decode(Vector<String> fila);//función que se encarga de leer el archivo y decodificar cada línea para realizar las operaciones de cada una

}
