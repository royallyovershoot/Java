

import java.util.LinkedList;

public class Q<E>
{
  /*private LinkedList<E> q;
  
  public Q()
  {
    this.q = new LinkedList<>();
  }
  public void enqueue(E element)
  {
    this.q.addLast(element);
  }
  public E dequeue()
  {
   return this.q.removeFirst(); 
  }
  public static void main (String argsp[])
  {
    
  }*/
  
  private LinkedList<E> q;
  
  public Q()
  {
    this.q = new LinkedList<>();
    
  }
  public void enqueue(E element)
  {
    this.q.addLast(element);
  }
  public E dequeue()
  {
     return this.q.removeFirst();
  }
}
