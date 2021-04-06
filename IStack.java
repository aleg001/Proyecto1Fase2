/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/

/**
 * iStack.java Interface
 * @author Jose Hernández
 * @author Ana Molina
 * @author Antonio Jurado
*/

public interface IStack<E> {
   /**
    * Pushes an item onto the top of this stack.
    * @param item Element to add
    */
   public void push(E item);
   // pre: 
   // post: item is added to stack
   // will be popped next if no intervening push
   
   /**
    * Removes the object at the top of this stack and returns that object as the value of this function.
    * @return Value removed
    */
   public E pop();
   // pre: stack is not empty
   // post: most recently pushed item is removed and returned
   
   /**
    * Looks at the object at the top of this stack without removing it from the stack.
    * @return he object at the top of this stack (the last item of the Vector object).
    */
   public E peek();
   // pre: stack is not empty
   // post: top value (next to be popped) is returned
   
   /**
    * Tests if this stack is empty.
    * @return true if and only if this stack contains no items; false otherwise.
    */
   public boolean empty();
   // post: returns true if and only if the stack is empty
   
   /**
    * Size of the stack
    * @return int Number
    */
   public int size();
   // post: returns the number of elements in the stack

}
 