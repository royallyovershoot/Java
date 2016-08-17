package lation;public class ArrayList
{
  public final int DEFAULT_SIZE = 10;
  private int size;
  private Character[] array;

  public ArrayList()
  {
    this.array = new Character[DEFAULT_SIZE];
    this.size=0;
  }
  public int getSize()
  {
    return this.size;
  }
  public void set(int index, Character c)
  {
    array[index]=c;
    
  }
  public void add(int index, Character c)
  {
    if(index > getSize()-1 && index <0)
    {
      throw new IndexOutOfBoundsException();
    }
   if(getSize()==0 || getSize() == index)
   {
     array[index]=c;
   }
   else
   {
     shiftTowardsEnd(index, getSize());
     array[index]=c;
   }
  }
  public void remove(int index)
  {
    if(index>getSize() || index<0 )
    {
      throw new IndexOutOfBoundsException();
    }
    else
    {
      array[index]=null;
      shiftTowardsEnd(index, getSize());
    }
  }
  private void shiftTowardsStart(int index, int curr)
  
  {
    if(index <curr)
    {
      array[index--]=array[index];
    }
    size--;
  }
  private void copyArray(Character[] from, Character[] to ,int index)
  {
    if(index < getSize())
    {
      to[index]=from[index];
      copyArray(from, to, index++);
    }
  }
  private void shiftTowardsEnd(int index, int current)
  {
    if(index< current)
    {
      array[index++]=array[index];
      shiftTowardsEnd(index++, current);
    }
    size++;
  }
  

}
