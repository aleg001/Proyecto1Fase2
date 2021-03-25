/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
* Autores: Ale Gomez, Marco Jurado y Ana Molina
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/

/**
 * Calculadora.java Interface
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/


public interface Calculadora 
{

    /*
    Pre: 2 ints
    Post: 1 int
    */
    public int suma(int x, int y);
      /*
    Pre:2 ints
    Post: 1 int
    */
    public int resta(int x, int y);
      /*
    Pre: 2 int
    Post: 1 int
    */
    public int multiplicacion(int x, int y);
      /*
    Pre: 2 int
    Post: 1 int
    */
    public int division(int x, int y);
  /*
    Pre: 1 stack
    Post: resultados de stack
    */
    public int operar(IStack x);
    /* Pre: 1 string
    Post: 1 string con operaciones
    */
    public String decode(String a);
 
    public boolean setImplementationType(int ImplementationType);

     }