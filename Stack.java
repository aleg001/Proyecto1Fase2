/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Stack.java
* Autor: Marco Jurado 
* Autor: Ana Paola de Leon
* Autor: Alejandro Gómez
*
* Interfaz Calculadora
* Interface de la calculadora
********************************************************/

import java.util.Vector;
/**
 * Stack.java
 * Clase usada para los procesos de stack
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/
public class Stack implements IStack<String> {

    //----------------------------------------------------- Atributos ----------------------------------------------------------

    private Vector<String> stack; 

    //----------------------------------------------------- Metodos ----------------------------------------------------------

    /**
    * Constructor for StackImplementation class 
    */
    public Stack (){
        this.stack = new Vector<String>();
    }

    /**
    * @author Jose Hernández
    * @author Ana Molina
    * @author Antonio Jurado 
    * @param String dato
    * @return void
    */
    @Override
    public void push(String dato) {
        stack.add(dato);
    }

    /**
    * @author Jose Hernández
    * @author Ana Molina
    * @author Antonio Jurado
    * @return String 
    */
    @Override
    public String pop() {
        if (empty()){
            return null;
            
        } else {
            return stack.remove(this.stack.size() - 1);
        }
    }

    /**
    * @author Jose Hernández
    * @author Ana Molina
    * @author Antonio Jurado
    * @return String 
    */
    @Override
    public String peek() {
        if (empty()){
            return null;
            
        } else {
            return this.stack.get(this.stack.size() - 1);
        }
    }

    /**
    * @author Jose Hernández
    * @author Ana Molina
    * @author Antonio Jurado
    * @return Boolean, verifica si esta vacio o no. Devuelve True o False dependiendo si stack tiene o no contenidos
    */
    @Override
    public boolean empty() {
        return (stack.isEmpty());
    }

    /**
    * @author Jose Hernández
    * @author Ana Molina
    * @author Antonio Jurado
    * @return int, devuelve el tamaño del stack 
    */
    @Override
    public int size() {
        return stack.size();
    }
}