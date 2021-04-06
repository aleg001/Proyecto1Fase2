import java.util.Vector;
import java.util.Hashtable;

/***************************************************************
* Calculadora.java
* Autor: Ale, Pao, Maco
* Universidad del Valle de Guatemala
* Autores: Ale Gomez, Marco Jurado y Ana Molina
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/

/**
 * Calculadora.java 
 * Clase Calculadora donde se implementa la interfaz y se realizan los procesos correspondientes.
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/


public class Calculadora implements ICalculadora {
  //-------------------------------------------------Atributos--------------------------------------

  int numerox; 
  int numeroy; 
  int resultadoxy; 
  String elemento_pila;

  //-------------------------------------------------Metodos----------------------------------------

  /**
  * @param int x
  * @param int y
  * @return int Resultado de la suma
  */
  @Override
  public int suma(int x, int y) {
      // Se deben de ingresar dos numero para realizar la suma. 
      int retorno = x + y;
      return retorno;
  }


  /**
  * @param int x
  * @param int y
  * @return int Resultado de la resta
  */
  @Override
  public int resta(int x, int y) {
      // Se deben de ingresar dos numeros para su resta. NO Conmutativa 
      // X primer numero
      // Y numero que se resta a X a.k.a segundo numero
      int retorno = x - y;
      return retorno;
  }


  /**
  * @param int x
  * @param int y
  * @return int Resultado de la multiplicacion
  */
  @Override
  public int multiplicacion(int x, int y) {
      // Se deben de ingresar dos numeros para la multiplicacion
      int retorno = x * y;
      return retorno;
  }

  /**
  * @param int x
  * @param int y
  * @return int Resultado de la division
  */
  @Override
  public int division(int x, int y) {
      // Se deben de ingresar dos valores para la division. NO Conmutativa
      // X numero 1, dividendo
      // Y numero 2, divisor
      int retorno = x / y;
      return retorno;
  }


  /**
  * @param int stack
  * @return int Resultado de la operacion realizada
  */
  @Override
  public int operar(Stack x, Hashtable<String, String> variables) {
      // Proceso de operar que toma los datos del Stack y realiza las operaciones 
      // identificadas. Devuelve un resultado de la operación

      if (x.size() == 0) {
          //El stack está vacio... no hay nada que operar. Devuelve un 0 para indicar el resultado. 
          return 0;
      }

      Stack procedimiento = new Stack(); //Stack para realizar los procesos de operacion

      while (x.empty() != true) {
          //Sigue operando hasta que el stack esté vacio y no haya mas por hacer

          //Las tres posiciones numericas basicas a utliizar en todo momento. Solo se tienen 3 pues solo hace una operacion a la vez.
      

        try {
            elemento_pila = x.pop().toString();
        } catch (Exception C) {
            System.out.println("Error de sistema.");
        }

          switch (elemento_pila) {
              //Diferentes casos que pueden ocurrir. Se realiza la operacion correcta en el caso de encontrar el operador.
              case "0":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "1":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "2":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "3":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "4":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "5":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "6":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;
                  
              case "7":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "8":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "9":
                  procedimiento.push(elemento_pila); //agrega el numero a la pila de procedimiento hasta encontrar operador
                  break;

              case "+": 
                  //Caso especial que sea un operador de suma. Ejecuta el método de suma

                  try{
                      numerox = Integer.parseInt(procedimiento.pop());

                  } catch (Exception e) {
                  } 
                  
                  try{                    
                    numeroy = Integer.parseInt(procedimiento.pop());
                    } catch (Exception e) {
 
                } 
                  resultadoxy = suma(numerox, numeroy);
                  String resultadoxy_string = String.valueOf(resultadoxy);
                  procedimiento.push(resultadoxy_string);
                  break;

              case "-": 
                  //Caso especial que sea un operador de resta. Ejecuta el método de suma
                  try {
                      numerox = Integer.parseInt(procedimiento.pop());

                      numeroy = Integer.parseInt(procedimiento.pop());
                  } catch (Exception e) { 
                      System.out.println("Error! Falla total.");
                    } 
                  
                  resultadoxy = resta(numerox, numeroy);
                  String resultadoxy_string_2 = String.valueOf(resultadoxy);
                  procedimiento.push(resultadoxy_string_2);
                  break;

              case "*": 
                  //Caso especial que sea un operador de multiplicacion. Ejecuta el método de suma
                  try {
                      numerox = Integer.parseInt(procedimiento.pop());

                      numeroy = Integer.parseInt(procedimiento.pop());
                  } catch (Exception e) {
                      System.out.println("Error! Falla total.");
                    } 
                  
                  resultadoxy = multiplicacion(numerox, numeroy);
                  String resultadoxy_string_3 = String.valueOf(resultadoxy);
                  procedimiento.push(resultadoxy_string_3);
                  break;

              case "/": 
                  // Caso especial que sea un operador de division. Ejecuta el método de suma
                  try{
                      numerox = Integer.parseInt(procedimiento.pop());

                      numeroy = Integer.parseInt(procedimiento.pop());
                  } catch (Exception e) { 
                      System.out.println("Error! Falla total. uwu");
                    } 
                  
                  resultadoxy = division(numerox, numeroy);
                  String resultadoxy_string_4 = String.valueOf(resultadoxy);
                  procedimiento.push(resultadoxy_string_4);
                    break;

          }

      }

      int fin = Integer.parseInt(procedimiento.pop()); // Resultado final de la operacion
      return fin;       
  }

  public int decode (Vector<String> fila, Hashtable<String, String> variablesEntorno) {

    // Enviar esos characteres a un nuevo stack. 
    Stack pila_datos = new Stack();

    // Recorrer todo el vector
    for (int i = 0; i < fila.size()-1; i++) {
      // Si hay una letra
        if(!fila.get(i).matches("[0-9]+")) {
          // Buscar entre las variables
          if(variablesEntorno.containsKey(fila.get(i))) {
            fila.set(i, variablesEntorno.get(fila.get(i)));
          }
        }
  
    }

    for (int i = 0; i < fila.size()-1; i++) { 
        // Recorre todo el vector para meterlo al nuevo Stack ignorando los parentesis
        String data = fila.get(i); // Mete cada dato a la pila para tener el orden del Stack Fifo.
        pila_datos.push(data);
    }

    int resultado_operar = operar(pila_datos, variablesEntorno);

    return resultado_operar;
  }

}