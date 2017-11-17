package Lab10;

/**
   The BubbleSortBenchmarker class performs a 
	bubble sort on an int array. It keeps count 
	of the number of swaps made.
   Code taken from textBook ARCHIVE
*/

public class BubbleSortBenchmarker
{
    private int array[];  // The array to sort.
    private int numSwaps; // To count the number of swaps made.
    private int numCompare;  // count the compare statements.
    private int numAssignments; // count the number of assignments.
   
    /**
      Constructor
      @param a The array to sort.
    */
   public BubbleSortBenchmarker(int a[])
   {
      array = a;
      numSwaps = 0;
      numCompare = 0;
      numAssignments = 0;
		bubbleSort();
   }

   /**
      The bubbleSort method uses the bubble sort algorithm
      to sort the array.
   */
   
   private void bubbleSort()
   {
      int maxElement;   // Marks the last element to compare
      int index;        // Index of an element to compare
      int temp;         // Used to swap to elements
      
      // The outer loop positions maxElement at the last element
      // to compare during each pass through the array. Initially
      // maxElement is the index of the last element in the array.
      // During each iteration, it is decreased by one.

      numCompare ++; // add for camprison maxElement

      for (maxElement = array.length - 1; maxElement >= 0; maxElement--)
      {
         // The inner loop steps through the array, comparing
         // each element with its neighbor. All of the elements
         // from index 0 thrugh maxElement are involved in the
         // comparison. If two elements are out of order, they
         // are swapped.
         numCompare ++;  // add for the start of the for loop
         for (index = 0; index <= maxElement - 1; index++)
         {
            // Compare an element with its neighbor.

            numCompare ++; // add comparison array [index]
            if (array[index] > array[index + 1])
            {

               // Swap the two elements.
               temp = array[index];
               array[index] = array[index + 1];
               array[index + 1] = temp;
               numSwaps++;
               numAssignments += 3;
            }
            numCompare ++; // add for compare for end of for loop.
         }
         numCompare ++; // add for end of for loop assuming it goes again.
      }
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