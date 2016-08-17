package lation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator  extends LinkedList implements Iterator<Character>
{
  private Node currNode;
  private Node prevNode;

  public LinkedListIterator()
  {
    // TODO Auto-generated constructor stub
    this.currNode = null;
    this.prevNode = null;
  }

  @Override
  public boolean hasNext()
  {
    if (this.currNode == null)
    {
      return head != null;
    }
    return this.currNode.next !=null;
  }

  @Override
  public Character next()
  {
    // TODO Auto-generated method stub
    if(!this.hasNext())
    {
      throw new NoSuchElementException();
    }
    this.prevNode = this.currNode;
    if(this.currNode == null)
    {
      this.currNode= head;
    }
    else
    {
      this.currNode = this.currNode.next;
    }
    return this.currNode.data;

  }
  public void remove()
  {
    if(this.prevNode == this.currNode)
    {
      throw new IllegalStateException();
    }
    if(this.currNode == head)
    {
      head = this.currNode.next;
    }
    else
    {
      this.prevNode.next= this.currNode.next;
    }
    this.currNode = this.prevNode;
    size--;
  }


  

}
