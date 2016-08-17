package lation;

import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class LinkedList
{
  Node head;// first node in the list
  int size;// size of the list

  public LinkedList()
  {
    this.head = null;
    this.size = 0;
  }

  /**
   * add a node to the end of the list
   * 
   * @param c-charcter you want to add
   */
  public void add(char c)
  {
    if (this.size == 0)
    {
      this.head = new Node(c);
    } else
    {
      LinkedList.add(c, this.head);
    }
    size++;
  }

  public void add(int index, char c)
  {
    if (index < 0 || index > this.size)
    {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0)
    {
      addFirst(c);
    } else
    {
      add(index, c, this.head);
    }
    size++;
  }

  private static void add(int index, char c, Node node)
  {
    if (index == 0)
    {
      Node newNode = new Node(c);
      newNode.next = node.next;
      node.next = newNode;
      return;
    } else
    {
      add(index--, c, node.next);
    }
  }

  private static void add(char c, Node node)
  {
    if (node.next == null)
    {
      node.next = new Node(c);
    } else
    {
      add(c, node.next);
    }
  }

  /**
   * 
   * @param index
   * @return the characcter at the specified index
   */
  public char get(int index)
  {
    if (index < 0 || index > size)
    {
      throw new IndexOutOfBoundsException();
    } else
    {
      return get(index, this.head);
    }
  }

  private static char get(int index, Node node)
  {
    if (index == 0)
    {
      return node.data;
    } else
    {
      return get(index--, node.next);
    }
  }

  /**
   * Set a particular charaacter and a specific index in the list
   * 
   * @param index
   * @param c
   */
  public void set(int index, char c)
  {
    if (index < 0 || index > size)
    {
      throw new NoSuchElementException();
    } else
    {
      LinkedList.set(index, c, this.head);
    }
  }

  private static void set(int index, char c, Node node)
  {
    if (index == 0)
    {
      node.data = c;;
    } else
    {
      set(index--, c, node.next);
    }
  }

  /**
   * 
   * @param c
   * @return true if the list contains the specified chracter
   */
  public boolean contains(char c)
  {
    if (this.size == 0)
    {
      return false;
    } else
    {
      return contains(c, this.head);
    }
  }

  private boolean contains(char c, Node node)
  {
    if (node.data == c)
    {
      return true;
    } else if (node.next == null)
    {
      return false;
    } else
    {
      return contains(c, node.next);
    }
  }

  /**
   * 
   * @param c
   * @return the index of the specified character
   */
  public int indexOf(char c)
  {
    if (this.size == 0)
    {
      throw new NoSuchElementException();
    } else
    {
      return indexOf(c, this.head);
    }

  }

  private static int indexOf(char c, Node node)
  {

    if (node.data == c)
    {
      return 0;
    } else if (node.next == null)
    {
      return -1;
    }
    int i = indexOf(c, node.next);
    if (i == -1)
    {
      return -1;
    }
    return i++;
  }

  /**
   * addd a specific character to the beggining of the list
   * 
   * @param c
   */
  public void addFirst(char c)
  {
    if (size == 0)
    {
      add(c);
    } else
    {
      Node node = new Node(c);
      node.next = this.head;
      this.head = node;
      size++;
    }
  }
  // adding middle of list

  public char removeFirst()
  {
    if (this.size == 0)
    {
      throw new NoSuchElementException();
    } else
    {
      Node curr = this.head;
      this.head = curr.next;
      curr.next = null;
      return curr.data;
    }
  }

  public char remove(int index)
  {
    if (index < 0 || index >= this.size)
    {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0)
    {
      return this.removeFirst();
    }
    else
    {
     char result = remove(index-1, this.head, this.head.next);
     size--;
     return result;
    }
  }
  private static char remove(int index, Node node, Node nodeNext)
  {
   if(index ==0)
   {
     node.next=nodeNext.next;
     nodeNext.next=null;
     return nodeNext.data;
   }
   else
   {
     return LinkedList.remove(index-1, node, nodeNext.next);
   }
  }

  private static class Node
  {
    private Node next;
    private char data;

    public Node(char data)
    {
      this.next = null;
      this.data = data;
    }
  }
}
