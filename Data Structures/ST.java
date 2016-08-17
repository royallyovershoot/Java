
import java.util.ArrayList;
import java.util.Stack;

public class ST<E>
{
/*
  private LinkedList<Character> stack;
  private ArrayList<Character> stackArrayList;
 
  public ST()
  {
    this.stack = new LinkedList<Character>();
    this.stackArrayList = new ArrayList<Character>();
  }

  public void push(Character element)
  {
    this.stack.addFirst(element);
    this.stackArrayList.add(element);
    
  }
  public Character pop()
  {
    //return this.stack.removeFirst();
    return this.stackArrayList.remove(this.stackArrayList.size()-1);
    
  }*/
private ArrayList<E> stack;

public ST()
{
  this.stack = new ArrayList<E>();
}
public void push(E element)
{
  stack.add(element);
}
public E pop()
{
  return this.stack.remove(this.stack.size()-1);
}
  


  public static void main(String args[])
  {
    Stack<String> st = new Stack<String>();
    st.push("A");
    st.push("B");
    st.push("C");
    st.push("D");
    st.push("E");
    st.pop();
    st.pop();
    st.pop();
    st.pop();


  }



}
