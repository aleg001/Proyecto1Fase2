public interface Stack<E> {

  
    public void push(E data);

 
    public E pop();


    public E peek();

    public E get(int i);

    public boolean empty();

  
    public int size();

    public void clear();

}