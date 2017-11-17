package Lab10;

/**
   The QuickSortBenchmarker class performs a 
	Quicksort on an int array. It keeps count 
	of the number of swaps made.
*/

public class QuickSortBenchmarker
{
   private int array[];  // The array to sort
   private int numSwaps; // To count the number of swaps made
   private int numCompare;  // count the compare statements.
   private int numAssignments; // count the number of assignments.
   
   /**
      Constructor
      @param a The array to sort.
   */
   
   public QuickSortBenchmarker(int a[])
   {
      array = a;
      numSwaps = 0;
      numCompare = 0;
      numAssignments = 0;
      doQuickSort(array, 0, array.length - 1);
   }

   /**
      The doQuickSort method uses the QuickSort algorithm
      to sort the array.
      @param array The array to sort.
      @param start The starting subscript of the list to sort
      @param end The ending subscript of the list to sort
   */
   
   private void doQuickSort(int array[], int start, int end)
   {
      int pivotPoint;
      
      if (start < end)
      {
         // Get the pivot point.
         pivotPoint = partition(array, start, end);
         numAssignments++; //count 1 assignment for pivotPoint
         
         // Sort the first sub list.
         doQuickSort(array, start, pivotPoint - 1);
         
         // Sort the second sub list.
         doQuickSort(array, pivotPoint + 1, end);
      }
      numCompare++; // count if comparison
   }

   /**
      The partiton method selects a pivot value in an array
      and arranges the array into two sub lists. All the
      values less than the pivot will be stored in the left
      sub list and all the values greater than or equal to
      the pivot will be stored in the right sub list.
      @param array The array to partition.
      @param start The starting subscript of the area to partition.
      @param end The ending subscript of the area to partition.
      @return The subscript of the pivot value.
   */
   
   private int partition(int array[], int start, int end)
   {
      int pivotValue;    // To hold the pivot value
      int endOfLeftList; // Last element in the left sub list.
      int mid;           // To hold the mid-point subscript

      // Find the subscript of the middle element.
      // This will be our pivot value.
      mid = (start + end) / 2;

      // Swap the middle element with the first element.
      // This moves the pivot value to the start of 
      // the list.
      swap(array, start, mid);

      // Save the pivot value for comparisons.
      pivotValue = array[start];
      
      // For now, the end of the left sub list is
      // the first element.
      endOfLeftList = start;
      
      // Scan the entire list and move any values that
      // are less than the pivot value to the left
      // sub list.
      numCompare++; //count comparison for 1st iteration of for loop
      for (int scan = start + 1; scan <= end; scan++)
      {
         if (array[scan] < pivotValue)
         {
            endOfLeftList++;
            swap(array, endOfLeftList, scan);
         }
         numCompare++; //count 'if' comparison
         numCompare++; // count 'for' comparison for each iteration
      }
      
      // Move the pivot value to end of the
      // left sub list.
      swap(array, start, endOfLeftList);
      numAssignments += 3; //count mid, piovtValue, endOfList assignments
      // Return the subscript of the pivot value.
      return endOfLeftList;
   }

   /**
      The swap method swaps the contents of two elements
      in an int array.
      @param The array containing the two elements.
      @param a The subscript of the first element.
      @param b The subscript of the second element.
   */
   
   private void swap(int[] array, int a, int b)
   {
      int temp;
      
      temp = array[a];
      array[a] = array[b];
      array[b] = temp;
      numSwaps++;
      numAssignments += 3; //add 3 assignments used to make the swap
   }

   /**
      The getNumSwaps method returns the number of
      swaps made.
      @return The number of swaps made.
   */
   
   public int getNumSwaps()
   {
      return numSwaps;
   }

   public int getNumCompare () { return numCompare; }

   public int getNumAssignments () { return numAssignments; }
}