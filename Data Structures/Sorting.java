
public class Sorting
{
/*
 * There are 4 main types of sorting
 * MergeSort
 * BubbleSort
 * SelectionSort
 * InsertionSOrt
 */
  //SelectionSort
  public static void selectionSort(int[] array)
  {
    int maxIdx;
    for(int i=array.length-1;i>0;i--)
    {
      maxIdx=i;
      for(int j=0;j<i;j++)
      {
        if(array[maxIdx]<array[j])
        {
          maxIdx=j;
        }
        int temp= array[i];
        array[i] = array[maxIdx];
        array[maxIdx]=temp;
      }
    }
  }
  public void bubbleSort(int[] sortthis)
  {
    for (int i = 0; i < sortthis.length - 1; i++)
    {
      for (int j = i + 1; j < sortthis.length - 1; j++)
      {
        if (sortthis[j] < sortthis[i])
        {
          // swap
          int hold = sortthis[i];
          sortthis[i] = sortthis[j];
          sortthis[j] = hold;
        }
      }
    }
  }
  
public static void InsertionSort(int arr[])
    {
  
  for(int i=arr.length-2;i>=0;i--)
  {
    int key = arr[i];
    int j=i;
    while(j<arr.length-1 && arr[j+1]<key)
    {
      arr[j]=arr[j+1];
      j++;
    }
    arr[j]=key;

  }
    }
	//see MergeSort.java for Merge Sort Alogrithm which has  O(n log n).
	
 
}
